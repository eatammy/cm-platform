package cn.eatammy.common.sys.redis;

import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 郭旭辉 on 2016/7/11.
 * Redis工具类
 */


@Component
public class RedisUtils {
    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    private ShardedJedisPool shardedJedisPool;

    /**
     * 设置一个可以的过期时间（单位：秒）
     *
     * @param key     key值
     * @param seconds 设置过期时间，
     * @return 返回： 1：设置了过期时间，0：没有设置过期时间（默认不能不设置过期时间）
     */
    public long expire(String key, int seconds) {
        if (StringUtils.isEmpty(key)) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.expire(key, seconds);
        } catch (Exception ex) {
            logger.error("EXPIRE error[key=" + key + " seconds=" + seconds
                    + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 设置一个key在某个时间点过期
     *
     * @param key           key值
     * @param unixTimeStamp unix时间戳，从1970-01-01 00:00:00开始到现在的秒数
     * @return 1：设置了过期时间 0：没有设置过期时间/不能设置过期时间
     */
    public long expireAt(String key, int unixTimeStamp) {
        if (StringUtils.isEmpty(key)) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.expireAt(key, unixTimeStamp);
        } catch (Exception ex) {
            logger.error("EXPIRE error[key=" + key + " unixTimestamp="
                    + unixTimeStamp + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 截断一个List
     *
     * @param key   key值
     * @param start 开始位置，从0开始
     * @param end   结束位置
     * @return 状态码
     */
    public String trimList(String key, long start, long end) {
        if (StringUtils.isEmpty(key)) {
            return "-";
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.ltrim(key, start, end);
        } catch (Exception ex) {
            logger.error("LTRIM 出错[key=" + key + " start=" + start + " end="
                    + end + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return "-";
    }

    /**
     * 坚持 set 的长度
     *
     * @param key key值
     * @return 返回key的长度
     */
    public long countSet(String key) {
        if (StringUtils.isEmpty(key)) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.scard(key);
        } catch (Exception ex) {
            logger.error("countSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 添加到Set中（同时设置过期时间）
     *
     * @param key     key值
     * @param seconds 过期时间，单位：秒
     * @param value   value值
     * @return 返回，布尔值，true：添加成功，false：添加失败
     */
    public boolean addSet(String key, int seconds, String... value) {
        boolean result = addSet(key, value);
        if (result) {
            long i = expire(key, seconds);
            return i == 1;
        }
        return false;
    }

    /**
     * 添加到Set中
     *
     * @param key   key值
     * @param value value值（可多值）
     * @return 返，布尔值，true：添加成功，false：添加失败
     */
    public boolean addSet(String key, String... value) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.sadd(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("setList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }


    /**
     * 判断 相应的值是否在set中
     *
     * @param key   key值
     * @param value value值
     * @return 返回，布尔值，true：操作成功，false：操作失败
     */
    public boolean containInSet(String key, String value) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.sismember(key, value);
        } catch (Exception ex) {
            logger.error("setList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获取 Set
     *
     * @param key key值
     * @return 返回，布尔值，true：操作成功，false：操作失败
     */
    public Set<String> getSet(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.smembers(key);
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 从set 中删除value
     *
     * @param key   key值
     * @param value value值
     * @return 返回，布尔值，true：操作成功，false：操作失败
     */
    public boolean removeSetValue(String key, String... value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.srem(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 从list中删除value 默认count 1
     *
     * @param key    key值
     * @param values value值列表
     * @return 返回，成功删除的个数
     */
    public int removeListValue(String key, List<String> values) {
        return removeListValue(key, 1, values);
    }

    /**
     * 从list中删除value
     *
     * @param key    key值
     * @param count  删除的个数
     * @param values 删除带飞值
     * @return 返回，成功删除的个数
     */
    public int removeListValue(String key, long count, List<String> values) {
        int result = 0;
        if (values != null && values.size() > 0) {
            for (String value : values) {
                if (removeListValue(key, count, value)) {
                    return result++;
                }
            }
        }
        return result;
    }

    /**
     * 从list中删除value
     *
     * @param key   key值
     * @param count 要删除的个数
     * @param value 删除的值
     * @return 返回，布尔值，true: 删除成功，false：删除失败
     */
    public boolean removeListValue(String key, long count, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.lrem(key, count, value);
            return true;
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 截取list
     *
     * @param key   key值
     * @param start 起始位置
     * @param end   结束位置
     * @return 返回，截取的list
     */
    public List<String> rangeList(String key, long start, long end) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.lrange(key, start, end);
        } catch (Exception ex) {
            logger.error("rangeList 出错[key=" + key + " start=" + start
                    + " end=" + end + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 检查list的长度
     *
     * @param key key值
     * @return 返回，长度，返回0：异常
     */
    public long countList(String key) {
        if (StringUtils.isEmpty(key)) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.llen(key);
        } catch (Exception ex) {
            logger.error("countList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 添加到List中（同时设置过期时间）
     *
     * @param key     key值
     * @param seconds 过期时间， 单位s
     * @param value   添加的值
     * @return 返回，布尔值，true：添加成功，false：添加失败
     */
    public boolean addList(String key, int seconds, String... value) {
        boolean result = addList(key, value);
        if (result) {
            long i = expire(key, seconds);
            return i == 1;
        }
        return false;
    }


    /**
     * 添加到List
     *
     * @param key   key值
     * @param value value值
     * @return 返回，布尔值，true：添加成功，false：添加失败
     */
    public boolean addList(String key, String... value) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.lpush(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("countList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }


    /**
     * 添加到List（只新增）
     *
     * @param key  key值
     * @param list 待新增的list列表
     * @return 返回，布尔值，true：添加成功，false：添加失败
     */
    public boolean addList(String key, List<String> list) {
        if (StringUtils.isEmpty(key) || list == null || list.size() == 0) {
            return false;
        }
        for (String value : list) {
            addList(key, value);
        }
        return true;
    }

    /**
     * 获取List
     *
     * @param key key值
     * @return 返回，对应的列表
     */
    public List<String> getList(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.lrange(key, 0, -1);
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 设置hashSet对象
     *
     * @param domain 作用域
     * @param key    key值
     * @param value  value值
     * @return 返回，hashSet的对象
     */
    public boolean setHSet(String domain, String key, String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.hset(domain, key, value);
            return true;
        } catch (Exception ex) {
            logger.error("setHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获取HashSet 对象
     *
     * @param domian 作用域
     * @param key    key值
     * @return 返回，hashSet对象
     */
    public String getHSet(String domian, String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.hget(domian, key);
        } catch (Exception ex) {
            logger.error("getHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 删除HashSet对象
     *
     * @param domain 作用域
     * @param key    key值
     * @return 删除的记录数
     */
    public long delHSet(String domain, String key) {
        ShardedJedis shardedJedis = null;
        long count = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            count = shardedJedis.hdel(domain, key);
        } catch (Exception ex) {
            logger.error("delHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return count;
    }

    /**
     * 删除HashSet对象
     *
     * @param domian 作用域
     * @param key    key值
     * @return 返回 ，删除的记录数
     */
    public long delHSet(String domian, String... key) {
        ShardedJedis shardedJedis = null;
        long count = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            count = shardedJedis.hdel(domian, key);
        } catch (Exception ex) {
            logger.error("delHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return count;
    }

    /**
     * 判断key是否存在
     * @param domain    domain域
     * @param key       key值
     * @return 返回，布尔值，true：存在，false：不存在
     */
    public boolean existsHSet(String domain, String key) {
        ShardedJedis shardedJedis = null;
        boolean isExist = false;
        try {
            shardedJedis = shardedJedisPool.getResource();
            isExist = shardedJedis.hexists(domain, key);
        } catch (Exception ex) {
            logger.error("existsHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return isExist;
    }

    /**
     * 全局搜啊秒hset
     * @param domain    作用域
     * @param match     字段匹配模式
     * @return  返回，扫描列表
     */
    public List<Map.Entry<String, String>> scanHSet(String domain, String match){
        ShardedJedis shardedJedis = null;
        try {
            int cursor = 0;
            shardedJedis = shardedJedisPool.getResource();
            ScanParams scanParams = new ScanParams();
            scanParams.match(match);
            Jedis jedis = shardedJedis.getShard(domain);
            ScanResult<Map.Entry<String, String>> scanResult;
            List<Map.Entry<String, String>> list = new ArrayList<>();
            do{
                scanResult = jedis.hscan(domain, String.valueOf(cursor), scanParams);
                list.addAll(scanResult.getResult());
                cursor = Integer.parseInt(scanResult.getStringCursor());
            }while (cursor > 0);
            return list;
        }catch (Exception ex) {
            logger.error("scanHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 返回 domain 指定的哈希集中所有字段的value值
     * @param domain    作用域
     * @return  返回，集合列表
     */
    public List<String> hvals(String domain){
        ShardedJedis shardedJedis = null;
        List<String> retList = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hvals(domain);
        } catch (Exception ex) {
            logger.error("hvals error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 返回 domain 指定的哈希集中所有的字段的key值
     * @param domain    作用域
     * @return  返回，key的set集合
     */
    public Set<String> hKeys(String domain){
        ShardedJedis shardedJedis = null;
        Set<String> retList = null;
        try{
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hkeys(domain);
        } catch (Exception ex) {
            logger.error("hkeys error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return retList;
    }


    /**
     * 返回 domain 指定的哈希 key 值总数
     * @param domain 作用域
     * @return 返回 domain 指定的哈希 key 值总数
     */
    public long lenHset(String domain){
        ShardedJedis shardedJedis = null;
        long retList = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hlen(domain);
        }catch (Exception ex) {
            logger.error("hkeys error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 设置排序集合
     * @param key       key值
     * @param score     score分数
     * @param value     value值
     * @return  返回，布尔值，true：设置成功，false：设置失败
     */
    public boolean setSortedSet(String key, long score, String value){
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.zadd(key, score, value);
            return true;
        } catch (Exception ex) {
            logger.error("setSortedSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获取排序集合
     * @param key           key值
     * @param startScore    开始分数
     * @param endScore      结束分数
     * @param orderByDesc   排序
     * @return  返回，排序后的集合set
     */
    public Set<String> getSoredSet(String key, long startScore, long endScore,
                                   boolean orderByDesc) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if (orderByDesc) {
                return shardedJedis.zrevrangeByScore(key, endScore, startScore);
            } else {
                return shardedJedis.zrangeByScore(key, startScore, endScore);
            }
        } catch (Exception ex) {
            logger.error("getSoredSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 计算排序长度
     * @param key           key值
     * @param startScore    开始分数
     * @param endScore      结束分数
     * @return  返回，计算后的长度
     */
    public long countSoredSet(String key, long startScore, long endScore) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            Long count = shardedJedis.zcount(key, startScore, endScore);
            return count == null ? 0L : count;
        } catch (Exception ex) {
            logger.error("countSoredSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0L;
    }

    /**
     * 删除排序集合
     * @param key       key值
     * @param value     value值
     * @return  返回，布尔值，true：删除成功，false：删除失败
     */
    public boolean delSortedSet(String key, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            long count = shardedJedis.zrem(key, value);
            return count > 0;
        } catch (Exception ex) {
            logger.error("delSortedSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获得排序集合
     * @param key           key值
     * @param startRange    开始下标
     * @param endRange      结束下标
     * @param orderByDesc   排序
     * @return  返回，指定排序集合
     */
    public Set<String> getSoredSetByRange(String key, int startRange,
                                          int endRange, boolean orderByDesc) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if (orderByDesc) {
                return shardedJedis.zrevrange(key, startRange, endRange);
            } else {
                return shardedJedis.zrange(key, startRange, endRange);
            }
        } catch (Exception ex) {
            logger.error("getSoredSetByRange error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 获得排序打分
     *
     * @param key
     * @return
     */
    public Double getScore(String key, String member) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.zscore(key, member);
        } catch (Exception ex) {
            logger.error("getSoredSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    public boolean set(String key, String value, int second) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.setex(key, second, value);
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    public boolean set(String key, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    public String get(String key, String defaultValue) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.get(key) == null ? defaultValue : shardedJedis
                    .get(key);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return defaultValue;
    }

    public boolean del(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.del(key);
            return true;
        } catch (Exception ex) {
            logger.error("del error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    public long incr(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.incr(key);
        } catch (Exception ex) {
            logger.error("incr error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    public long decr(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.decr(key);
        } catch (Exception ex) {
            logger.error("incr error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }


    /**
     * 释放过期资源
     *
     * @param shardedJedis jedis实例
     */
    private void returnBrokenResource(ShardedJedis shardedJedis) {
        try {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } catch (Exception e) {
            logger.error("redis 释放过期资源异常", e);
        }
    }

    /**
     * 释放资源
     *
     * @param shardedJedis jedis实例
     */
    private void returnResource(ShardedJedis shardedJedis) {
        try {
            shardedJedisPool.returnResource(shardedJedis);
        } catch (Exception e) {
            logger.error("redis 释放资源异常");
        }
    }
}
