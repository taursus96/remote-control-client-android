package taursus.remoteControlClient.simpleFramework;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public abstract class ViewBase {
    protected LayoutBase layout;
    protected int viewId;
    protected View view;

    public void init(LayoutBase layout) {
        this.layout = layout;
        this.view = this.layout.getActivity().findViewById(this.viewId);

        registerListeners();
        onInitialized();
    }

    protected void registerListeners() {
        if(this instanceof IViewOnClickListener) {
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((IViewOnClickListener)ViewBase.this).onClick(v);
                }
            });
        }

        if(this instanceof IViewOnKeyListener) {
            this.view.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent ev) {
                    return ((IViewOnKeyListener) ViewBase.this).onKey(v, keyCode, ev);
                }
            });
        }

        if(this instanceof IViewOnTouchListener) {
            this.view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent ev) {
                    return ((IViewOnTouchListener) ViewBase.this).onTouch(v, ev);
                }
            });
        }

        if(this instanceof IViewAfterTextChangedListener) {
            EditText editText = (EditText) getView();
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    ((IViewAfterTextChangedListener)ViewBase.this).afterTextChanged(s);
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}
            });
        }
    }

    public View getView() {
        return this.view;
    }

    public void close() {}
    public void onInitialized() {}
}
