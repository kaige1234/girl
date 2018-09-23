package cn.com.ssm.mapper;

import cn.com.ssm.po.ProductPo;
import cn.com.ssm.pojo.Product;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {


    int updateByPrimaryKey(Product product);

    int updateByPrimaryKeySelective(Product product);

    int insertSelective(Product product);

    int insert(Product product);

    List<Integer> queryProduct();
}