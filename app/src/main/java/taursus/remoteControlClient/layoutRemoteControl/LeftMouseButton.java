package taursus.remoteControlClient.layoutRemoteControl;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IMouseControl;

public class LeftMouseButton extends ViewBase implements IViewOnClickListener {
    protected IMouseControl mouseControl;

    public LeftMouseButton(IMouseControl mouseControl) {
        super();
        this.viewId = R.id.leftMouseButton;
        this.mouseControl = mouseControl;
    }

    @Override
    public void onClick(View v) {
        this.mouseControl.leftButtonPress();
        this.mouseControl.leftButtonRelease();
    }

    @Override
    public void onInitialized() {

    }
}
