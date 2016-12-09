package listeners;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

import FlashTextUI.mainEditorWindow;

public class pasteListener extends textEditListener {

	public pasteListener(mainEditorWindow mew){
		super(mew);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object fromClipBoard=new Object();
		try {
			fromClipBoard = postIt.getData(DataFlavor.stringFlavor);
			editArea.append((String)fromClipBoard);
		} catch (UnsupportedFlavorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	

	}

}
