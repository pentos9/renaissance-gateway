package com.spacex.renaissance.gateway.filter.route;

import com.spacex.renaissance.gateway.filter.RenaissanceFilter;
import com.spacex.renaissance.gateway.http.RequestContext;
import com.spacex.renaissance.gateway.http.RequestEntity;

public class RoutingFilter extends RenaissanceFilter {
    public String filterType() {
        return "route";
    }

    public int filterOrder() {
        return 0;
    }

    public void run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        RequestEntity requestEntity = ctx.getRequestEntity();
        // route logic

        //ctx.setResponseEntity(responseEntity);
    }
}
