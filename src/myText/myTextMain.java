package myText;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import FlashTextUI.mainEditorWindow;

public class myTextMain {
	static{
		initFromFile();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//自製文字編輯器的起始檔案
		//宣告主視窗物件並初始化之

		mainEditorWindow mew=new mainEditorWindow();
		mew.setFactors(6, 6, 12f, 40);
		mew.setEditorFontSize(20f);
		mew.setVisible(true);
		
	}
	
	
	//嘗試從檔案中載入設定值以作為初始化
	public static void initFromFile(){
		System.out.println("from file");
		File ini=new File("FlashText.ini");
		try(FileInputStream fis=new FileInputStream(ini)	
				)
		{
			//因為ini檔的內容不多所以直接一次載完，基本上也不會跳出Long的範圍所以接cast成int來用
			char[] i=new char[(int)ini.length()-1];
			for(int j=0;j<i.length;j++){
				i[j]='X';
			}
			InputStreamReader isr=new InputStreamReader(fis,Charset.forName("utf-8"));
			isr.read(i);
			
			for(int k=0;k<i.length;k++){
				
				System.out.println(i[k]);
			}
			
		}
		catch(Exception e){
			
		}
	}

}
