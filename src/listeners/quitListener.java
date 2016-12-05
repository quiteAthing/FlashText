package listeners;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import FlashTextUI.mainEditorWindow;
import myText.myTextMain;

public class quitListener extends saveListener {
	public static final int DISCARD_AND_QUIT=3;
	public static final int QUIT=4;
	private int quitType;

	public quitListener(mainEditorWindow MEW, int QuitType) {
		super(MEW);
		quitType=QuitType;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		switch(quitType){
		case DISCARD_AND_QUIT:justQuit(meow);break;
		case QUIT:
				if(meow.getEditStatus()==0){justQuit(meow);}//如果有編輯過，詢問是否要存檔，沒有編輯過則直接結束
				else{askToSave(meow); }
				break;
		default:break;
		}
		
	}
	

	
	public static void askToSave(mainEditorWindow mew){
		int opt;
		opt=JOptionPane.showOptionDialog(mew, "您有未儲存的變更，是否儲存變更?","未儲存的變更",JOptionPane.DEFAULT_OPTION
				,JOptionPane.PLAIN_MESSAGE,null,
				new String[]{"是","否"}, "是");
		switch(opt){
			case 0:
				if(mew.getDIR()==null){saveToDir(mew);}
				else{myTextMain.saveToFile(mew.getDIR(),mew.getPage().getText());
				justQuit(mew);
				}
				break;
			case 1:justQuit(mew);break;
			default: justQuit(mew);//這邊最好彈個警告出來
		}
		
		
	}
	
	

}
