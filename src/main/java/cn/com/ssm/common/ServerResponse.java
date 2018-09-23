package cn.com.ssm.common;
import cn.com.ssm.pojo.User;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证在序列化的时候如果是空值，那么key也消失
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private  T  data;


    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status,T data){
        this.status = status;
        this.data =data;
    }

    private ServerResponse(int status,String msg,T data){
        this.data = data;
        this.msg = msg;
        this.status = status;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }
    @JsonIgnore
    //使之不再json序列化结果中
    public  boolean isSuccess(){
        return ResponseCode.SUCCESS.getCode() == status;
    }

    public int getStatus(){
        return status;
    }

    public T getData(){
        return data;
    }

    public String getMsg(){
        return msg;
    }

    public static <T>  ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static  <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> createByError(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ServerResponse<T> createByError(int code,String msg){
        return new ServerResponse<T>(code,msg);
    }
}
