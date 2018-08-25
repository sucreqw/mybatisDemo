package com.sucre.mybatisDemo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sucre.mybatisDemo.dao.BaseDao;
import com.sucre.mybatisDemo.dao.BaseDaoimpl;
import com.sucre.mybatisDemo.entity.User;
import com.sucre.mybatisDemo.entity.Weibo;

public class MybatisTest {

	@Test
	public void test() throws IOException {
		User u=new User();
		u.setAvater("testavater");
		u.setCookie("testcookie");
		u.setIsblock(false);
		u.setNickname("testnickname");
		u.setPsd("testpsd");
		u.setIsmanager(false);
		u.setRefresh_token("testtoken");
		u.setToken("testcookie");
        u.setRegday(new Date());
        u.setRegip("127.0.0.1");
        
		BaseDaoimpl b = new BaseDaoimpl();
		b.init();
		//b.addEntity("user", b.class2Hash(u));
		//b.deleteEntity("user", 22);
		//b.updataEntity("user", 24, b.class2Hash(u));
		//HashMap<String, Object> hashmap=b.selectById("user", 24);
		//List<HashMap> list=b.search("user", "token", "test");
		//System.out.println(list.get(1));
		b.close();
	}

}
