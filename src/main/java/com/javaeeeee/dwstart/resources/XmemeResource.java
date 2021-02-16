package com.javaeeeee.dwstart.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/memes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
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
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void postMeme(@QueryParam("xmemeName") String name, @QueryParam("xmemeUrl") String url, @QueryParam("xmemeCaption") String caption) {
        dbClass.addMeme(new XmemeInfo(memeId.incrementAndGet(), new XmemeRequest(name, url, caption)));
    }
}
