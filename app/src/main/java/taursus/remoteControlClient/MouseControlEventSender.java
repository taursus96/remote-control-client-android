package taursus.remoteControlClient;

import taursus.remoteControl.*;

public class MouseControlEventSender extends EventDataSender implements IMouseControl {

	public MouseControlEventSender(ITransporter transporter, IEventDataSerializer serializer) {
		super(transporter, serializer);
	}

	@Override
	public IMouseControl moveCursor(short x, short y) {
		if(x != 0 || y != 0) {
			IEventData data = new EventData();
			data.setType(IEventData.EVENT_MOVE_MOUSE);
			data.setMoveMouseX(x);
			data.setMoveMouseY(y);
			sendEventData(data);
		}

		return this;
	}

	@Override
	public IMouseControl leftButtonPress() {
		sendType(IEventData.EVENT_PRESSED_LEFT_MOUSE_BUTTON);
		return this;
	}

	@Override
	public IMouseControl leftButtonRelease() {
		sendType(IEventData.EVENT_RELEASED_LEFT_MOUSE_BUTTON);

		return this;
	}

	@Override
	public IMouseControl rightButtonPress() {
		sendType(IEventData.EVENT_PRESSED_RIGHT_MOUSE_BUTTON);
		return this;
	}

	@Override
	public IMouseControl rightButtonRelease() {
		sendType(IEventData.EVENT_RELEASED_RIGHT_MOUSE_BUTTON);
		return this;
	}

	@Override
	public IMouseControl middleButtonPress() {
		sendType(IEventData.EVENT_PRESSED_MIDDLE_MOUSE_BUTTON);
		return this;
	}

	@Override
	public IMouseControl middleButtonRelease() {
		sendType(IEventData.EVENT_RELEASED_MIDDLE_MOUSE_BUTTON);
		return this;
	}

	@Override
	public IMouseControl scroll(short amount) {
		IEventData data = new EventData();
		data.setType(IEventData.EVENT_SCROLL);
		data.setScroll(amount);
		sendEventData(data);
		return this;
	}
}
