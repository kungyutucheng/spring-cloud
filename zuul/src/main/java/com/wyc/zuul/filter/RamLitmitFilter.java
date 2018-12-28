package com.wyc.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author: wyc
 * @date: 2018/12/28
 */
@Component
public class RamLitmitFilter extends ZuulFilter {

    private static final RateLimiter RATELIMITER = RateLimiter.create(10);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if(!RATELIMITER.tryAcquire()){
            throw new ZuulException("fsadf",100,"dsa");
        }
        return null;
    }
}
