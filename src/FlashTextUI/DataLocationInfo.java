package FlashTextUI;

import java.io.File;
//本類別已被廢棄
public class DataLocationInfo {
	private File dFile;//default file的簡寫
	public DataLocationInfo(){
		//空建構子
	}
	
	public DataLocationInfo(File saveTo){
		dFile=saveTo;
	}
	
	public void setUdefineDIR(String DIR,String fName){
		
		dFile=new File(DIR+fName);
	}
	
	public File getFile(){
		return dFile;
	}
	
}
