package com.github.entropyfeng.simpleauth.utilTest;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.util.SnowFlakeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @author entropyfeng
 * @date 2019/7/2 17:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SnowFlakeTest {


    private Vector<Long> resVector=new Vector<>();
    private Set<Long> resSet=new HashSet<Long>();
    private static final Logger logger=LoggerFactory.getLogger(SnowFlakeTest.class);

    @Test
    public void testSnowFlakeParam(){
       logger.info("dataCenterId {},machineId {}",AuthProperties.dataCenterId,AuthProperties.machineId);
       SnowFlakeUtil snowFlakeUtil= SnowFlakeUtil.SnowFlakeUtilHolder.instance;
       snowFlakeUtil.nextId();
    }

    /**
     * 生成100万条数据需要17448毫秒，大概1毫秒57条id，远小于2^12
     */
    @Test
    public void testSnowFlake(){
        final int threadNum=5;
        CountDownLatch countDownLatch=new CountDownLatch(threadNum);

        for (int i=0;i<threadNum;i++){
            final int pid=i;
            new Thread(() -> {
                long begin=System.currentTimeMillis();
                Long id;
                Vector<Long> vector=new Vector<>();
                Set<Long> set=new HashSet<Long>();
                for(int j=0;j<1000*1000;j++){
                    id= SnowFlakeUtil.SnowFlakeUtilHolder.instance.nextId();
                    vector.add(id);
                    set.add(id);
                }
                long end=System.currentTimeMillis();

                logger.info("thread {},sizeof vector {},size of set {}, and cost {},millis",pid,vector.size(),set.size(),end-begin);
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
