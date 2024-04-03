package com.zeroone.star.sccommonmenu.model.redisMtehods;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @param <T>
 * @Author j1-tao
 * reids工具
 */
@Component
@Slf4j
public class RedisUtils<T> {
    @Resource
    private RedisTemplate redisTemplate;

    //将List数据存入redis
    public <T> boolean ListIntoRedis(String key, List<T> value) {
        Long count = 0L;
        try {
//            count = redisTemplate.boundListOps(key).rightPushAll();
            for (T item : value) {
                Long aLong = redisTemplate.boundListOps(key).rightPush(item);
                count += aLong;
            }
        } catch (Exception e) {
            log.error("ListIntoRedis：fail, msg:" + e.getMessage());
        }
        return count > 0;
    }

    //将List数据存入redis,并设置时间
    public <T> boolean ListIntoRedisWithTimeLimit(String key, List<T> value, int time) {
        Long count = 0L;
        try {
//            count = redisTemplate.boundListOps(key).rightPushAll(value);
            for (T item : value) {
                Long aLong = redisTemplate.boundListOps(key).rightPush(item);
                count += aLong;
            }
            if (count > 0) {
                redisTemplate.expire(key, time, TimeUnit.MINUTES);
            }
        } catch (Exception e) {
            log.error("ListIntoRedisWithTimeLimit：fail, msg:" + e.getMessage());
        }

        return count > 0;
    }

    //将单个数据存入List
    public <T> boolean IntoRedisList(String key, T value) {
        Long count = 0L;
        try {
            count = redisTemplate.boundListOps(key).rightPush(value);
        } catch (Exception e) {
            log.error("IntoRedisList：fail, msg:" + e.getMessage());
        }
        return count > 0;
    }

    //获得redisList
    public <T> List<T> getList(String key, T type, long start, long end) {
        Long size = 0L;
        List<T> range = null;
        try {
            size = redisTemplate.boundListOps(key).size();
            end = Math.min(end, size);

            range = (List<T>) redisTemplate.boundListOps(key).range(start, end - 1);
        } catch (Exception e) {
            log.error("getList：fail, msg:" + e.getMessage());
        }
        return range;
    }

    public <T> List<T> getList(String key, T type) {
        Long size = 0L;
        List<T> range = null;
        try {
            size = redisTemplate.boundListOps(key).size();
            range = (List<T>) redisTemplate.boundListOps(key).range(0, size - 1);
        } catch (Exception e) {
            log.error("getList：fail, msg:" + e.getMessage());
        }
        return range;
    }

    //删除一个key
    public boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    public boolean isExist(String key) {
        return redisTemplate.hasKey(key);
    }
}
