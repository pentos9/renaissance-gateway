package com.spacex.renaissance.gateway.filter.post;

import com.spacex.renaissance.gateway.filter.RenaissanceFilter;

public class SendResponseFilter extends RenaissanceFilter {
    public String filterType() {
        return "post";
    }

    public int filterOrder() {
        return 1000;
    }

    public void run() {

    }
}
