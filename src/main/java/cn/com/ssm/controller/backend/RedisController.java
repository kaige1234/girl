package cn.com.ssm.controller.backend;


import cn.com.ssm.Iservice.IUserService;
import cn.com.ssm.common.RedisCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/redis")
public class RedisController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisController.class);


    @Autowired
    private RedisCacheManager redisCacheManager;

    public RedisCacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }
    @RequestMapping(value = "/redis")
    public void redis(){
       // redisCacheManager.expire("str",5000L);

        redisCacheManager.setStr("key","ddfsadsfasfa");
        String str = redisCacheManager.getStr("key");
        LOGGER.info("获取存储的信息"+str);
    }
}
