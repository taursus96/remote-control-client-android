package taursus.remoteControlClient;

import android.util.Log;
import android.view.KeyEvent;
import taursus.remoteControl.IKeyboardControl;

public class KeyboardControlOnKeyInterpreter implements IOnKeyListener {
    protected IKeyboardControl keyboardControl;

    public KeyboardControlOnKeyInterpreter(IKeyboardControl keyboardControl) {
        this.keyboardControl = keyboardControl;
    }

    public void onKey(KeyEvent ev) {

        switch (ev.getAction()) {
            case KeyEvent.ACTION_DOWN:
                this.keyboardControl.pressKey(ev.getKeyCode());
                break;
            case KeyEvent.ACTION_UP:
                this.keyboardControl.releaseKey(ev.getKeyCode());
                break;
        }
    }

}
