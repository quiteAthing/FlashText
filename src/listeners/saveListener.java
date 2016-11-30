package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import FlashTextUI.DataLocationInfo;
import myText.myTextMain;

public class saveListener implements ActionListener {
	JTextArea jta;
	DataLocationInfo dInfo;
	public saveListener(JTextArea editingField){
		jta=editingField;
		dInfo=myTextMain.getDefaultDIR();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("lines");
		myTextMain.saveToFile(dInfo.getFile(), jta.getText());
		System.out.println("completed"); 
	}

}
