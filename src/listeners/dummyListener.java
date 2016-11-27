package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dummyListener implements ActionListener {
//填充空白用的Listener，沒有任何實際用途
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
