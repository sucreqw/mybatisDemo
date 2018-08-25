package com.sucre.mybatisDemo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 通用的dao类接口,由mybatis实现
 * @author sucre
 *
 */
public interface BaseDao {
	
	/**
	 * 向数据库增加数据 
	 * @param table 表名
	 * @param params 对象的hashmap
	 */
	public void addEntity(@Param("table")String table,@Param("params")HashMap<String, Object> params);
	
	/**
	 * 删除数据库的一条记录
	 * @param id
	 */
	public void deleteEntity(@Param("table")String table,@Param("id")int id);
	
	/**
	 * 更新一条数据
	 * @param table 表名
	 * @param id 主键 
	 * @param params 对象的hashmap
	 */
	public void updataEntity(@Param("table")String table,@Param("id")int id,@Param("params")HashMap<String, Object> params);
	/**
	 * 向数据库查询数据
	 * @param table 表名
	 * @param id 主键
	 * @return
	 */
	public HashMap selectById(@Param("table")String table,@Param("id")int id);
	
	/**
	 * 模糊查询指定字段
	 * @param table 表名
	 * @param field 字段名
	 * @param query 查询字符
	 * @return 
	 */
	public List<HashMap> search(@Param("table")String table,@Param("field")String field,@Param("query")String query);
	
}
