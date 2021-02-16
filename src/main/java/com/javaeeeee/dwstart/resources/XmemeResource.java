package com.javaeeeee.dwstart.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

@Path("/memes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class XmemeResource {
    DbClass dbClass = new DbClass();
    private final AtomicLong memeId;
    private  String name;
    private  String url;
    private  String caption;

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
    public Response getMeme(@QueryParam("id") Long id) {
        if (dbClass.getMemes().containsKey(id)) {
            return  Response.ok().entity(dbClass.getMemes().get(id)).build();
        }
//        long newId = memeId.incrementAndGet();
//        dbClass.getMemes().put(newId, new XmemeInfo(newId, new XmemeRequest(name, url, caption)));


        return Response.ok().entity(dbClass.getXMemes().values()).build();

    }

    @POST
    @Timed
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void postMeme(@QueryParam("xmemeName") String name, @QueryParam("xmemeUrl") String url, @QueryParam("xmemeCaption") String caption) {
        dbClass.addMeme(new XmemeInfo(memeId.incrementAndGet(), new XmemeRequest(name, url, caption)));
    }
}
