package SUIT1;

import jssc.*;

import javax.swing.*;
import java.util.Arrays;

public class Sensortestin extends Thread {


    double value = 0;
    SerialPort serialPort = null;
    String[] portnames = SerialPortList.getPortNames();
    String buffer = "";
    String inputfraport = "";

    public Sensortestin() {

        //  JOptionPane.showMessageDialog(null,"Jeg kommer fra Github. har du sat en sensor i port \n"+ Arrays.toString(portnames));
        try {
            for (int i = 0; i < portnames.length; i++) {
                String port = portnames[i];
                serialPort = new SerialPort(port);
                System.out.println("navn:" + port);
            }
            serialPort = new SerialPort(portnames[0]);
            serialPort.openPort();
            serialPort.setRTS(true);
            serialPort.setDTR(true);

            serialPort.setParams(115200, 8, 1, SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            Thread.sleep(3000);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Sensortestin(int baudrate) {


        //  JOptionPane.showMessageDialog(null,"Jeg kommer fra Github. har du sat en sensor i port \n"+ Arrays.toString(portnames));
        try {
            for (int i = 0; i < portnames.length; i++) {
                String port = portnames[i];
                serialPort = new SerialPort(port);
                System.out.println("navn:" + port);
            }
            serialPort = new SerialPort(portnames[0]);
            serialPort.openPort();
            serialPort.setRTS(true);
            serialPort.setDTR(true);

            serialPort.setParams(baudrate, 8, 1, SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            Thread.sleep(3000);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    private String getTemperatur() {
        String output = "";
        while (true) {
            try {


                if (serialPort.getInputBufferBytesCount() > 0) {

                    output = serialPort.readString();
                    break;
                }
            } catch (SerialPortException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return output;
    }


    private String[] getData(String separator, String end) {
        String output[] = null;
        String result = null;
        try {


            if (serialPort.getInputBufferBytesCount() > 0) {

                result = serialPort.readString();
                String[] midlertidig = result.split(separator);

                String IR = midlertidig[0];
                String RED = midlertidig[1];
                System.out.println("Red");

            }
        } catch (SerialPortException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return output;
    }


}
