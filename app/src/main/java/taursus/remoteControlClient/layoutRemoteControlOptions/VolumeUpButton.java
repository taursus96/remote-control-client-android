package taursus.remoteControlClient.layoutRemoteControlOptions;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IOptionsControl;

public class VolumeUpButton extends ViewBase implements IViewOnClickListener {
    protected IOptionsControl optionsControl;

    public VolumeUpButton(IOptionsControl optionsControl) {
        super();
        this.optionsControl = optionsControl;
        this.viewId = R.id.optionVolumeUp;
    }

    public void onClick(View v) {
        this.optionsControl.volumeUp();
    }
}
