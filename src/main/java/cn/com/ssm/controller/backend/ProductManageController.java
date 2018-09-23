package cn.com.ssm.controller.backend;


import cn.com.ssm.Iservice.IUserService;
import cn.com.ssm.common.Const;
import cn.com.ssm.common.ResponseCode;
import cn.com.ssm.common.ServerResponse;
import cn.com.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 后台上传接口
 */
@Controller
@RequestMapping("/manage/product")
public class ProductManageController {

    @Autowired
    private IUserService iUserService;

    public ServerResponse productSave(HttpSession httpSession){
        User user =  (User) httpSession.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户没有登录，请登录");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){

        }

        return ServerResponse.createBySuccess();
    }
}
