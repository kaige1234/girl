package cn.com.ssm.controller.backend;

import cn.com.ssm.common.Const;
import cn.com.ssm.common.ServerResponse;
import cn.com.ssm.pojo.User;
import cn.com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/manager/user")
public class UserManagerController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession httpSession) throws Exception{
        ServerResponse response =  userService.login(username,password);
        if(response.isSuccess()){
            User user  = (User) response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){
                httpSession.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByError("不是管理员不能登陆");
            }
        }
        return response;
    }
}
