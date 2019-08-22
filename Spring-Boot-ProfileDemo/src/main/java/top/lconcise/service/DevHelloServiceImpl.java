package top.lconcise.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by liusj on 2019/8/22
 */
@Service
@Profile("dev")
public class DevHelloServiceImpl implements HelloService {

    @Value("${test_name}")
    private String testName;

    @Override
    public String getTestName() {
        return "开发环境   "+testName;
    }
}
