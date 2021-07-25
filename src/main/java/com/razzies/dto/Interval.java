package com.razzies.dto;

import java.util.ArrayList;
import java.util.List;

public class Interval {

	private List<Award> min = new ArrayList<Award>();

	private List<Award> max  = new ArrayList<Award>();

	public List<Award> getMin() {
		return min;
	}

	public void setMin(List<Award> min) {
		this.min = min;
	}

	public List<Award> getMax() {
		return max;
	}

	public void setMax(List<Award> max) {
		this.max = max;
	}
	
}
