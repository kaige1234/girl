package cn.com.ssm.mapper;

import cn.com.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper{
    //查询用户是否存在
    int queryUserCount(String userName) throws Exception;
    //查询用户的密码是否正确
    User selectLogin(@Param("userName") String userName, @Param("password")String password) throws Exception;
    //查询用户的email是否存在
    int queryUserByEmail(String email) throws Exception;
    //插入用户信息
    int saveUserInfo(User user) throws Exception;
    //通过用户查询问题
    String selectQuestionByUserName(String userName) throws Exception;
    //通过用户名-问题-答案 查询问题答案是否存在；
    int checkAnswer(@Param("userName") String userName,@Param("question")String question,@Param("answer")String answer) throws  Exception;
    //修改密码
    int updatePasswordByUsername(@Param("username") String username,
                                 @Param("password")String password);
    //查看旧密码是否存在
    int checkPassword( @Param("passwordOld") String passwordOld,@Param("id") int id) throws  Exception;
    //一次更改去不字段
    int updateAllUserInfo(User user) throws Exception;
    //选择性更改要更改的字段
    int updateSelectUserInfo(User user) throws Exception;
    //检查用户的email是否重复了
    int checkEmailByUserId(@Param("email") String email,@Param("userId") Integer userId) throws Exception;
    //通过userid查询用户的信息
    User selectByPrimaryId(int id)throws  Exception;
}
