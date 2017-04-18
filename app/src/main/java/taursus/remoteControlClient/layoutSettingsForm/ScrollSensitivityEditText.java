package taursus.remoteControlClient.layoutSettingsForm;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import taursus.remoteControlClient.ISettingsRepository;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.IViewAfterTextChangedListener;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class ScrollSensitivityEditText extends ViewBase implements IViewAfterTextChangedListener {
    ISettingsRepository settingsRepository;

    public ScrollSensitivityEditText(ISettingsRepository settingsRepository) {
        super();
        this.viewId = R.id.scrollSensitivityEditText;
        this.settingsRepository = settingsRepository;
    }

    public EditText getView() {
        return (EditText) this.view;
    }

    @Override
    public void onInitialized() {
        float defaultScrollSensitivity = this.settingsRepository.getFloat("scrollSensitivity", 0.1f);
        this.getView().setText(String.valueOf(defaultScrollSensitivity));
    }

    public void afterTextChanged(Editable s) {
        String sensitivityString = this.getView().getText().toString();

        try {
            float sensitivity = Float.valueOf(sensitivityString);
            this.settingsRepository.setFloat("scrollSensitivity", sensitivity);
        } catch(NumberFormatException e) {

        }
    }
}
