package top.lconcise.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;

/**
 * Created by liusj on 2019/7/12
 */
public class AfterContextClosedEventListener implements ApplicationListener<ContextClosedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("AfterContextClosedEvent: " + contextClosedEvent.getApplicationContext().getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
