package com.github.leventarican;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("heartbeat")
public class HeartbeatResource {
    @GET
    public String ping() {
        return String.format("heartbeat: %d", System.currentTimeMillis());
    }
}
