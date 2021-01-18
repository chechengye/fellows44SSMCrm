package com.weichuang.controller;

import com.weichuang.pojo.BaseDict;
import com.weichuang.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    BaseDictService baseDictService;

    @RequestMapping(value = "/customerList.do" , method = RequestMethod.GET)
    public String getCustomerList(Model model){
        List<BaseDict> industryType = baseDictService.getBaseDictTypes("001");
        model.addAttribute("industryType",industryType);
        //model.addAttribute("codition",);此处需要在vo包下面创建Condition条件类
        System.out.println("industryType = " + industryType);

        return "customer";
    }
}
