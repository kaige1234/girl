package cn.com.ssm.controller;


import cn.com.ssm.common.Const;
import cn.com.ssm.common.ServerResponse;
import cn.com.ssm.pojo.User;
import cn.com.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 商品
 */
@RequestMapping(value = "/product/")
@Component
public class ProductController {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    @RequestMapping(value = "getList.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getList(HttpSession httpSession, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum) throws Exception {
       /* User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByError("用户不存在请重新登录");
        }*/
        ServerResponse serverResponse= productService.getList(pageSize,pageNum);

       /* PageInfo pageInfo = (PageInfo)serverResponse.getData();
        System.out.println(pageInfo.getList().size());*/
        return serverResponse;
    }


}
