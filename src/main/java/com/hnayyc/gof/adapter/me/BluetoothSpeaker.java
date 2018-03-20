package com.hnayyc.gof.adapter.me;

public class BluetoothSpeaker {

    // 蓝牙音箱通过USB接口充电
    private UsbInterface usb;

    public BluetoothSpeaker(UsbInterface usbIfc) {
        this.usb = usbIfc;
    }

    public void usbCharge() {
        usb.powerCharge();
    }
}
