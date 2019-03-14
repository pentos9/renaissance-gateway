package com.spacex.renaissance.gateway.http;

import com.spacex.renaissance.gateway.filter.RenaissanceFilter;
import com.spacex.renaissance.gateway.filter.pre.RequestWrapperFilter;
import com.spacex.renaissance.gateway.filter.route.RoutingFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RenaissanceRunner {

    private ConcurrentHashMap<String, List<RenaissanceFilter>> hashFilterByType = new ConcurrentHashMap<String, List<RenaissanceFilter>>() {{
        put("pre", new ArrayList<RenaissanceFilter>() {
            {
                add(new RequestWrapperFilter());
            }
        });

        put("route", new ArrayList<RenaissanceFilter>() {
            {
                add(new RoutingFilter());
            }
        });

        put("pre", new ArrayList<RenaissanceFilter>() {
            {
                add(new RequestWrapperFilter());
            }
        });
    }};

    public void preRoute() {
        runFilter("pre");
    }

    public void route() {
        runFilter("route");
    }

    public void postRoute() {
        runFilter("post");
    }


    public void init(HttpServletRequest request, HttpServletResponse response) {

    }

    public void runFilter(String sType) {
        List<RenaissanceFilter> filters = this.hashFilterByType.get(sType);
        if (filters != null && filters.size() > 0) {
            filters.forEach(filter -> {
                filter.run();
            });
        }
    }


}
