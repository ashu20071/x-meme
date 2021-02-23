package com.javaeeeee.dwstart.resources;

import org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;
import org.skife.jdbi.v2.exceptions.UnableToObtainConnectionException;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

public abstract class XmemeService {
    private static final Logger logger = LoggerFactory.getLogger(XmemeService.class);

    private static final String DATABASE_ACCESS_ERROR =
            "Could not reach the MySQL database. The database may be down or there may be network connectivity issues. Details: ";
    private static final String DATABASE_CONNECTION_ERROR =
            "Could not create a connection to the MySQL database. The database configurations are likely incorrect. Details: ";
    private static final String UNEXPECTED_DATABASE_ERROR =
            "Unexpected error occurred while attempting to reach the database. Details: ";
    private static final String SUCCESS = "Success";
    private static final String UNEXPECTED_DELETE_ERROR = "An unexpected error occurred while deleting meme.";
    private static final String XMEME_NOT_FOUND = "Meme id %s not found.";

    @CreateSqlObject
    abstract XmemeDao xMemeDao();

    public List<XmemeInfo> getXmemes() {
        return xMemeDao().getXmemes();
    }

    public XmemeInfo getXmeme(long xmemeId) {
        XmemeInfo xmemeInfo = xMemeDao().getXmemeInfo(xmemeId);
        if (Objects.isNull(xmemeInfo))
            throw new WebApplicationException(String.format(XMEME_NOT_FOUND, xmemeId), Response.Status.NOT_FOUND);
        return xmemeInfo;
    }

    public XmemeInfo createXmeme(XmemeInfo xmemeInfo) {
        xMemeDao().createXmemeInfo(xmemeInfo);
        return xMemeDao().getXmemeInfo(xMemeDao().lastInsertId());
    }

    public XmemeInfo editXmeme(XmemeInfo xmemeInfo) {
        if (Objects.isNull(xMemeDao().getXmemeInfo(xmemeInfo.getXmemeId()))) {
            throw new WebApplicationException(String.format(XMEME_NOT_FOUND, xmemeInfo.getXmemeId()),
                    Response.Status.NOT_FOUND);
        }
        xMemeDao().editXmemeInfo(xmemeInfo);
        return xMemeDao().getXmemeInfo(xmemeInfo.getXmemeId());
    }

    public String deleteXmeme(final long xmemeId) {
        int result = xMemeDao().deleteXmemeInfo(xmemeId);
        logger.info("Result in XmemeService.deleteXmemeInfo is: {}", result);
        switch (result) {
            case 1:
                return SUCCESS;
            case 0:
                throw new WebApplicationException(String.format(XMEME_NOT_FOUND, xmemeId), Response.Status.NOT_FOUND);
            default:
                throw new WebApplicationException(UNEXPECTED_DELETE_ERROR, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public String performHealthCheck() {
        try {
            xMemeDao().getXmemes();
        } catch (UnableToObtainConnectionException ex) {
            return checkUnableToObtainConnectionException(ex);
        } catch (UnableToExecuteStatementException ex) {
            return checkUnableToExecuteStatementException(ex);
        } catch (Exception ex) {
            return UNEXPECTED_DATABASE_ERROR + ex.getCause().getLocalizedMessage();
        }
        return null;
    }

    private String checkUnableToObtainConnectionException(UnableToObtainConnectionException ex) {
        if (ex.getCause() instanceof java.sql.SQLNonTransientConnectionException) {
            return DATABASE_ACCESS_ERROR + ex.getCause().getLocalizedMessage();
        } else if (ex.getCause() instanceof java.sql.SQLException) {
            return DATABASE_CONNECTION_ERROR + ex.getCause().getLocalizedMessage();
        } else {
            return UNEXPECTED_DATABASE_ERROR + ex.getCause().getLocalizedMessage();
        }
    }

    private String checkUnableToExecuteStatementException(UnableToExecuteStatementException ex) {
        if (ex.getCause() instanceof java.sql.SQLSyntaxErrorException) {
            return DATABASE_CONNECTION_ERROR + ex.getCause().getLocalizedMessage();
        } else {
            return UNEXPECTED_DATABASE_ERROR + ex.getCause().getLocalizedMessage();
        }
    }
}
