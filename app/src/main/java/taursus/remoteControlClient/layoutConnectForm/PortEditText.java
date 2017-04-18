package taursus.remoteControlClient.layoutConnectForm;

import android.preference.PreferenceManager;
import android.widget.EditText;

import taursus.remoteControlClient.ISettingsRepository;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class PortEditText extends ViewBase {
    ISettingsRepository settingsRepository;

    public PortEditText(ISettingsRepository settingsRepository) {
        super();
        this.viewId = R.id.portEditText;
        this.settingsRepository = settingsRepository;
    }

    public EditText getView() {
        return (EditText) this.view;
    }

    @Override
    public void onInitialized() {
        int defaultPort = this.settingsRepository.getInt("port", 4000);
        this.getView().setText(String.valueOf(defaultPort));
    }
}
