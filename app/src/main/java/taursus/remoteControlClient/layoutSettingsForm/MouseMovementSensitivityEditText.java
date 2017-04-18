package taursus.remoteControlClient.layoutSettingsForm;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import taursus.remoteControlClient.ISettingsRepository;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class MouseMovementSensitivityEditText extends ViewBase {
    ISettingsRepository settingsRepository;

    public MouseMovementSensitivityEditText(ISettingsRepository settingsRepository) {
        super();
        this.viewId = R.id.mouseMovementSensitivityEditText;
        this.settingsRepository = settingsRepository;
    }

    public EditText getView() {
        return (EditText) this.view;
    }

    @Override
    public void onInitialized() {
        float defaultMouseMovementSensitivity = this.settingsRepository.getFloat("mouseMovementSensitivity", 1f);
        this.getView().setText(String.valueOf(defaultMouseMovementSensitivity));

        this.getView().addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                MouseMovementSensitivityEditText.this.onTextChanged();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    protected void onTextChanged() {
        String sensitivityString = this.getView().getText().toString();

        try
        {
            float sensitivity = Float.valueOf(sensitivityString);
            this.settingsRepository.setFloat("mouseMovementSensitivity", sensitivity);
        }
        catch(NumberFormatException e)
        {

        }
    }
}
