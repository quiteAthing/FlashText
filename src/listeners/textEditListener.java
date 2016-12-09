package listeners;

import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import FlashTextUI.mainEditorWindow;

public abstract class textEditListener implements ActionListener {
	
	JTextArea editArea;
	Clipboard postIt;
	String identifier="textEditListener Listener   ";
	public textEditListener(){};
	
	public	textEditListener(mainEditorWindow mew){
		editArea=mew.getPage();
		postIt=java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
