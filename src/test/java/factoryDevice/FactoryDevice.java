package factoryDevice;

public class FactoryDevice {

    public enum DeviceType{
        ANDROID,
        IOS,
        CLOUD
    }

    public static IDevice make(DeviceType type){
        IDevice device;

        switch (type){
            case ANDROID:
                device= new Android();
                break;
            case CLOUD:
                device= new BrowserStack();
                break;
            default:
                device= new IOS();
                break;
        }
        return device;
    }

}
