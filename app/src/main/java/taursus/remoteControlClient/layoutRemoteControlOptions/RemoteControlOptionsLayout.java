package taursus.remoteControlClient.layoutRemoteControlOptions;

import taursus.remoteControlClient.Client;
import taursus.remoteControlClient.simpleFramework.LayoutBase;
import taursus.remoteControlClient.OptionsControlEventSender;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.activities.RemoteControlActivity;
import taursus.remoteControl.EventDataSerializer;
import taursus.remoteControl.IEventDataSerializer;
import taursus.remoteControl.IOptionsControl;

public class RemoteControlOptionsLayout extends LayoutBase {

    public RemoteControlOptionsLayout() {
        this.layoutId = R.layout.remote_control_options;
    }

    public RemoteControlActivity getActivity() {
        return (RemoteControlActivity)this.activity;
    }

    @Override
    protected void onInitialized() {
        Client client = this.getActivity().getClient();
        IEventDataSerializer serializer = EventDataSerializer.getInstance();

        IOptionsControl optionsControl = new OptionsControlEventSender(client, serializer);

        registerView(new CommandKeyButton(optionsControl));
        registerView(new CtrlAltDeleteButton(optionsControl));
        registerView(new HibernateButton(optionsControl));
        registerView(new OptionsHideButton());
        registerView(new PrintScreenButton(optionsControl));
        registerView(new RestartButton(optionsControl));
        registerView(new ShutdownButton(optionsControl));
        registerView(new TaskManagerButton(optionsControl));
        registerView(new TurnOffMonitorButton(optionsControl));
        registerView(new VolumeDownButton(optionsControl));
        registerView(new VolumeUpButton(optionsControl));
        registerView(new SoundMuteButton(optionsControl));
    }
}
