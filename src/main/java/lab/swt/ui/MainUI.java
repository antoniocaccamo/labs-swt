package lab.swt.ui;

import com.diffplug.common.rx.Rx;
import com.diffplug.common.swt.SwtRx;
import jakarta.inject.Singleton;
import kotlin.Unit;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.widgets.BrowserFactory;
import org.eclipse.jface.widgets.ButtonFactory;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


@Slf4j
@Singleton
public class MainUI extends ApplicationWindow {



    protected String applicationName = "lab-swt";

    public MainUI() {
        super(null);
        
    }

    @Override
    protected Control createContents(Composite parent) {
        
        log.info("creating contents ..");

        parent.getShell().setText(applicationName);
        GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(true).applyTo(parent);
//        Layouts.setGrid(parent)
//                .numColumns(1)
//                .columnsEqualWidth(true)
//                .horizontalSpacing(0)
//                .verticalSpacing(0);
        final Browser b = BrowserFactory.newBrowser(SWT.NONE).url("http://localhost:8080/hello").create(parent);
        GridDataFactory.fillDefaults()
                .grab(true,true)
                .applyTo(b);
        //Layouts.setGridData(b).grabAll();
        Button btn = ButtonFactory.newButton(SWT.NONE).text(applicationName)
                //        .onSelect(evt -> log.info("change url {}",  b.setUrl("https://www.google.com")))
                .create(parent)
                ;

        Rx.subscribe(SwtRx.addListener(btn, SWT.Selection) , event -> b.setUrl("https://www.google.com"));
        //Layouts.setGridData(btn).grabHorizontal().horizontalAlignment(GridData.HORIZONTAL_ALIGN_CENTER);
        GridDataFactory.fillDefaults()
                .grab(true,false)
                //.align(GridData.HORIZONTAL_ALIGN_CENTER, GridData.VERTICAL_ALIGN_CENTER)
                .applyTo(btn);
        parent.setSize(400, 200);

        Rx.subscribe(SwtRx.addListener(parent, SWT.Resize, SWT.Move), event -> log.info("{}", event));
        return parent;
    }


}
