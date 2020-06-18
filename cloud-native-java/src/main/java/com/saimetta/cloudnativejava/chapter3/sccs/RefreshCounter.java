package com.saimetta.cloudnativejava.chapter3.sccs;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RefreshCounter {

	private final Log log = LogFactory.getLog(getClass());
	private final AtomicLong counter = new AtomicLong(0);
	
	@EventListener
	public void refresh(RefreshScopeRefreshedEvent e) {
		log.info("the refresh count is now at: "+ counter.incrementAndGet());
	}
}
