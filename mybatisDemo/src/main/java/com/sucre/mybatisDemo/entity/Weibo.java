package com.sucre.mybatisDemo.entity;

import java.util.Date;

/**
 * 这是一个对应数据表的weibo类,POJO简单java类
 * @author sucre
 *
 */
public class Weibo {
	private int id;
	private String token;
	private Date postday;
	private String postip;
	private String mid;
	private String nickname;
	private String avater;
	private String content;
	private String picurl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getPostday() {
		return postday;
	}
	public void setPostday(Date postday) {
		this.postday = postday;
	}
	public String getPostip() {
		return postip;
	}
	public void setPostip(String postip) {
		this.postip = postip;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	@Override
	public String toString() {
		return "Weibo [id=" + id + ", token=" + token + ", postday=" + postday.toLocaleString() + ", postip=" + postip + ", mid=" + mid
				+ ", nickname=" + nickname + ", avater=" + avater + ", content=" + content + ", picurl=" + picurl + "]";
	}
	
}
