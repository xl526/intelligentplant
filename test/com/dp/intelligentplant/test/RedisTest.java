package com.dp.intelligentplant.test;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-redis.xml"})
public class RedisTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setId("001");
		user.setName("user1");
		
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.set(redisTemplate.getStringSerializer().serialize(user.getId()), redisTemplate.getStringSerializer().serialize(user.getName()));
				return null;
			}
		});
	}
	
	@Test
	public void testUser1() {
		User user = new User();
		user.setId("002");
		user.setName("user2");
		ValueOperations<Serializable, Serializable> valueOper = redisTemplate.opsForValue();
		valueOper.set(user.getId(), user);
	}
	
	@Test
	public void testReadUser() {
		ValueOperations<Serializable, Serializable> valueOper = redisTemplate.opsForValue();
		System.out.println(((User)valueOper.get("002")).getName());
	}
}
