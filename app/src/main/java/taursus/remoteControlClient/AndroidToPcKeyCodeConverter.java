package taursus.remoteControlClient;

import android.view.KeyEvent;

import java.util.HashMap;

public class AndroidToPcKeyCodeConverter {

    public int convert(int keyCode) {
        if(keyCode >= KeyEvent.KEYCODE_A && keyCode <= KeyEvent.KEYCODE_Z) {
            keyCode += 36;
        }
        else if(keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) {
            keyCode += 41;
        }
        else {
            HashMap<Integer, Integer> keyMap = new HashMap<Integer, Integer>();
            keyMap.put(KeyEvent.KEYCODE_DEL, 8); //backspace
            keyMap.put(KeyEvent.KEYCODE_ENTER, 10);
            keyMap.put(KeyEvent.KEYCODE_SPACE, 32);
            keyMap.put(KeyEvent.KEYCODE_PERIOD, 46);
            keyMap.put(KeyEvent.KEYCODE_COMMA, 44);

            if(keyMap.containsKey(keyCode)) {
                keyCode = keyMap.get(keyCode);
            }
        }

        return keyCode;
    }
}
