package top.lconcise.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by liusj on 2019/8/22
 */
@Component
public class ProfileUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取当前环境的active profile.
     *
     * @return
     */
    public static String getActiveProfile() {
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        if (!ArrayUtils.isEmpty(activeProfiles)) {
            return activeProfiles[0];
        }
        return "";
    }
}
