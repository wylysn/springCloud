package com.purang.service_feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hi",fallback=SchedualServiceHiHystric.class)	//指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口
public interface SchedualServiceHi {
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value="name") String name);
}
