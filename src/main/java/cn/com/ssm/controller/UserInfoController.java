package cn.com.ssm.controller;

import cn.com.ssm.Iservice.IUserService;
import cn.com.ssm.common.Const;
import cn.com.ssm.common.ResponseCode;
import cn.com.ssm.common.ServerResponse;
import cn.com.ssm.common.TokenCache;
import cn.com.ssm.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.ValueExp;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);
    @Autowired
    private IUserService    userService;

    /**
     * 登录接口
     *
     * @param username
     * @param password
     * @param httpSession
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession httpSession) throws Exception {
        ServerResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            httpSession.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    /**
     * 登出接口
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession httpSession) {
        httpSession.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 用户信息注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user) throws Exception {
        return userService.register(user);
    }

    /**
     * 用来检查用户名和email是否存在
     *
     * @param str
     * @param type
     * @return
     */
    @RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) throws Exception {
        return userService.checkValid(str, type);
    }

    /**
     * 返回用户信息
     *
     * @param httpSession
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession httpSession) throws Exception {
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        LOGGER.info("用户未登录--------》");
        return ServerResponse.createByError("用户未登录，无法获取当前的用户信息");
    }


    /**
     * 通过用户名称查找问题
     *
     * @param username
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username) throws Exception {
        return userService.selectQuestion(username);
    }


    /**
     * 检查问题答案
     *
     * @param userName
     * @param question
     * @param answer
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "forget_check_answer.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkAnswer(String userName, String question, String answer) throws Exception {
        return userService.checkAnswer(userName, question, answer);

    }

    /**
     * 重置密码
     *
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "forget_rest_password.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken) throws Exception {
        return userService.forgetResetPassword(username, passwordNew, forgetToken);
    }

    /**
     * 用户登录后重置密码
     *
     * @param httpSession
     * @param passwordOld
     * @param passwordNew
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    public ServerResponse<String> resetPassword(HttpSession httpSession, String passwordOld, String passwordNew) throws Exception {
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByError("用户不存在");
        }
        return userService.resetPassword(passwordOld,passwordNew,user);
    }

    /**
     * 修改用户信息
     * @param httpSession
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="update_Infomation.do",method = RequestMethod.POST)
    public ServerResponse<User> updateInformation(HttpSession httpSession , User user) throws Exception {
        User currentUser  = (User)httpSession.getAttribute(user.getUsername());
        if(currentUser == null){
            return ServerResponse.createByError("用户没有登录，请登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = userService.updateInformation(user);
        if(response.isSuccess()){
            response.getData().setUsername(currentUser.getUsername() );
            httpSession.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * 获取用户信息
     * @param httpSession
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
    public ServerResponse<User> get_Information(HttpSession httpSession) throws Exception {
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if(user ==  null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"请登录");
        }

        return userService.getInformation(user.getId());
    }
}
