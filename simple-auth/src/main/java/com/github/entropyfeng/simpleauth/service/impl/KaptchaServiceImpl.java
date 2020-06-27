package com.github.entropyfeng.simpleauth.service.impl;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.service.KaptchaService;
import com.github.entropyfeng.simpleauth.util.CommonUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author entropyfeng
 * 默认验证码实现类
 */
@Primary
@Service
public class KaptchaServiceImpl implements KaptchaService {


    private static Logger logger = LoggerFactory.getLogger(KaptchaServiceImpl.class);
    @Autowired
    public KaptchaServiceImpl(DefaultKaptcha defaultKaptcha,StringRedisTemplate redisTemplate) {
        this.redisTemplate=redisTemplate;
        this.producer = defaultKaptcha;
    }

    private   DefaultKaptcha producer;
    private   StringRedisTemplate redisTemplate;
    /**
     * 创建了一个Kaptcha相关map
     * 返回空代表创建失败
     *
     * @return {  aMap
     *
     *     key            value
     *     img            经过Base64编码后的图片
     *     kaptcha_token  the key of kaptcha
     * }
     *
     */
    @Override
    public Map createKaptcha() {

        String kaptcha = producer.createText();

        Map<String, String> res = new HashMap<>(2);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage image = producer.createImage(kaptcha);

        try {
            ImageIO.write(image, "jpg", outputStream);

            res.put("img", Arrays.toString(Base64.getEncoder().encode(outputStream.toByteArray())));
            String kaptchaToken = CommonUtil.getKaptchaToken();
            res.put("kaptcha_token", kaptchaToken);
            //设置过期时间300秒，并加入redis
            redisTemplate.opsForValue().set(AuthProperties.kaptchaSuffix + kaptchaToken, kaptcha, AuthProperties.kaptchaExpiredTime, TimeUnit.SECONDS);
            logger.info("create captcha token {} value {}",kaptchaToken,kaptcha);
        } catch (IOException e) {
            logger.warn( "create Kaptcha fail", e);
            res = null;
        }

        return res;
    }

    @Override
    public boolean checkKaptcha(String kaptchaToken, String kaptcha) {

        assert   kaptcha!=null;
        return   redisTemplate.opsForValue().get(AuthProperties.kaptchaSuffix + kaptchaToken).equals(kaptcha);
    }
}
