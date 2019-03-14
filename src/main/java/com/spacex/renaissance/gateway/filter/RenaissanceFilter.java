package com.spacex.renaissance.gateway.filter;

public abstract class RenaissanceFilter {
    abstract public String filterType();

    abstract public int filterOrder();

    abstract public void run();
}
