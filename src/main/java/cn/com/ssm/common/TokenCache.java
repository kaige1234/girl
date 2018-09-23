package cn.com.ssm.common;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mysql.jdbc.TimeUtil;
import org.apache.ibatis.mapping.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TokenCache {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenCache.class);

    private static LoadingCache<String,String> localCache= com.google.common.cache.CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    public static void setkey(String key,String value){
        localCache.put(key,value);
    }

    public static String getKey(String key){
        String value= null;
        try{
            value = localCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return  value;
        }catch (Exception e){
            LOGGER.error("获取缓存值错误",e);
        }
        return null;
    }

}
