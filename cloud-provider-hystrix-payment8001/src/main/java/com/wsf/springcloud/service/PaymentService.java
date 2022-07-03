package com.wsf.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wsf.springcloud.pojo.Payment;

/**
* @author weijin
* @description 针对表【payment(支付表)】的数据库操作Service
* @createDate 2022-06-28 18:20:44
*/
public interface PaymentService extends IService<Payment> {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    String paymentInfoOK(Integer id);

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
     String paymentInfoTimeOut(Integer id);

     String paymentCircuitBreaker(Integer id);
}
