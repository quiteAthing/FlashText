package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import myText.myTextMain;

public class NewListener  implements  ActionListener{
	JFrame Current;
	public NewListener( JFrame current){
		Current=current;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//呼叫靜態方法來關閉並開啟新視窗
		myTextMain.createNew();
		
	}
	

}
