package com.qaprosoft.carina.core.demo.util;

import com.qaprosoft.carina.core.foundation.performance.Timer.IPerformanceOperation;

public enum PO implements IPerformanceOperation {
	
	CREATE_USER, GET_USER, DELETE_USER;

	@Override
	public String getKey() {
		return name(); 
	}
}
