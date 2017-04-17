package taursus.remoteControlClient.layoutRemoteControl;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import taursus.remoteControlClient.IOnKeyListener;
import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.simpleFramework.IViewOnKeyListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class KeyboardShowButton extends ViewBase implements IViewOnClickListener, IViewOnKeyListener {
    protected IOnKeyListener onKeyListener;

    public KeyboardShowButton(IOnKeyListener onKeyListener) {
        super();
        this.viewId = R.id.keyboardShow;
        this.onKeyListener = onKeyListener;
    }

    @Override
    public void onClick(View v) {
        showKeyboard();
    }

    protected void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.layout.getActivity().getSystemService(this.layout.getActivity().INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInputFromWindow(this.getView().getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent ev) {
        onKeyListener.onKey(ev);
        return true;
    }
}
