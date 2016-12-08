package myText;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.swing.UIManager;

import FlashTextUI.mainEditorWindow;

public class myTextMain {
	public static int workingWindow =0;
	public static File DefaultFile;//Default file在Main中設定，來自FlashText.ini
	public static Dimension sysDim;
	public static Map<String,String> setts;
	public static final String DefaultSaveLocation="DefaultSaveLocation";//用來從MAP中抓取DefaultSaveLocation的key。
	static{
		initFromFile();
		
		sysDim=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static void main(String[] args) {
	
		//自製文字編輯器的起始檔案
		DefaultFile=new File(setts.get(DefaultSaveLocation));
		
		//讓FlashText套用作業系統預設的外觀，比Java的好看不少...
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		createNew();
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
		//注意BOM的存在可能性，可能需要增加判斷BOM是否存在的內容\
		File ini=new File("FlashText.ini");
		
		setts =new HashMap<String,String>();
		try(
				BufferedReader bfr=new BufferedReader(new InputStreamReader(new FileInputStream(ini),Charset.forName("utf-8")));
				)
		{
			//因為ini檔的內容不多所以直接一次載完，基本上也不會跳出Long的範圍所以接cast成int來用
			
			String init="";
			
			while(init!=null){
				init=bfr.readLine();
				String[] in=init.split("=");
				setts.put(in[0], in[1]);
				

			}
			
		}
		
		catch(Exception e){	
		
		}
				
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


