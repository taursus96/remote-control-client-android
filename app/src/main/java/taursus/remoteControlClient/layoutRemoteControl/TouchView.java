package taursus.remoteControlClient.layoutRemoteControl;

import android.view.MotionEvent;
import android.view.View;

import taursus.remoteControlClient.IOnTouchListener;
import taursus.remoteControlClient.simpleFramework.IViewOnTouchListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class TouchView extends ViewBase implements IViewOnTouchListener {
    protected IOnTouchListener onTouchListener;

    public TouchView(IOnTouchListener onTouchListener) {
        super();
        this.viewId = R.id.touchView;
        this.onTouchListener = onTouchListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent ev) {
        onTouchListener.onTouch(ev);
        return true;
    }
}
