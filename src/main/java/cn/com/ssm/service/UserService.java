package cn.com.ssm.service;

import cn.com.ssm.common.ServerResponse;
import cn.com.ssm.pojo.User;
import cn.com.ssm.vo.UserInfoVo;

import javax.servlet.http.HttpSession;

/**
 * 用户信息服务
 */
public interface UserService {
    //校验用户是否存在；
    ServerResponse<User> login(String userName, String password) throws Exception;

    //用户注册
    ServerResponse<String> register(User user) throws Exception;

    //检查信息是否有效
    ServerResponse<String> checkValid(String str, String type) throws Exception;

    //通过用户名称查问题
    ServerResponse<String> selectQuestion(String userName) throws Exception;

    //获取用户信息
    ServerResponse<User> getUserInfo(HttpSession httpSession) throws Exception;

    //重置密码
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) throws Exception;
    //更改用户的信息
    ServerResponse<User> updateInformation(User user) throws Exception;
    //获取用户的信息
    ServerResponse<User> getInformation(Integer userId) throws Exception;

}
