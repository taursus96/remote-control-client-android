package taursus.remoteControlClient;

import taursus.remoteControl.EventDataSender;
import taursus.remoteControl.IEventData;
import taursus.remoteControl.IEventDataSerializer;
import taursus.remoteControl.IOptionsControl;
import taursus.remoteControl.ITransporter;

import java.util.HashMap;

public class OptionsControlEventSender extends EventDataSender implements IOptionsControl {

    public OptionsControlEventSender(ITransporter transporter, IEventDataSerializer serializer) {
        super(transporter, serializer);
    }

    @Override
    public IOptionsControl shutdown() {
        sendType(IEventData.EVENT_OPTION_SHUTDOWN);
        return this;
    }

    @Override
    public IOptionsControl hibernate() {
        sendType(IEventData.EVENT_OPTION_HIBERNATE);
        return this;
    }

    @Override
    public IOptionsControl restart() {
        sendType(IEventData.EVENT_OPTION_RESTART);
        return this;
    }

    @Override
    public IOptionsControl printScreen() {
        sendType(IEventData.EVENT_OPTION_PRINT_SCREEN);
        return this;
    }

    @Override
    public IOptionsControl taskManager() {
        sendType(IEventData.EVENT_OPTION_TASK_MANAGER);
        return this;
    }

    @Override
    public IOptionsControl ctrlAltDelete() {
        sendType(IEventData.EVENT_OPTION_CTRL_ALT_DELETE);
        return this;
    }

    @Override
    public IOptionsControl commandKey() {
        sendType(IEventData.EVENT_OPTION_COMMAND_KEY);
        return this;
    }

    @Override
    public IOptionsControl turnOffMonitor() {
        sendType(IEventData.EVENT_OPTION_TURN_OFF_MONITOR);
        return this;
    }

    @Override
    public IOptionsControl volumeUp() {
        sendType(IEventData.EVENT_OPTION_VOLUME_UP);
        return this;
    }

    @Override
    public IOptionsControl volumeDown() {
        sendType(IEventData.EVENT_OPTION_VOLUME_DOWN);
        return this;
    }

    @Override
    public IOptionsControl soundMute() {
        sendType(IEventData.EVENT_OPTION_SOUND_MUTE);
        return this;
    }
}
