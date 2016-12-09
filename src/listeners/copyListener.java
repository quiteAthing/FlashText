package listeners;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

import FlashTextUI.mainEditorWindow;

public class copyListener implements ActionListener {
	JTextArea editArea;
	Clipboard postIt;
	public	copyListener(mainEditorWindow mew){
		editArea=mew.getPage();
		postIt=java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		StringSelection selected=new StringSelection(editArea.getSelectedText());
		postIt.setContents(selected,null);
		try {
			Object obj=postIt.getData(DataFlavor.stringFlavor);
			System.out.println((String)obj);
		} catch (UnsupportedFlavorException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
