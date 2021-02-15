package com.javaeeeee.dwstart.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/memes")
@Produces(MediaType.APPLICATION_JSON)
public class XmemeResource {
    DbClass dbClass = new DbClass();
    private final AtomicLong memeId;
    private final String name;
    private final String url;
    private final String caption;

    public XmemeResource(String name, String caption, String url) {
        this.memeId = new AtomicLong();
        this.name = name;
        this.url = url;
        this.caption = caption;
    }

    @GET
    @Timed
    public XmemeInfo getMeme(@QueryParam("id") Long id) {
        if (dbClass.getMemes().containsKey(id)) {
            return dbClass.getMemes().get(id);
        }
        long newId = memeId.incrementAndGet();
        dbClass.getMemes().put(newId, new XmemeInfo(newId, new XmemeRequest(name, url, caption)));
        return dbClass.getMemes().get(newId);
    }

    @POST
    @Timed
    public void postMeme(@QueryParam("name") String name, @QueryParam("url") String url, @QueryParam("caption") String caption) {
        dbClass.addMeme(new XmemeInfo(memeId.incrementAndGet(), new XmemeRequest(name, url, caption)));
    }
}
