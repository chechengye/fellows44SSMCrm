package com.weichuang.service;

import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;

public interface CustomerService {
    Page getCustomerListByQueryVo(QueryVo vo);
}
