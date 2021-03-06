package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username == 'mima123'")  //mima123只有用户mima123才能访问
    public  String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有产品
     * */
    @RequestMapping("/findAll.do")
    @RolesAllowed({"USER","ADMIN"})  //ADMIN USER 角色能访问
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list1");
        System.out.println("hello");
        return mv;
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("访问test");
        return "success";
    }
}
