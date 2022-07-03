package com.wsf.springcloud.service.impl;

import com.wsf.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Service;

/**
 * @author wsfstart
 * @create 2022-07-03 18:21
 */
@Service
public class PaymentFallbackService  implements PaymentFeignService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back paymentInfo_OK /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return"PaymentFallbackService fall back paymentInfo_TimeOut /(ㄒoㄒ)/~~";
    }
}
