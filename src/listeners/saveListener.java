package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import FlashTextUI.mainEditorWindow;
import myText.myTextMain;

public class saveListener implements ActionListener {
	mainEditorWindow meow;
	public saveListener(mainEditorWindow MEW){
		meow=MEW;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("lines");
		if(meow.getDIR()==null){
			System.out.println("詢問是否存到預設目錄，這邊偷懶暫時還沒弄~");
			myTextMain.saveToFile(myTextMain.DefaultFile,meow.getPage().getText());
		}else{
			myTextMain.saveToFile(meow.getDIR(),meow.getPage().getText());
			
		}
		System.out.println("completed"); 
	}
	

}
