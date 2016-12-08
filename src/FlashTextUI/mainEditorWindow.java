package FlashTextUI;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import listeners.NewListener;
import listeners.copyListener;
import listeners.dummyListener;
import listeners.openListener;
import listeners.quitListener;
import listeners.saveListener;
import myText.myTextMain;



public class mainEditorWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private int edited=3;//本數值為0時表示文件沒有被編輯過，不為0時表示有編輯過。
	public String Title="Flash Text";
	Dimension mdi;
	JMenuBar jmb=new JMenuBar();
	JTextArea jta=new JTextArea();
	JScrollPane jscrp=new JScrollPane(jta);
	Map<String,JMenuItem> menuItems=new LinkedHashMap<>();
	Map<String,JMenu> menus=new LinkedHashMap<>();
	String[] loadMenuSequence={"File","Edit","Tools"}; 
	String[] FileMenuSequence={"New","Open","Save","Save_As","Save and QUIT","Discard and Quit","Quit"};
	String[] EditMenuSequence={"Copy","Cut","Paste","Font","Environment"};
	String[] ToolsMenuSequence={"HighLighter","HookCompiler","Plugin","Contact","About"};
	Map<String,ActionListener> fileItem=new HashMap<>();
	Map<String,ActionListener> editItem=new HashMap<>();
	Map<String,ActionListener> toolsItem=new HashMap<>();
	private float editorFontSize;
	private File dir;
	
	
	public mainEditorWindow(){
		super();
		fileItem.put(FileMenuSequence[0],new NewListener(this));
		fileItem.put(FileMenuSequence[1],new openListener(this));
		fileItem.put(FileMenuSequence[2],new saveListener(this));
		fileItem.put(FileMenuSequence[3],new saveListener(this,saveListener.SAVE_AS));
		fileItem.put(FileMenuSequence[4],new saveListener(this,saveListener.SAVE_AND_QUIT));
		fileItem.put(FileMenuSequence[5],new quitListener(this,quitListener.DISCARD_AND_QUIT));
		fileItem.put(FileMenuSequence[6],new quitListener(this,quitListener.QUIT));
		
		editItem.put(EditMenuSequence[0],new copyListener());
		editItem.put(EditMenuSequence[1],new dummyListener());
		editItem.put(EditMenuSequence[2],new dummyListener());
		editItem.put(EditMenuSequence[3],new dummyListener());
		editItem.put(EditMenuSequence[4],new dummyListener());
		
		//以下設定為進階內容，不在這一段的階段性目標
		toolsItem.put(ToolsMenuSequence[0],new dummyListener());
		toolsItem.put(ToolsMenuSequence[1],new dummyListener());
		toolsItem.put(ToolsMenuSequence[2],new dummyListener());
		toolsItem.put(ToolsMenuSequence[3],new dummyListener());
		toolsItem.put(ToolsMenuSequence[4],new dummyListener());
		addWindowListener(new ftWindowListener(this));
		
		
	}
	

	public void setFactors(int factorX,int factorY, float DefaultFontSize,int menuBarHeight){		
		setPreferredSize(new Dimension((int)Math.round(myTextMain.sysDim.getWidth()/factorX*3),(int)Math.round(myTextMain.sysDim.getHeight()/factorY*3)));
		setTitle(Title);
		jmb.setPreferredSize(new Dimension((int)myTextMain.sysDim.getWidth(),menuBarHeight));
		jta.setFont(jta.getFont().deriveFont(DefaultFontSize));
		
		for(String ir :loadMenuSequence){
			menus.put(ir,new JMenu(ir));
			
		}
			JMenu tmp=menus.get("File");
		for(int j=0;j<FileMenuSequence.length;j++){
			JMenuItem ttp=new JMenuItem(FileMenuSequence[j]);
			ttp.addActionListener(fileItem.get(FileMenuSequence[j]));
			tmp.add(ttp);
			tmp.setMinimumSize(new Dimension(60,10));
			tmp.setFont(tmp.getFont().deriveFont(DefaultFontSize));
		}	
			tmp=menus.get("Edit");
		for(int j=0;j<EditMenuSequence.length;j++){
			JMenuItem ttp=new JMenuItem(EditMenuSequence[j]);
			if(editItem.get(EditMenuSequence[j]) instanceof dummyListener){
				ttp.setEnabled(false);
			}
			ttp.addActionListener(editItem.get(EditMenuSequence[j]));
			tmp.add(ttp);
			tmp.setMinimumSize(new Dimension(60,10));
			tmp.setFont(tmp.getFont().deriveFont(DefaultFontSize));
			
		}
		
			tmp=menus.get("Tools");
		for(int j=0;j<ToolsMenuSequence.length;j++){
			JMenuItem ttp=new JMenuItem(ToolsMenuSequence[j]);
			if(toolsItem.get(ToolsMenuSequence[j]) instanceof dummyListener){
				ttp.setEnabled(false);
			}
			ttp.addActionListener(toolsItem.get(ToolsMenuSequence[j]));
			tmp.add(ttp);
			tmp.setMinimumSize(new Dimension(60,10));
			tmp.setFont(tmp.getFont().deriveFont(DefaultFontSize));
		}
		
		for(String s :menus.keySet()){
			jmb.add(menus.get(s));	
		}
		
		setJMenuBar(jmb);
		add(jscrp);
		pack();
		
		
		
		
	}
	
	
	
	
	public void setEditorFontSize(float FontSize){
		editorFontSize=FontSize;
		jta.setFont(getJMenuBar().getFont().deriveFont(editorFontSize));
		
	}
	
	//結束這個編輯器並釋放資源。
	public void terminate(){
		this.dispose();
	}
	
	
	//傳回這個視窗所開啟的檔案的預設路徑，若是新檔案會是null。
	public File getDIR(){
		return dir;
	}
	
	//從main接收開啟的檔案內容路徑。
	public void setDir(File src){
		dir=src;
	}
	
	//提供內容給main裡的outputstream寫出。
	public JTextArea getPage(){
		return jta;
	}
	
	//開啟檔案時用來設定編輯器視窗內容
	public void takeINcontent(String content){
		jta.setText(content);
	}
	
	//取得這個檔案是否有被編輯過的紀錄。
	public int getEditStatus(){
		return edited;
	}
	
	
	

}
