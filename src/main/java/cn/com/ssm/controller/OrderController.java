package cn.com.ssm.controller;

import cn.com.ssm.Iservice.ITestTranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ITestTranService iTestTranService;

    @RequestMapping(value = "/saveOrder")
    public void saveOrder(){
        iTestTranService.saveTestTran();
    }
}
