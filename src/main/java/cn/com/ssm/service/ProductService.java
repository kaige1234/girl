package cn.com.ssm.service;

import cn.com.ssm.common.ServerResponse;

public interface ProductService {

    ServerResponse getList(int pageSize, int pageNum) throws Exception;
}
