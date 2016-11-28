package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dummyListener implements ActionListener {
//這個類別是用來塞空白用的，基本上看到這個東西就等於那個東西還沒有被處理。
	static int listenerCounter;
	private int num=0;
	public dummyListener(){
		listenerCounter++;
		num=listenerCounter;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("dummylistener #  "+ num);
	}

}
