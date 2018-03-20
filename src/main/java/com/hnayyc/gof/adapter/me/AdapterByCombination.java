package com.hnayyc.gof.adapter.me;

public class AdapterByCombination implements UsbInterface {

    private PowerSocket powerSocket;

    public AdapterByCombination(PowerSocket ps) {
        this.powerSocket = ps;
    }

    @Override
    public void powerCharge() {
        System.out.println("通过组合方式创建适配器");
        this.powerSocket.charge();
    }
}
