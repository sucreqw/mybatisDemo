package com.sucre.mybatisDemo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * baseDao的实现类
 * 
 * @author sucre
 *
 */
public class BaseDaoimpl implements BaseDao {
	
	//xml配置文件(全局配置文件)
	String resource = "mybatis-config.xml";
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	SqlSession session;
	//mybatis的dao类
	BaseDao mapper;
    /**
     * 初始化参数
     */
	public void init() {
        if(session!=null) {return;}
		try (
				// 根据xml配置文件(全局配置文件) 创建一个sqlSessionFactory对象
				InputStream inputStream = Resources.getResourceAsStream(resource);

		) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 获取sqlSession实例,能直接执行已经映射的sql语句.
			session = sqlSessionFactory.openSession();
			//映射接口类.
			mapper = session.getMapper(BaseDao.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {
		if(session!=null) { 
		session.commit();
		session.close();
		}
	}

	public void addEntity(String table, HashMap<String, Object> params) {
		mapper.addEntity(table, params);
	}

	public void deleteEntity(String table, int id) {
		mapper.deleteEntity(table, id);
	}

	public void updataEntity(String table, int id, HashMap<String, Object> params) {
		mapper.updataEntity(table, id, params);
	}

	public HashMap selectById(String table, int id) {
		return mapper.selectById(table, id);
	}

	public List<HashMap> search(String table, String field, String query) {
		return mapper.search(table, field, query);
	}

	/**
	 * hashmap转为对象
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public <T> T hash2Class(HashMap map, Class<T> clazz) {
		if (null == clazz) {
			return null;
		}
		Object u = null;
		try {
			u = clazz.newInstance();
			// 遍历hashmap.取到key的值用来取字段
			for (Object key : map.keySet()) {

				// 用key值找到对应的字段
				Field field = clazz.getDeclaredField(key.toString());
				// 强制设置private 字段
				field.setAccessible(true);
				Object obj = field.getType();
				Object value;

				// boolean类型不能直接赋值,所以要做判断转换
				if (Boolean.class == obj) {
					value = map.get(key).equals("1") ? true : false;
				} else {
					value = map.get(key);
				}
				// 赋值到新的里
				field.set(u, value);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (T) u;
	}

	/**
	 * 对象转为map
	 * 
	 * @param entity
	 * @return
	 */
	public <T> HashMap class2Hash(Object entity) {
		if (null == entity) {
			return null;
		}
		Class<T> clazz = (Class<T>) entity.getClass();
		Field[] field = clazz.getDeclaredFields();

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		try {
			for (Field f : field) {
				f.setAccessible(true);
				hashmap.put(f.getName(), f.get(entity));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashmap;
	}

}
