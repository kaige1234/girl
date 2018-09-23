package cn.com.ssm.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "auto")
public class AutowireTestSpring {

    @Autowired
    private TestSprint testSprint;

    public void getTest(){
        testSprint.getSpring();
    }
}
