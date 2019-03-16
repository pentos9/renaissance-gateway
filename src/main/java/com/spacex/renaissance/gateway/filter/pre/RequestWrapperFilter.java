package com.spacex.renaissance.gateway.filter.pre;

import com.spacex.renaissance.gateway.filter.RenaissanceFilter;
import com.spacex.renaissance.gateway.http.RequestContext;
import com.spacex.renaissance.gateway.http.RequestEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RequestWrapperFilter extends RenaissanceFilter {
    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return -1;
    }

    public void run() {
        String rootURL = "http://localhost:9090";
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest servletRequest = requestContext.getRequest();

        String targetURL = rootURL + servletRequest.getRequestURI();
        RequestEntity<byte[]> requestEntity = null;
        try {
            requestEntity = createRequestEntity(servletRequest, targetURL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        requestContext.setRequestEntity(requestEntity);

    }

    private RequestEntity<byte[]> createRequestEntity(HttpServletRequest servletRequest, String targetURL) {
        String requestMethod = servletRequest.getMethod();
        return null;
    }

    private Map<String, String> createRequestHeaders(HttpServletRequest request) {
        return null;
    }
}
