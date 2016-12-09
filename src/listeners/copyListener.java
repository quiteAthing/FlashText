package listeners;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import FlashTextUI.mainEditorWindow;

public class copyListener extends textEditListener {
	String id="Copy Listener   ";
	public	copyListener(mainEditorWindow mew){
		super(mew);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		copyToBoard();
		try {
			Object obj=postIt.getData(DataFlavor.stringFlavor);
			System.out.println(id+(String)obj);
		} catch (UnsupportedFlavorException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void copyToBoard(){
		StringSelection selected=new StringSelection(editArea.getSelectedText());		
		postIt.setContents(selected,null);
	}

}
