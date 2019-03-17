package com.spacex.renaissance.gateway.filter.post;

import com.spacex.renaissance.gateway.filter.RenaissanceFilter;
import com.spacex.renaissance.gateway.http.RequestContext;
import com.spacex.renaissance.gateway.http.ResponseEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class SendResponseFilter extends RenaissanceFilter {
    public String filterType() {
        return "post";
    }

    public int filterOrder() {
        return 1000;
    }

    public void run() {

    }

    private void addResponseHeader() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse httpServletResponse = requestContext.getResponse();
        ResponseEntity responseEntity = requestContext.getResponseEntity();

        // add header logic

    }

    private void writeResponse() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse httpServletResponse = requestContext.getResponse();
        if (httpServletResponse.getCharacterEncoding() == null) {
            httpServletResponse.setCharacterEncoding("utf-8");
        }
        ResponseEntity responseEntity = requestContext.getResponseEntity();

        //set if response has body

        String body = "";//mock

        try {
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();
            outputStream.write(body.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
