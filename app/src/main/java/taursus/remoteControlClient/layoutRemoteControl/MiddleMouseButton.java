package taursus.remoteControlClient.layoutRemoteControl;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IMouseControl;

public class MiddleMouseButton extends ViewBase implements IViewOnClickListener {
    protected IMouseControl mouseControl;

    public MiddleMouseButton(IMouseControl mouseControl) {
        super();
        this.viewId = R.id.middleMouseButton;
        this.mouseControl = mouseControl;
    }

    @Override
    public void onClick(View v) {
        this.mouseControl.middleButtonPress();
        this.mouseControl.middleButtonRelease();
    }

}
