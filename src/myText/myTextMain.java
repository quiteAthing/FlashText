package myText;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import FlashTextUI.mainEditorWindow;
import fTextArea.fTextArea;

public class myTextMain {
	public static int workingWindow =0;
	public static File DefaultFile;
	public static Dimension sysDim;
	static{
		//從檔案中讀取設定值
		initFromFile();
		sysDim=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		//自製文字編輯器的起始檔案
		createNew();
		fTextArea j=new fTextArea();
	}
	
	public static void createNew(){
		//宣告主視窗物件並初始化之
		workingWindow+=1;
		mainEditorWindow mew=new mainEditorWindow();
		mew.setFactors(6, 6, 12f, 40);
		mew.setEditorFontSize(20f);
		mew.setVisible(true);		
	}
	
	//意義跟名稱已經不符合，需要重新命名
	public static void terminateCurrent(mainEditorWindow meww){
		meww.terminate();
		workingWindow-=1;
		if(workingWindow==0){
			System.exit(0);
		}
		
	}
	
	
	//從檔案中載入設定值以作為初始化，由靜態區塊呼叫，現在裏頭除了println以外沒有其他東西
	public static void initFromFile(){
		File ini=new File("FlashText.ini");
		try(FileInputStream fis=new FileInputStream(ini)	
				)
		{
			//因為ini檔的內容不多所以直接一次載完，基本上也不會跳出Long的範圍所以接cast成int來用
			char[] i=new char[(int)ini.length()];
			InputStreamReader isr=new InputStreamReader(fis,Charset.forName("utf-8"));
			isr.read(i);
			
			
			//String intro=String.copyValueOf(i);
			//System.out.println("io :"+intro);

			
		}
		catch(Exception e){	}
		DefaultFile=new File("D:\\playground\\FailedToCreateFile.txt");
	}
	
	
	
	//儲存檔案的公用方法
	public static void saveToFile(File saveTo, String DataToSave){
		try( BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saveTo),Charset.forName("utf-8")),8192);)
			{
				bfw.write(DataToSave);
			
			}catch(Exception e){}
		
	}
	
	public static void inputContent(mainEditorWindow MEW,File got){
		try(
		BufferedReader bbr=new BufferedReader(new InputStreamReader(new FileInputStream(got),Charset.forName("utf-8")));)
		{
			char[] ch=new char[(int)got.length()];
			bbr.read(ch);
			MEW.setDir(got);
			MEW.takeINcontent(String.valueOf(ch));
		}catch(Exception e){
			System.out.println("這邊可以彈視窗出來");
			e.printStackTrace();
		}
			
	}
	
	
}


