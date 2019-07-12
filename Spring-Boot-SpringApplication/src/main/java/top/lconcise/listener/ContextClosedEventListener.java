package top.lconcise.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by liusj on 2019/7/12
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("ContextClosedEvent: " + contextClosedEvent.getApplicationContext().getId());
    }
}
