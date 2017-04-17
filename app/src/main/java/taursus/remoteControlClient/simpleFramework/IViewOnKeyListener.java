package taursus.remoteControlClient.simpleFramework;

import android.view.KeyEvent;
import android.view.View;

public interface IViewOnKeyListener {
    boolean onKey(View v, int keyCode, KeyEvent ev);
}
