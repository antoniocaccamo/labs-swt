package lab.swt;


import io.micronaut.context.ApplicationContext;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.runtime.Micronaut;
import lab.swt.event.StartApplicationEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainApplication {


    private static ApplicationContext Context;

    public static void main(String... args) {
        log.info("Running main method");

//        MainUI ui = new MainUI();
//        ui.setBlockOnOpen(true);
//        ui.open();

        Context=Micronaut.run(MainApplication.class, args);

        Context.getAllBeanDefinitions().stream()
                                               .forEach(b -> log.debug("{}", b.getName()));


        log.warn("--------------------------------------------");
        Context.publishEvent(StartApplicationEvent.builder().build());





    }


}
