package com.hnayyc.gof.adapter.me;

public class Test {

    public static void main(String[] args) {
        PowerSocket ps = new PowerSocket();
        UsbInterface usb = new AdapterByCombination(ps);
        BluetoothSpeaker bs = new BluetoothSpeaker(usb);
        bs.usbCharge();

        usb = new AdapterByInherit();
        bs = new BluetoothSpeaker(usb);
        bs.usbCharge();
    }
}
