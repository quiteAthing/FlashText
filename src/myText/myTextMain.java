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
		//�ۻs��r�s�边���_�l�ɮ�
		//�ŧi�D��������ê�l�Ƥ�
		mainEditorWindow mew=new mainEditorWindow();
		mew.setFactors(6, 6, 12f, 40);
		mew.setEditorFontSize(20f);
		mew.setVisible(true);
		
	}
	
	
	//���ձq�ɮפ����J�]�w�ȥH�@����l��
	public static void initFromFile(){
		System.out.println("from file");
		File ini=new File("FlashText.ini");
		try(FileInputStream fis=new FileInputStream(ini)	
				)
		{
			//�]��ini�ɪ����e���h�ҥH�����@�������A�򥻤W�]���|���XLong���d��ҥH��cast��int�ӥ�
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
