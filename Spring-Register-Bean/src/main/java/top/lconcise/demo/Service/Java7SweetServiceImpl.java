package top.lconcise.demo.Service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by liusj on 2019/7/11
 */
@Service
@Profile("java7")
public class Java7SweetServiceImpl implements SweetService {

    @Override
    public void eat() {
        System.out.println("Java7 环境下执行");
    }
}
