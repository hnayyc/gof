package com.hnayyc.gof.adapter.me;

public class AdapterByInherit extends PowerSocket implements UsbInterface {

    @Override
    public void powerCharge() {
        System.out.println("通过继承方式创建适配器");
        this.charge();
    }
}
