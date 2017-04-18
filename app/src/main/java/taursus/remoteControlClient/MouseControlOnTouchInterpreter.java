package taursus.remoteControlClient;

import taursus.remoteControl.*;

import android.view.MotionEvent;

public class MouseControlOnTouchInterpreter implements IOnTouchListener {
	protected IMouseControl mouseControl;
	
	protected float touchStartingPositionX;
	protected float touchStartingPositionY;
	
	protected float touchLastMovePositionX;
	protected float touchLastMovePositionY;

    protected short pointersDown = 0;
    protected boolean releaseLeftButtonOnPointerUp = false;
    protected long lastPointerDownTime = 0;
    protected short twoTimesClickTime = 200;

    protected float scrollSensitivity = 0.1f;
    protected float accumulatedScrollAmount = 0f;

    protected float mouseMovementSensitivity = 1f;
    protected float accumulatedMouseMoveX = 0f;
    protected float accumulatedMouseMoveY = 0f;
	
	public MouseControlOnTouchInterpreter(IMouseControl mouseControl) {
		this.mouseControl = mouseControl;
	}

	public void setScrollSensitivity(float scrollSensitivity) {
        this.scrollSensitivity = scrollSensitivity;
    }

    public void setMouseMovementSensitivity(float mouseMovementSensitivity) {
        this.mouseMovementSensitivity = mouseMovementSensitivity;
    }

	protected void actionDown(MotionEvent ev) {
        this.touchStartingPositionX = ev.getRawX();
        this.touchStartingPositionY = ev.getRawY();

        this.touchLastMovePositionX = ev.getRawX();
        this.touchLastMovePositionY = ev.getRawY();

        this.pointersDown++;

        if(this.lastPointerDownTime + this.twoTimesClickTime > System.currentTimeMillis()) {
            this.releaseLeftButtonOnPointerUp = true;
            this.mouseControl.leftButtonPress();
        }

        this.lastPointerDownTime = System.currentTimeMillis();
    }

    protected void actionUp() {
        if(this.releaseLeftButtonOnPointerUp) {
            this.mouseControl.leftButtonRelease();
        }

        if(this.touchStartingPositionX == this.touchLastMovePositionX && this.touchStartingPositionY == this.touchLastMovePositionY) {
            this.mouseControl.leftButtonPress();
            this.mouseControl.leftButtonRelease();
        }

        this.pointersDown--;
    }

    protected void actionPointerDown() {
        this.pointersDown++;
    }

    protected void actionPointerUp() {
        this.pointersDown--;
    }

    protected void actionMove(MotionEvent ev) {
        if(this.pointersDown > 1) {
            scroll(ev.getRawY() - this.touchLastMovePositionY);
        } else {
            float moveX = ev.getRawX() - this.touchLastMovePositionX;
            float moveY = ev.getRawY() - this.touchLastMovePositionY;
            mouseMove(moveX, moveY);
        }

        this.touchLastMovePositionX = ev.getRawX();
        this.touchLastMovePositionY = ev.getRawY();
    }

    protected void mouseMove(float moveX, float moveY) {
        this.accumulatedMouseMoveX += moveX * this.mouseMovementSensitivity;
        this.accumulatedMouseMoveY += moveY * this.mouseMovementSensitivity;

        short currentMoveX = (short) this.accumulatedMouseMoveX;
        short currentMoveY = (short) this.accumulatedMouseMoveY;

        this.mouseControl.moveCursor(currentMoveX, currentMoveY);

        this.accumulatedMouseMoveX -= currentMoveX;
        this.accumulatedMouseMoveY -= currentMoveY;
    }

    protected void scroll(float amount) {
        this.accumulatedScrollAmount += amount * this.scrollSensitivity;

        short scroll = (short) this.accumulatedScrollAmount;
        this.mouseControl.scroll(scroll);
        this.accumulatedScrollAmount -= scroll;
    }

	@Override
	public void onTouch(MotionEvent ev) {
		switch (ev.getAction() & MotionEvent.ACTION_MASK) {
	        case MotionEvent.ACTION_DOWN:
	           actionDown(ev);
	            break;
	        case MotionEvent.ACTION_UP:
	            actionUp();
	            break;
	        case MotionEvent.ACTION_POINTER_DOWN:
                actionPointerDown();
	            break;
	        case MotionEvent.ACTION_POINTER_UP:
                actionPointerUp();
	            break;
	        case MotionEvent.ACTION_MOVE:
	            actionMove(ev);
	            break;
	    }
	}

}
