/**
 * @Date          2019年4月10日 下午4:20:47 

 * @version    V1.0 
 */
package org.jon.lv.controller;

import org.jon.lv.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MML
 * @Date    2019-04-10
 * @version    V1.0 
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired 
	RedisService redisService;
	
	@RequestMapping("/save")
	public String save() {
		redisService.save();
		return "success!";
	}
	
	@RequestMapping("/get")
	public String get() {
		redisService.get();
		return "success";
	}
}
