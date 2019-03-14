package com.spacex.renaissance.gateway.filter.pre;

import com.spacex.renaissance.gateway.filter.RenaissanceFilter;

public class RequestWrapperFilter extends RenaissanceFilter {
    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return -1;
    }

    public void run() {

    }
}
