package taursus.remoteControlClient.layoutRemoteControl;

import taursus.remoteControlClient.AndroidToPcKeyCodeConverter;
import taursus.remoteControlClient.Client;
import taursus.remoteControlClient.IOnKeyListener;
import taursus.remoteControlClient.IOnTouchListener;
import taursus.remoteControlClient.KeyboardControlEventSender;
import taursus.remoteControlClient.KeyboardControlOnKeyInterpreter;
import taursus.remoteControlClient.ScrollSensitivitySettingObserver;
import taursus.remoteControlClient.activities.AppBaseActivity;
import taursus.remoteControlClient.simpleFramework.LayoutBase;
import taursus.remoteControlClient.MouseControlEventSender;
import taursus.remoteControlClient.MouseControlOnTouchInterpreter;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.activities.RemoteControlActivity;
import taursus.remoteControl.EventDataSerializer;
import taursus.remoteControl.IEventDataSerializer;
import taursus.remoteControl.IKeyboardControl;
import taursus.remoteControl.IMouseControl;

public class RemoteControlLayout extends LayoutBase {

    public RemoteControlLayout() {
        this.layoutId = R.layout.remote_control;
    }

    public RemoteControlActivity getActivity() {
        return (RemoteControlActivity)this.activity;
    }

    @Override
    protected void onInitialized() {
        Client client = this.getActivity().getClient();
        IEventDataSerializer serializer = EventDataSerializer.getInstance();
        IMouseControl mouseControlEventSender = new MouseControlEventSender(client, serializer);
        IKeyboardControl keyboardControlEventSender = new KeyboardControlEventSender(client, serializer, new AndroidToPcKeyCodeConverter());
        MouseControlOnTouchInterpreter mouseControlTouchInterpreter = new MouseControlOnTouchInterpreter(mouseControlEventSender);
        IOnKeyListener keyboardControlTouchInterpreter = new KeyboardControlOnKeyInterpreter(keyboardControlEventSender);
        ScrollSensitivitySettingObserver scrollSensitivitySettingObserver = new ScrollSensitivitySettingObserver(AppBaseActivity.settingsRepository, mouseControlTouchInterpreter);

        registerView(new TouchView(mouseControlTouchInterpreter));
        registerView(new KeyboardShowButton(keyboardControlTouchInterpreter));
        registerView(new LeftMouseButton(mouseControlEventSender));
        registerView(new MiddleMouseButton(mouseControlEventSender));
        registerView(new RightMouseButton(mouseControlEventSender));
        registerView(new OptionsShowButton());
    }
}
