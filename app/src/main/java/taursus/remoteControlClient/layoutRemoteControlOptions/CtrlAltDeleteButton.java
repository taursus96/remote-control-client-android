package taursus.remoteControlClient.layoutRemoteControlOptions;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IOptionsControl;

public class CtrlAltDeleteButton extends ViewBase implements IViewOnClickListener {
    protected IOptionsControl optionsControl;

    public CtrlAltDeleteButton(IOptionsControl optionsControl) {
        super();
        this.optionsControl = optionsControl;
        this.viewId = R.id.optionCtrlAltDelete;
    }

    public void onClick(View v) {
        this.optionsControl.ctrlAltDelete();
    }
}
