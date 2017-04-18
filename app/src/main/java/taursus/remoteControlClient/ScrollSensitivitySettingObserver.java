package taursus.remoteControlClient;

public class ScrollSensitivitySettingObserver implements IOnSettingChanged {
    protected ISettingsRepository settingsRepository;
    protected MouseControlOnTouchInterpreter mouseControlOnTouchInterpreter;

    public ScrollSensitivitySettingObserver(ISettingsRepository settingsRepository, MouseControlOnTouchInterpreter mouseControlOnTouchInterpreter) {
        this.settingsRepository = settingsRepository;
        this.mouseControlOnTouchInterpreter = mouseControlOnTouchInterpreter;

        float scrollSensitivity = this.settingsRepository.getFloat("scrollSensitivity", 0.1f);
        this.mouseControlOnTouchInterpreter.setScrollSensitivity(scrollSensitivity);
        this.settingsRepository.registerOnConnectedListener(this);
    }

    @Override
    public void onSettingsChanged(String name, Object value) {
        if(name != "scrollSensitivity") {
            return;
        }

        this.mouseControlOnTouchInterpreter.setScrollSensitivity((float) value);
    }
}
