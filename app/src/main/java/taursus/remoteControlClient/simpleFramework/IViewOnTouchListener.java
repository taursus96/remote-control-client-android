package taursus.remoteControlClient.simpleFramework;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public interface IViewOnTouchListener {
    boolean onTouch(View v, MotionEvent ev) ;
}
