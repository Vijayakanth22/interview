package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SupportVo {
	private String url;
	private String text;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "SupportVo [url=" + url + ", text=" + text + "]";
	}
	
}
