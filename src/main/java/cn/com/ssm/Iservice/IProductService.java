package cn.com.ssm.Iservice;

import cn.com.ssm.common.ServerResponse;
import cn.com.ssm.mapper.ProductMapper;
import cn.com.ssm.po.ProductPo;
import cn.com.ssm.pojo.Product;
import cn.com.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductService implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public ServerResponse getList(int pageSize, int pageNum)throws Exception{
        PageHelper.startPage(pageSize,pageNum);
        List<Integer> productPos  = productMapper.queryProduct();
        PageInfo pageInfo = new PageInfo(productPos);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
