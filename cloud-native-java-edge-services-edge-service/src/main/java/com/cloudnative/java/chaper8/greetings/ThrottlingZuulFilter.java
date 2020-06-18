package com.cloudnative.java.chaper8.greetings;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Profile("throttled")
@Component
public class ThrottlingZuulFilter extends ZuulFilter {
	
	private final HttpStatus tooManyRequests = HttpStatus.TOO_MANY_REQUESTS;
	private final RateLimiter rateLimiter;
	private Log log = LogFactory.getLog(getClass());
	
	public ThrottlingZuulFilter(RateLimiter rateLimiter) {
		this.rateLimiter = rateLimiter;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info(">>>>>ThrottlingZuulFilter");
		try {
			RequestContext requestContext = RequestContext.getCurrentContext();
			log.info(">>>>>ThrottlingZuulFilter "+requestContext.toString());
			HttpServletResponse response = requestContext.getResponse();
			if (!rateLimiter.tryAcquire()) {
				//If false, generate the too many requests response
				response.setContentType(MediaType.TEXT_PLAIN_VALUE);
				response.setStatus(tooManyRequests.value());
				response.getWriter().append(tooManyRequests.getReasonPhrase());
				//Abort proying the request
				requestContext.setSendZuulResponse(false);
				//Had to comment this one b/c it break 
//				throw new ZuulException(tooManyRequests.getReasonPhrase(), tooManyRequests.value(), tooManyRequests.getReasonPhrase());
			}
		}catch (Exception e) {
			ReflectionUtils.rethrowRuntimeException(e);
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

}
