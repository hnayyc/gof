package com.hnayyc.gof.adapter.imooc;

/**
 * 笔记本需要用三孔插座充电，目前只有墙上的一个二孔插座可用，需要使用适配器。
 * 笔记本的三孔插头 -----> 适配器 -----> 墙上的二孔插座
 */
public class NoteBook {

	private ThreePlugIf  plug;
	
	public NoteBook(ThreePlugIf plug){
		this.plug = plug;
	}
	
	//使用插座充电
	public void charge(){
		plug.powerWithThree();
	}
}
