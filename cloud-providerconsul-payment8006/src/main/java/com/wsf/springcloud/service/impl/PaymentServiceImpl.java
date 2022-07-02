package com.wsf.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsf.springcloud.mapper.PaymentMapper;
import com.wsf.springcloud.pojo.Payment;
import com.wsf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
* @author weijin
* @description 针对表【payment(支付表)】的数据库操作Service实现
* @createDate 2022-06-28 18:20:44
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{

}




