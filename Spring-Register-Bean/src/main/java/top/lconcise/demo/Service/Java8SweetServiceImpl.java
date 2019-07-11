package top.lconcise.demo.Service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by liusj on 2019/7/11
 */
@Service
@Profile("java8")
public class Java8SweetServiceImpl implements SweetService {

    @Override
    public void eat() {
        System.out.println("Java8 环境下执行");
    }
}
