package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import FlashTextUI.mainEditorWindow;
import myText.myTextMain;

public class saveListener implements ActionListener {
	public static final int SAVE=0;
	public static final int SAVE_AS=1;
	public static final int SAVE_AND_QUIT=2;
	int saveType;
	mainEditorWindow meow;
	static String msg="這個檔案沒有預設的存檔路徑，存到軟體預設路徑? \n 預設存檔路徑可於FlashText.ini中修改  ";
	static String dialogTitle="存到預設路徑?";
	boolean isSaveAs=false;//false　：不是存到新檔案　　true :存到新檔案
	public saveListener(mainEditorWindow MEW){
		meow=MEW;
		saveType=saveListener.SAVE;
		
	}
	
	public saveListener(mainEditorWindow MEW, int SaveType){
		meow=MEW;
		saveType=SaveType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch(saveType){
		case saveListener.SAVE:if(meow.getDIR()==null){saveToDir(meow);}
								else{//已有檔案的狀況直接儲存
									myTextMain.saveToFile(meow.getDIR(),meow.getPage().getText());}
								break;
		case saveListener.SAVE_AS:saveAs(meow);break;
		case saveListener.SAVE_AND_QUIT:saveAs(meow);
										justQuit(meow);
										break;
		default:break;
		}
		
		 
	}

	
	protected static void saveToDir(mainEditorWindow mew){
		//詢問使用者是否需要將檔案存盪預設路徑或是設定路徑。
		
			int opt=JOptionPane.showOptionDialog(mew,msg, dialogTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, new String[]{" 是(存到預設路徑)","取消動作 ","否(自行設定存檔路徑)" }
			, " 是(存到預設路徑)");
			switch(opt){
					case 0:myTextMain.saveToFile(myTextMain.DefaultFile,mew.getPage().getText());
							System.out.println("存到預設路徑");
							break;
					case 1:	System.out.println("Oeration cancelled");break;
							
					case 2:myTextMain.saveToFile(mew.getDIR(),mew.getPage().getText());
							System.out.println("自行設定存檔路徑");
							break;
					default :System.out.println("Oeration cancelled 2");break;//若動作被意外取消時會執行此行
			}
		
			
			
		
	
}
	
	protected static void saveAs(mainEditorWindow mew){
		System.out.println("Save As");
		//放棄，改用JFileChooser
		//這邊的東西可以改到myTextMain裡面當公用方法.....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		JFileChooser jfc=new JFileChooser(myTextMain.DefaultFile.getAbsolutePath());
		FileNameExtensionFilter ffef=new FileNameExtensionFilter("Text File","txt");
		jfc.setFileFilter(ffef);
		jfc.showSaveDialog(mew);
		File saveTo=jfc.getSelectedFile();
		myTextMain.saveToFile(saveTo,mew.getPage().getText());
		mew.setDir(saveTo);
	}
	
	protected static void  justQuit(mainEditorWindow mew){
		mew.setVisible(false);
		mew.dispose();
	}
	

	

}
