package cn.com.ssm.common;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisCacheManager {
    //设置redis的值的属性
    private RedisTemplate<String, Object> redisTemplate;
    //字符串设置值
    private StringRedisTemplate stringRedisTemplate;
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean expire(String key, long time){
        try{
            if(time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 获取字符串
     * @param strName
     * @param strValue
     * @return
     */
    public boolean setStr(String strName,String strValue){
        if(strValue.isEmpty() || strName.isEmpty()){
            return false;
        }
        stringRedisTemplate.opsForValue().set(strName,strValue);
        return true;
    }

    /**
     * 获取字符串的值
     * @param strName
     * @return
     */
    public String getStr(String strName){
        if(strName.isEmpty()){
            return "";
        }
        return stringRedisTemplate.opsForValue().get(strName);
    }

}
