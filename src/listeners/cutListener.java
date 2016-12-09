package listeners;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import FlashTextUI.mainEditorWindow;

public class cutListener extends copyListener {

	public cutListener(mainEditorWindow mew) {
		super(mew);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
			copyToBoard();
			editArea.cut();
		try {
			Object obj=postIt.getData(DataFlavor.stringFlavor);
			System.out.println("cut  "+(String)obj);
		} catch (UnsupportedFlavorException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	

}
