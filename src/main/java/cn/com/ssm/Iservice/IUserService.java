package cn.com.ssm.Iservice;

import cn.com.ssm.common.Const;
import cn.com.ssm.common.ServerResponse;
import cn.com.ssm.common.TokenCache;
import cn.com.ssm.mapper.UserMapper;
import cn.com.ssm.pojo.User;
import cn.com.ssm.service.UserService;
import cn.com.ssm.util.MD5Util;
import cn.com.ssm.vo.UserInfoVo;
import com.github.pagehelper.dialect.rowbounds.SqlServerRowBoundsDialect;
import net.sf.jsqlparser.schema.Server;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class IUserService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(IUserService.class);
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录接口
     *
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public ServerResponse<User> login(String userName, String password) throws Exception {
        int userCount = userMapper.queryUserCount(userName);
        if (userCount == 0) {
            return ServerResponse.createByError("用户名不存在");
        }
        //MD5加密
        password = MD5Util.MD5EncodeUtf8(password);

        User user = userMapper.selectLogin(userName, password);
        if (user == null) {
            return ServerResponse.createByError("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("操作成功", user);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public ServerResponse<String> register(User user) throws Exception {
        ServerResponse userResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!userResponse.isSuccess()) {
            return userResponse;
        }
        int emailcount = userMapper.queryUserByEmail(user.getEmail());
        if (emailcount > 0) {
            return ServerResponse.createByError("用户邮箱已经存在");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getEmail()));
        user.setRole(Const.Role.ROLE_CUSTOMER);
        int resultCount = userMapper.saveUserInfo(user);
        int a =1;
        a = a/0;
        if (resultCount == 0) {
            //return ServerResponse.createByError("注册失败");
        }
        return ServerResponse.createBySuccess("注册成功");
    }

    /**
     * 检查信息是否有效
     *
     * @param str
     * @param type
     * @return
     * @throws Exception
     */
    @Override
    public ServerResponse<String> checkValid(String str, String type) throws Exception {
        if (StringUtils.isNotBlank(type)) {
            if (Const.USERNAME.equals(type)) {
                int userCount = userMapper.queryUserCount(str);
                if (userCount > 0) {
                    return ServerResponse.createByError("用户名已存在");
                }
            } else if (Const.EMAIL.equals(type)) {
                int emailCount = userMapper.queryUserByEmail(str);
                if (emailCount > 0) {
                    return ServerResponse.createByError("email已经存在");
                }
            }
        } else {
            return ServerResponse.createByError("参数错误");
        }
        return ServerResponse.createBySuccess("校验成功");
    }

    /**
     * 返回用户信息
     *
     * @param httpSession
     * @return
     * @throws Exception
     */
    public ServerResponse<User> getUserInfo(HttpSession httpSession) throws Exception {
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByError("用户没用登录，无法获取当前用户的信息");
    }

    /**
     * 通过用户名称查询问题
     *
     * @param userName
     * @return
     * @throws Exception
     */
    public ServerResponse<String> selectQuestion(String userName) throws Exception {
        ServerResponse serverResponse = this.checkValid(userName, Const.CURRENT_USER);
        if (serverResponse.isSuccess()) {
            return ServerResponse.createByError("用户不存在");
        }

        String question = userMapper.selectQuestionByUserName(userName);
        if (StringUtils.isNotBlank(question)) {
            return ServerResponse.createBySuccess(question);
        }

        return ServerResponse.createByError("找回密码的问题为空");
    }

    /**
     * 查询问题的答案
     *
     * @param username
     * @param question
     * @param answer
     * @return
     * @throws Exception
     */
    public ServerResponse<String> checkAnswer(String username, String question, String answer) throws Exception {
        int resultCount = userMapper.checkAnswer(username, question, answer);
        if (resultCount > 0) {
            String tokenValue = UUID.randomUUID().toString();
            TokenCache.setkey("user_" + tokenValue, tokenValue);
            return ServerResponse.createBySuccess(tokenValue);
        }
        return ServerResponse.createByError("问题答案错误");
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
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) throws Exception {
        if (!StringUtils.isNotBlank(forgetToken)) {
            return ServerResponse.createByError("参数错误，token需要传参");
        }
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (validResponse.isSuccess()) {
            return ServerResponse.createByError("用户不存在");
        }

        String token = TokenCache.getKey("user_" + forgetToken);
        if (token == null || "".equals(token)) {
            return ServerResponse.createByError("token无效或者过期了");
        }

        if (StringUtils.equals(token, forgetToken)) {
            String passwordMd5 = MD5Util.MD5EncodeUtf8(passwordNew);
            int resutValue = userMapper.updatePasswordByUsername(username, passwordMd5);
            if (resutValue > 0) {
                return ServerResponse.createBySuccess("修改密码成功");
            }
        } else {
            return ServerResponse.createByError("修改密码错误，请重新获取修改密码的token");
        }
        return ServerResponse.createByError("修改密码错误");
    }



    /**
     * 用户登录后，更新密码
     *
     * @param passwordOld
     * @param passwordNew
     * @param user
     * @return
     * @throws Exception
     */
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) throws Exception {
        int resultCout = userMapper.checkPassword(passwordOld, user.getId());
        if (resultCout == 0) {
            return ServerResponse.createByError("旧密码错误");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
        int updateCount = userMapper.updateSelectUserInfo(user);
        if (updateCount > 0) {
            return ServerResponse.createByError("密码更新成功");
        }
        return ServerResponse.createByError("密码更新失败");
    }

    /**
     *更新用户的信息
     * @param user
     * @return
     * @throws Exception
     */
    public ServerResponse<User> updateInformation(User user) throws Exception {
        int resultCount = userMapper.checkEmailByUserId(user.getEmail(),user.getId());
        if(resultCount>0){
            return ServerResponse.createByError("Email已经存在,请更新Email尝试更新");
        }

        User updUser =  new User();
        updUser.setId(user.getId());
        updUser.setEmail(user.getEmail());
        updUser.setPhone(user.getPhone());
        updUser.setQuestion(user.getQuestion());
        updUser.setAnswer(user.getAnswer());
        resultCount = userMapper.updateSelectUserInfo(updUser);
        if(resultCount>0){
            return ServerResponse.createBySuccess("更新成功",updUser);
        }
        return ServerResponse.createByError("更新失败");
    }

    /**
     * 获取用户的信息
     * @param userId
     * @return
     * @throws Exception
     */
    public ServerResponse<User> getInformation(Integer userId) throws Exception{
        User user =userMapper.selectByPrimaryId(userId);
        if (user == null){
            return ServerResponse.createByError("用户为空，请登录");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }

    /**
     * 检查用户是否存在
     * @param user
     * @return
     */
    public ServerResponse<String> checkAdminRole(User user){

        if(user != null && user.getRole() == Const.Role.ROLE_ADMIN){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

}
