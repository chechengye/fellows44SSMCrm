package com.weichuang.controller;

import com.weichuang.pojo.BaseDict;
import com.weichuang.pojo.Customer;
import com.weichuang.service.BaseDictService;
import com.weichuang.service.CustomerService;
import com.weichuang.service.impl.CustomerServiceImpl;
import com.weichuang.utils.Page;
import com.weichuang.vo.CommonResult;
import com.weichuang.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    BaseDictService baseDictService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customerList.do" , method = RequestMethod.GET)
    public String getCustomerList(QueryVo vo , Model model){
        List<BaseDict> industryType = baseDictService.getBaseDictTypes("001");
        List<BaseDict> fromType = baseDictService.getBaseDictTypes("002");
        List<BaseDict> levelType = baseDictService.getBaseDictTypes("006");
        model.addAttribute("industryType",industryType);
        model.addAttribute("fromType",fromType);
        model.addAttribute("levelType",levelType);
        //model.addAttribute("codition",);此处需要在vo包下面创建Condition条件类
        System.out.println("industryType = " + industryType);
        Page page = customerService.getCustomerListByQueryVo(vo);
        System.out.println("page = " + page );
        model.addAttribute("page",page);
        model.addAttribute("vo",vo);
        return "customer";
    }

    @RequestMapping(value = "/customerEdit.do" , method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Customer> getCustomerById(Long id){
        Customer customer = customerService.getCustomerById(id);
        CommonResult<Customer> commonResult = new CommonResult<>("成功！",customer);
        return commonResult;
    }

    @RequestMapping(value = "/customerUpdate.do" , method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> customerUpdate(Customer customer){
        System.out.println("customer = " + customer);
        int rows = customerService.customerUpdate(customer);
        CommonResult<Object> commonResult;
        if(rows > 0)
            commonResult = new CommonResult<>("更新成功！");
        else
            commonResult = new CommonResult<>("更新失败！");
        return commonResult;
    }

    @RequestMapping(value = "/customerDelete.do" , method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> customerDelete(Long id){
        int rows = customerService.customerDeleteById(id);
        CommonResult<Object> commonResult;
        if(rows > 0)
            commonResult = new CommonResult<>("删除客户成功！");
        else
            commonResult = new CommonResult<>("删除客户失败！");
        return commonResult;
    }
}
