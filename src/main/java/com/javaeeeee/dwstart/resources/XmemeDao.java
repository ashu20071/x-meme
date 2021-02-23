package com.javaeeeee.dwstart.resources;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(XmemeMapper.class)
public interface XmemeDao {

    @SqlQuery("select * from memes;")
    List<XmemeInfo> getXmemes();

    @SqlQuery("select * from memes where id = :id")
    XmemeInfo getXmemeInfo(@Bind("id") final long xmemeId);

    @SqlUpdate("insert into memes(xmemeName, xmemeCaption, xmemeUrl) values (:xmemeName, :xmemeCaption, :xmemeUrl)")
    void createXmemeInfo(@BindBean final XmemeInfo xmemeInfo);

    @SqlUpdate("update memes set xmemeName = coalesce(:xmemeName, xmemeName), " +
            "xmemeCaption = coalesce(:xmemeCaption, xmemeCaption), xmemeUrl = coalesce(:xmemeUrl, xmemeUrl)" +
            "where id = :xmemeId")
    void editXmemeInfo(@BindBean final XmemeInfo xmemeInfo);

    @SqlUpdate("delete from memes where id = :id")
    int deleteXmemeInfo(@Bind("id") long xmemeId);

    @SqlQuery("select last_insert_id()")
    long lastInsertId();

}
