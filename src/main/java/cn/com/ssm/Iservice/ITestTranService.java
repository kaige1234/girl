package cn.com.ssm.Iservice;

import cn.com.ssm.mapper.TestTranMapper;
import cn.com.ssm.po.TestTran;
import cn.com.ssm.service.TestTranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ITestTranService implements TestTranService {

    @Autowired
    private TestTranMapper testTranMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer saveTestTran() {
        TestTran testTran = new TestTran();
        testTran.setId(1);
        testTran.setName("sunkai222");
        int result = testTranMapper.saveTestTran(testTran);
       int i =0;
        i=i/0;
        return result;
    }
}
