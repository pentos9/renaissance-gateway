package com.spacex.renaissance.gateway.filter.route;

import com.spacex.renaissance.gateway.filter.RenaissanceFilter;

public class RoutingFilter extends RenaissanceFilter {
    public String filterType() {
        return "route";
    }

    public int filterOrder() {
        return 0;
    }

    public void run() {

    }
}
