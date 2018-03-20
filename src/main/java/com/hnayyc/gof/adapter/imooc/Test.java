package com.hnayyc.gof.adapter.imooc;

public class Test {

    public static void main(String[] args) {
        GBTwoPlug two =  new GBTwoPlug();
        ThreePlugIf three = new TwoPlugAdapter(two);
        NoteBook nb = new NoteBook(three);
        nb.charge();

        System.out.println();

        three = new TwoPlugAdapterExtends();
        nb = new NoteBook(three);
        nb.charge();
    }
}
