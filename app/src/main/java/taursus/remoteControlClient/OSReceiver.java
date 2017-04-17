package taursus.remoteControlClient;

import taursus.remoteControl.EventDataReceiver;
import taursus.remoteControl.IEventData;
import taursus.remoteControl.IEventDataSerializer;
import taursus.remoteControl.ITransporter;

public class OSReceiver extends EventDataReceiver {
    protected byte OS;

    public OSReceiver(ITransporter transporter, IEventDataSerializer eventDataSerializer) {
        super(transporter, eventDataSerializer);
    }

    public void processEvent(IEventData event) {
        switch(event.getType()) {

            case IEventData.EVENT_OS:
                this.OS = event.getOS();
                break;
        }
    }

    public byte getOS() {
        return this.OS;
    }
}
