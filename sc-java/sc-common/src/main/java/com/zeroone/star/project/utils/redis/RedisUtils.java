package com.zeroone.star.project.utils.redis;

import cn.hutool.core.collection.CollUtil;
import com.google.common.base.Throwables;
import com.zeroone.star.project.constant.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * @author Suci
     * @createTime 2022/10/17 上午 10:54
     * @desc setex
     * @param
     * @return
     */
    public Object get(String key) {
        Object value = null;
        try {
            value = redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("RedisUtils#get fail! e:{}", Throwables.getStackTraceAsString(e));
        }
        return value;
    }

    /**
     * @author Suci
     * @createTime 2022/10/18 上午 11:01
     * @desc
     * @param key
     * @return boolean
     */
    public boolean isExist(String key) {
        if (get(key) != null) {
            return true;
        }
        return false;
    }



    /**
     * @author Suci
     * @createTime 2022/10/18 上午 11:00
     * @desc  添加元素，并设置过期时间
     * @param key
     * @param value
     * @param timeout
     * @return int
     */
    public int add(String key, Object value, Long timeout, TimeUnit timeUnit) {
        try {
            if (Boolean.FALSE.equals(redisTemplate.opsForValue().setIfAbsent(key, value, timeout, timeUnit))) {
                // 添加失败
                return -1;
            }

        } catch (Exception e) {
            log.error("RedisUtils#add fail! e:{}", Throwables.getStackTraceAsString(e));
            return -1;
        }
        return 0;
    }


    /** Suci
     * @author
     * @createTime 2022/10/20 下午 6:23
     * @desc key-value add
     */
    public int add(String key, Object value) {
        try {
            if (Boolean.FALSE.equals(redisTemplate.opsForValue().setIfAbsent(key, value))) {
                // 添加失败
                log.error("RedisUtils#add fail");
                return -1;
            }

        } catch (Exception e) {
            log.error("RedisUtils#add fail! e:{}", Throwables.getStackTraceAsString(e));
            return -1;
        }
        return 0;
    }


    /*
     * @author Suci
     * @createTime 2022/10/20 下午 6:36
     */
    public int del(String key) {
        try {
            if (Boolean.FALSE.equals(redisTemplate.delete(key))) {
                return -1;
            }
        } catch (Exception e) {
            log.error("RedisUtils#del fail! e:{}", Throwables.getStackTraceAsString(e));
            return -1;
        }

        return 0;
    }


    /**
     * @author Suci
     * @createTime 2022/10/18 上午 10:32
     * @desc TTL
     * @param key
     * @return Long
     */
    public Long ttl(String key) {
        Long expiredTime;
        try {
            expiredTime = redisTemplate.getExpire(key);
        } catch (Exception e) {
            log.error("RedisUtils#setEx fail! e:{}", Throwables.getStackTraceAsString(e));
            return -1L;
        }

        return expiredTime;
    }


    /*
     * @author Suci
     * @createTime 2022/10/18 下午 3:42
     * @desc Set Add
     */
    public Long sAdd(String key, String value) {
        Long add;
        try {
            add = redisTemplate.opsForSet().add(key, value);
            if (add < 0) {
                log.error("RedisUtils#sAdd fail! e: add to Set failed");
                return -1L;
            }
        } catch (Exception e) {
            log.error("RedisUtils#sAdd fail! e:{}", Throwables.getStackTraceAsString(e));
            return -1L;
        }

        return add;
    }

    /*
     * @author Suci
     * @createTime 2022/10/18 下午 3:44
     * @desc Set Remove
     * @param key
     * @param value
     */
    public Long sRemove(String key, String value) {
        Long remove;
        try {
            remove = redisTemplate.opsForSet().remove(key, value);
            if (remove < 0L) return -1L;
        } catch (Exception e) {
            log.error("RedisUtils#sRemove fail! e:{}", Throwables.getStackTraceAsString(e));
            return -1L;
        }

        return remove;
    }


    /**
     * @author Suci
     * @createTime 2022/10/18 上午 9:30
     * @desc    sIsMember
     * @param key
     * @param value
     * @return boolean
     */
    public boolean sIsMember(String key, String value) {
        boolean exist;
        try {
            exist = Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(key, value));
        } catch (Exception e) {
            log.error("RedisUtils#sIsMember fail! e:{}", Throwables.getStackTraceAsString(e));
            return false;
        }

        return exist;
    }


    public Set<Object> sMembers(String key) {
        Set<Object> members;
        try {
            members = redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.error("RedisUtils#sMembers fail! e:{}", Throwables.getStackTraceAsString(e));
            return null;
        }

        return members;
    }

    /**
     * @author Suci
     * @createTime 2022/10/20 下午 8:09
     */
    public int hMSET(String key, Map<String, List<String>> values) {
        try {
            redisTemplate.opsForHash().putAll(key, values);
        } catch (Exception e) {
            log.error("RedisUtils#hMSET fail! e:{}", Throwables.getStackTraceAsString(e));
            return -1;
        }
        return 0;
    }


    /**
     * pipeline 设置 key-value 并设置过期时间
     */
    public void pipelineSetEx(Map<String, String> keyValues, Long seconds) {
        try {
            redisTemplate.executePipelined((RedisCallback<String>) connection -> {
                for (Map.Entry<String, String> entry : keyValues.entrySet()) {
                    connection.setEx(entry.getKey().getBytes(), seconds,
                            entry.getValue().getBytes());
                }
                return null;
            });
        } catch (Exception e) {
            log.error("RedisUtils#pipelineSetEx fail! e:{}", Throwables.getStackTraceAsString(e));
        }
    }



    /**
     * pipeline 设置 key-value 并设置过期时间
     *
     * @param seconds 过期时间
     * @param delta   自增的步长
     */
    public void pipelineHashIncrByEx(Map<String, String> keyValues, Long seconds, Long delta) {
        try {
            redisTemplate.executePipelined((RedisCallback<String>) connection -> {
                for (Map.Entry<String, String> entry : keyValues.entrySet()) {
                    connection.hIncrBy(entry.getKey().getBytes(), entry.getValue().getBytes(), delta);
                    connection.expire(entry.getKey().getBytes(), seconds);
                }
                return null;
            });
        } catch (Exception e) {
            log.error("redis pipelineSetEX fail! e:{}", Throwables.getStackTraceAsString(e));
        }
    }
}