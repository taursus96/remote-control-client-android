package taursus.remoteControlClient.layoutRemoteControlOptions;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IOptionsControl;

public class PrintScreenButton extends ViewBase implements IViewOnClickListener {
    protected IOptionsControl optionsControl;

    public PrintScreenButton(IOptionsControl optionsControl) {
        super();
        this.optionsControl = optionsControl;
        this.viewId = R.id.optionPrintScreen;
    }

    public void onClick(View v) {
        this.optionsControl.printScreen();
    }
}
