package taursus.remoteControlClient.layoutConnectForm;

import android.preference.PreferenceManager;
import android.widget.EditText;

import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class PortEditText extends ViewBase {
    public PortEditText() {
        super();
        this.viewId = R.id.portEditText;
    }

    public EditText getView() {
        return (EditText) this.view;
    }

    @Override
    public void onInitialized() {
        int defaultPort = PreferenceManager.getDefaultSharedPreferences(this.layout.getActivity().getBaseContext()).getInt("port", 4000);
        this.getView().setText(String.valueOf(defaultPort));
    }
}
