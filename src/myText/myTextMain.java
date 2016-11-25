package myText;

import FlashTextUI.mainEditorWindow;

public class myTextMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//自製文字編輯器的起始檔案
		mainEditorWindow mew=new mainEditorWindow();
		mew.setFactors(6, 6, 12f, 40);
		mew.setEditorFontSize(20f);
		mew.setVisible(true);
		
	}

}
