package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ResultHelper {
	
	@Autowired
	private DataVo data;
	
	@Autowired
	private SupportVo support;

	public DataVo getData() {
		return data;
	}

	public void setData(DataVo dataVo) {
		this.data = dataVo;
	}

	public SupportVo getSupport() {
		return support;
	}

	public void setSupport(SupportVo supportVo) {
		this.support = supportVo;
	}

	@Override
	public String toString() {
		return "ResultHelper [dataVo=" + data + ", supportVo=" + support + "]";
	}
	
	

}
