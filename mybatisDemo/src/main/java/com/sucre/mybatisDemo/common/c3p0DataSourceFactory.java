package com.sucre.mybatisDemo.common;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 自定义数据源,继承UnpooledDataSourceFactory类
 * @author Administrator
 *
 */
public class c3p0DataSourceFactory extends UnpooledDataSourceFactory{
	
	/**
	 * 构造方法,定义c3p0为数据源
	 */
	 public c3p0DataSourceFactory(){
	        this.dataSource=new ComboPooledDataSource();
	    }
}
