package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import FlashTextUI.mainEditorWindow;
import myText.myTextMain;

public class openListener implements ActionListener {
	mainEditorWindow meow;
	JFileChooser jfc;
	public openListener(mainEditorWindow MEW){
		meow=MEW;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jfc=new JFileChooser();
		jfc.setDialogTitle("Open a File");
		jfc.showOpenDialog(null);
		myTextMain.inputContent(meow, jfc.getSelectedFile());

	}

}
