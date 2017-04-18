package taursus.remoteControlClient;

public interface ISettingsRepository {
    public void set(String name, String value);
    public void setBool(String name, boolean value);
    public void setInt(String name, int value);
    public void setFloat(String name, float value);

    public String get(String name, String defaultValue);
    public boolean getBool(String name, boolean defaultValue);
    public int getInt(String name, int defaultValue);
    public float getFloat(String name, float defaultValue);

    public void registerOnConnectedListener(IOnSettingChanged onSettingChanged);
    public void removeOnConnectedListener(IOnSettingChanged onSettingChanged);
}
