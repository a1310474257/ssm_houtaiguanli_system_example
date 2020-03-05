package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //查询全部订单---未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception{
//        ModelAndView modelAndView = new ModelAndView();
//        List<Orders> orders = orderService.findAll();
//        modelAndView.addObject("ordersList",orders);
//        modelAndView.setViewName("orders-list");
//        return  modelAndView;
//    }

    /**
     * 分页
     * */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page ,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = orderService.findAll(page,size);
        //PageInfo就是一个分页
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return  mv;
    }

//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll(HttpServletRequest request) throws Exception {
//
//        ModelAndView mv = new ModelAndView();
//        System.out.printf("page------------------>"+request.getParameter("page"));
//        List<Orders> ordersList = orderService.findAll(1, 4);
//        //PageInfo就是一个分页Bean
//        PageInfo pageInfo=new PageInfo(ordersList);
//        mv.addObject("pageInfo",pageInfo);
//        mv.setViewName("orders-page-list");
//        return mv;
//    }

    @RequestMapping("/findById.do")
    public  ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
       Orders orders =  orderService.findById(ordersId);
       modelAndView.addObject("orders",orders);
       modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}

