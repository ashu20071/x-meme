package com.javaeeeee.dwstart.resources;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class XmemeMapper implements ResultSetMapper<XmemeInfo> {
    private static final String id = "id";
    private static final String xmemeName = "xmemeName";
    private static final String xmemeCaption = "xmemeCaption";
    private static final String xmemeUrl = "xmemeUrl";

    public XmemeInfo map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        XmemeInfo xmemeInfo =  new XmemeInfo(resultSet.getString(xmemeName),
                resultSet.getString(xmemeCaption), resultSet.getString(xmemeUrl));
        xmemeInfo.setXmemeId(resultSet.getLong(id));
        return xmemeInfo;
    }
}

