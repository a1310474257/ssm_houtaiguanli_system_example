package com.itheima.ssm.service;


import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrderService {

    public List<Orders> findAll(int pages,int size) throws Exception;

    public Orders findById(String orderId) throws Exception ;
}
