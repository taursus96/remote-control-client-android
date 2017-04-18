package taursus.remoteControlClient;

public class MouseMovementSensitivitySettingObserver implements IOnSettingChanged {
    protected ISettingsRepository settingsRepository;
    protected MouseControlOnTouchInterpreter mouseControlOnTouchInterpreter;

    public MouseMovementSensitivitySettingObserver(ISettingsRepository settingsRepository, MouseControlOnTouchInterpreter mouseControlOnTouchInterpreter) {
        this.settingsRepository = settingsRepository;
        this.mouseControlOnTouchInterpreter = mouseControlOnTouchInterpreter;

        float mouseMovementSensitivity = this.settingsRepository.getFloat("mouseMovementSensitivity", 1f);
        this.mouseControlOnTouchInterpreter.setMouseMovementSensitivity(mouseMovementSensitivity);
        this.settingsRepository.registerOnConnectedListener(this);
    }

    @Override
    public void onSettingsChanged(String name, Object value) {
        if(name != "mouseMovementSensitivity") {
            return;
        }

        this.mouseControlOnTouchInterpreter.setMouseMovementSensitivity((float) value);
    }
}
