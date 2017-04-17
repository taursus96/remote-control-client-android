package taursus.remoteControlClient.layoutConnectForm;

import android.preference.PreferenceManager;
import android.widget.EditText;

import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class HostEditText extends ViewBase {

    public HostEditText() {
        super();
        this.viewId = R.id.hostEditText;
    }

    public EditText getView() {
        return (EditText) this.view;
    }

    @Override
    public void onInitialized() {
        String defaultHost = PreferenceManager.getDefaultSharedPreferences(this.layout.getActivity().getBaseContext()).getString("host", "10.0.2.2");
        this.getView().setText(defaultHost);
    }
}
