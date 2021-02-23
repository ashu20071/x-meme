package com.javaeeeee.dwstart.resources;

import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/memes")
@Produces(MediaType.APPLICATION_JSON)
public class XmemeResource {
    private final XmemeService xmemeService;

    public XmemeResource(XmemeService xmemeService) {
        this.xmemeService = xmemeService;
    }

    @GET
    @Timed
    public Response getXmeme(@QueryParam("id") final Long xmemeId) {
        if (xmemeId != null)
            return Response.ok(xmemeService.getXmeme(xmemeId)).build();
        else
            return Response.ok(xmemeService.getXmemes()).build();
    }

    @POST
    @Timed
    public Response createXmeme(@NotNull @Valid final XmemeInfo xmemeInfo) {
        XmemeInfo newXmemeInfo = new XmemeInfo(xmemeInfo.getXmemeName(), xmemeInfo.getXmemeCaption(), xmemeInfo.getXmemeUrl());
        return Response.ok(xmemeService.createXmeme(newXmemeInfo)).build();
    }

    @PUT
    @Timed
    public Response editXmeme(@QueryParam("id") final Long xmemeId, @NotNull @Valid final XmemeInfo xmemeInfo) {
        xmemeInfo.setXmemeId(xmemeId);
        return Response.ok(xmemeService.editXmeme(xmemeInfo)).build();
    }

    @DELETE
    @Timed
    public Response deleteXmeme(@QueryParam("id") final Long xmemeId) {
        Map<String, String> response = new HashMap<>();
        response.put("status", xmemeService.deleteXmeme(xmemeId));
        return Response.ok(response).build();
    }

}
