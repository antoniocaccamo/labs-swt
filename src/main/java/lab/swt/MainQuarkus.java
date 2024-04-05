package lab.swt;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lab.swt.event.StartApplicationEvent;
import lab.swt.ui.MainUI;
import lombok.extern.slf4j.Slf4j;

/**
 * @auhtor antonio.caccamo on 2024-04-05 @ 12:25
 */

@Slf4j
@Singleton
public class MainQuarkus  {

    @Inject
    MainUI ui;

    @EventListener
    public void onApplicationEvent(StartApplicationEvent event) {
        // startup logic here
        log.warn("###################################");
        log.warn("################### show ui: {}", event);

        ui.setBlockOnOpen(true);
        ui.open();
    }
}
