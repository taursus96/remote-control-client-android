package taursus.remoteControlClient.layoutRemoteControl;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IMouseControl;

public class RightMouseButton extends ViewBase implements IViewOnClickListener {
    protected IMouseControl mouseControl;

    public RightMouseButton(IMouseControl mouseControl) {
        super();
        this.viewId = R.id.rightMouseButton;
        this.mouseControl = mouseControl;
    }

    @Override
    public void onClick(View v) {
        this.mouseControl.rightButtonPress();
        this.mouseControl.rightButtonRelease();
    }
}
