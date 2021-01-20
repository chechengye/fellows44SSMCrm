package com.weichuang.service;

import com.weichuang.pojo.Customer;
import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;

public interface CustomerService {
    Page getCustomerListByQueryVo(QueryVo vo);

    Customer getCustomerById(Long id);

    int customerUpdate(Customer customer);

    int customerDeleteById(Long id);
}
