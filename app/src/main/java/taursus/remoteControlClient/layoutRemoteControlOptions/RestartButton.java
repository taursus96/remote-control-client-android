package taursus.remoteControlClient.layoutRemoteControlOptions;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IOptionsControl;

public class RestartButton extends ViewBase implements IViewOnClickListener {
    protected IOptionsControl optionsControl;

    public RestartButton(IOptionsControl optionsControl) {
        super();
        this.optionsControl = optionsControl;
        this.viewId = R.id.optionRestart;
    }

    public void onClick(View v) {
        this.optionsControl.restart();
    }
}
