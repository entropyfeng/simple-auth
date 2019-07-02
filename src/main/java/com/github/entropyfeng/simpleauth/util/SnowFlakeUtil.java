package com.github.entropyfeng.simpleauth.util;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * snowFlake algorithm from twitter
 *
 * @author entropyfeng
 * @date 2019/7/2 16:59
 */
public class SnowFlakeUtil {



    private static final Logger logger = LoggerFactory.getLogger(SnowFlakeUtil.class);

    public static SnowFlakeUtil getInstance(){
        return SnowFlakeUtilHolder.instance;
    }
    public static  class SnowFlakeUtilHolder{
        public static SnowFlakeUtil instance=new SnowFlakeUtil(AuthProperties.dataCenterId,AuthProperties.machineId);

    }


    /**
     * 数据中心
     */
    private long dataCenterId;
    /**
     * 机器标识
     */
    private long machineId;

    /**
     * 起始的时间戳 北京时间 2019-07-01 00:00:00
     */
    private final static long START_TIME_STAMP = 1561910400000L;

    /**
     * 序列号占用的位数
     */
    private final static long SEQUENCE_BIT = 12;


    /**
     * 机器标识占用的位数
     */
    private final static long MACHINE_BIT = 5;


    /**
     * 数据中心占用的位数
     */
    private final static long DATA_CENTER_BIT = 5;

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIME_STAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;


    /**
     * 序列号
     */
    private long sequence = 0L;
    /**
     * 上一次时间戳
     */
    private long lastTimeStamp = -1L;

    private SnowFlakeUtil(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
            final String error = "dataCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0";
            logger.error(error);
            throw new IllegalArgumentException(error);
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            final String error = "machineId can't be greater than MAX_MACHINE_NUM or less than 0";
            logger.error(error);
            throw new IllegalArgumentException(error);
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
        logger.info("snowflake config: dataCenterId {} ,machineId  {}", dataCenterId, machineId);
    }

    /**
     * 产生下一个ID
     *
     * @return snowFlake id
     */
    public synchronized long nextId() {
        long currStamp = getNewTimeStamp();
        if (currStamp < lastTimeStamp) {
            // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟被修改过，回退在上一次ID生成时间之前应当抛出异常！！！
            final String error = "Clock moved backwards.  Refusing to generate id !";
            logger.error(error);
            throw new RuntimeException(error);
        }

        if (currStamp == lastTimeStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStamp = tilNextMillis();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastTimeStamp = currStamp;

        //时间戳部分
        return (currStamp - START_TIME_STAMP) << TIME_STAMP_LEFT
                //数据中心部分
                | dataCenterId << DATA_CENTER_LEFT
                //机器标识部分
                | machineId << MACHINE_LEFT
                //序列号部分
                | sequence;
    }


    /**
     * 获取当前系统时间戳
     *
     * @return 当前系统时间戳
     */
    private long getNewTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 阻塞到下一毫秒,获得新时间戳
     *
     * @return 当前时间戳
     */
    private long tilNextMillis() {
        long timestamp = getNewTimeStamp();
        while (timestamp <= lastTimeStamp) {
            timestamp = getNewTimeStamp();
        }
        return timestamp;
    }


}
