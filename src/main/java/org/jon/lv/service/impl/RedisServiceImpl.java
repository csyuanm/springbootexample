/**
 * @Date          2019年4月10日 下午4:24:56 

 * @version    V1.0 
 */
package org.jon.lv.service.impl;

import org.jon.lv.domain.User;
import org.jon.lv.redis.RedisUtils;
import org.jon.lv.service.RedisService;
import org.springframework.stereotype.Service;

/**
 * @author MML
 * @Date    2019-04-10
 * @version    V1.0 
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Override
	public void save() {
//      RedisUtils.set("springboottest111111", "中国式", 10000L);
      User user = new User();
      user.setName("测试");
      user.setPhone("123444444444");
      RedisUtils.set("redis_user", user, 10000L);
	}

	@Override
	public void get() {
		  System.out.println("redis获取到的值为：" + RedisUtils.get("redis_user"));
	}

}
