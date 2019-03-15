package com.spacex.renaissance.gateway.http;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

public class RequestContext extends ConcurrentHashMap<String, Object> {
    protected static Class<? extends RequestContext> contextClass = RequestContext.class;

    protected static final ThreadLocal<? extends RequestContext> threadLocal = new ThreadLocal<RequestContext>() {
        @Override
        protected RequestContext initialValue() {
            try {
                return contextClass.newInstance();
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    };

    public static RequestContext getCurrentContext() {
        RequestContext requestContext = threadLocal.get();
        return requestContext;
    }

    public void setRequest(HttpServletRequest httpServletRequest) {
        put("request", httpServletRequest);
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) get("request");
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse) get("response");
    }

    public void setResponse(HttpServletResponse response) {
        put("response", response);
    }

    public void setRequestEntity(RequestEntity requestEntity) {
        put("requestEntity", requestEntity);
    }

    public RequestEntity getRequestEntity(RequestEntity requestEntity) {
        return (RequestEntity) get("requestEntity");
    }

    public void setResponseEntity(ResponseEntity responseEntity) {
        put("responseEntity", responseEntity);
    }

    public ResponseEntity getResponseEntity() {
        return (ResponseEntity) get("responseEntity");
    }

    public void set(String key, String value) {
        if (value != null) {
            put(key, value);
        } else {
            remove(key);
        }
    }

    public void unset() {
        threadLocal.remove();
    }
}
