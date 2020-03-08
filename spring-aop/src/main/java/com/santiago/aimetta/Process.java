package com.santiago.aimetta;

import org.springframework.stereotype.Component;

import com.santiago.aimetta.aop.LogExecutionTime;

@Component
public class Process {

	@LogExecutionTime
	public void processThatTakes2Seconds() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@LogExecutionTime
	public int processThatTakes1Second() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 10;
	}
	
	@LogExecutionTime
	public void processThatTakesHalfSecond() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

