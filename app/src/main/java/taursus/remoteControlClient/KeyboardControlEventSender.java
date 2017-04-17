package taursus.remoteControlClient;

import taursus.remoteControl.*;

public class KeyboardControlEventSender extends EventDataSender implements IKeyboardControl {
    protected AndroidToPcKeyCodeConverter keyCodeConverter;

    public KeyboardControlEventSender(ITransporter transporter, IEventDataSerializer serializer, AndroidToPcKeyCodeConverter keyCodeConverter) {
        super(transporter, serializer);
        this.keyCodeConverter = keyCodeConverter;
    }

    @Override
    public IKeyboardControl pressKey(int keyCode) {
        keyCode = this.keyCodeConverter.convert(keyCode);
        IEventData data = new EventData();
        data.setType(IEventData.EVENT_KEY_PRESSED);
        data.setKeyCode(keyCode);
        this.sendEventData(data);
        return this;
    }

    @Override
    public IKeyboardControl releaseKey(int keyCode) {
        keyCode = this.keyCodeConverter.convert(keyCode);
        IEventData data = new EventData();
        data.setType(IEventData.EVENT_KEY_RELEASED);
        data.setKeyCode(keyCode);
        this.sendEventData(data);
        return this;
    }
}
