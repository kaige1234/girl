package cn.com.ssm.Test.Aspect.Service;

import org.springframework.stereotype.Service;
@ArgeAnnotation
@Service
public class UserService {
    public void add(){
        System.out.println("地对地导弹");
    }

    public void upd(String Name){
        System.out.println("修改="+Name);
    }
    public void inset(Integer Name){
        System.out.println("插入="+Name);
    }
    public void del(String Id){
        System.out.println("删除数据");
    }

}
