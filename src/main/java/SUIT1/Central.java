package SUIT1;

public class Central {
private static Sensortestin sensortestin;
private static int SENSOR_BAUDRATE = 9600;
    public static void main(String[] args) {
        sensortestin = new Sensortestin(SENSOR_BAUDRATE);

    }

}
