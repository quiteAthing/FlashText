package FlashTextUI;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import listeners.dummyListener;


public class mainEditorWindow extends JFrame{

	
	private static final long serialVersionUID = 1L;
	public String Title="Flash Text";
	Dimension mdi;
	JMenuBar jmb=new JMenuBar();
	JTextArea jta=new JTextArea();
	Map<String,JMenuItem> menuItems=new LinkedHashMap<>();
	Map<String,JMenu> menus=new LinkedHashMap<>();
	String[] loadMenuSequence={"File","Edit","Tools"}; //主選單的內容物
	String[] FileMenuSequence={"New","Open","Save","Save_As","Save and QUIT","Discard and Quit","Quit"};//檔案選單的內容物
	String[] EditMenuSequence={"Copy","Cut","Paste","Font","Environment"};//編輯選單的內容物
	String[] ToolsMenuSequence={"HighLighter","HookCompiler","Plugin","Contact","About"};//工具選單的內容物
	Map<String,ActionListener> fileItem=new HashMap<>();
	Map<String,ActionListener> editItem=new HashMap<>();
	Map<String,ActionListener> toolsItem=new HashMap<>();
	
	private float editorFontSize;
	public mainEditorWindow(){
		super();
		fileItem.put(FileMenuSequence[0],new dummyListener());
		fileItem.put(FileMenuSequence[1],new dummyListener());
		fileItem.put(FileMenuSequence[2],new dummyListener());
		fileItem.put(FileMenuSequence[3],new dummyListener());
		fileItem.put(FileMenuSequence[4],new dummyListener());
		fileItem.put(FileMenuSequence[5],new dummyListener());
		fileItem.put(FileMenuSequence[6],new dummyListener());
		
		editItem.put(EditMenuSequence[0],new dummyListener());
		editItem.put(EditMenuSequence[1],new dummyListener());
		editItem.put(EditMenuSequence[2],new dummyListener());
		editItem.put(EditMenuSequence[3],new dummyListener());
		editItem.put(EditMenuSequence[4],new dummyListener());
		
		toolsItem.put(ToolsMenuSequence[0],new dummyListener());
		toolsItem.put(ToolsMenuSequence[1],new dummyListener());
		toolsItem.put(ToolsMenuSequence[2],new dummyListener());
		toolsItem.put(ToolsMenuSequence[3],new dummyListener());
		toolsItem.put(ToolsMenuSequence[4],new dummyListener());
		
	}
	
	//設定視窗大小
	public void setFactors(int factorX,int factorY, float DefaultFontSize,int menuBarHeight){		
		Dimension sysDim=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)Math.round(sysDim.getWidth()/factorX*3),(int)Math.round(sysDim.getHeight()/factorY*3)));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Title);
		jmb.setPreferredSize(new Dimension((int)sysDim.getWidth(),menuBarHeight));
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
			ttp.addActionListener(editItem.get(EditMenuSequence[j]));
			tmp.add(ttp);
			tmp.setMinimumSize(new Dimension(60,10));
			tmp.setFont(tmp.getFont().deriveFont(DefaultFontSize));
			
		}
		
			tmp=menus.get("Tools");
		for(int j=0;j<ToolsMenuSequence.length;j++){
			JMenuItem ttp=new JMenuItem(ToolsMenuSequence[j]);
			ttp.addActionListener(toolsItem.get(ToolsMenuSequence[j]));
			tmp.add(ttp);
			tmp.setMinimumSize(new Dimension(60,10));
			tmp.setFont(tmp.getFont().deriveFont(DefaultFontSize));
		}
		
		for(String s :menus.keySet()){
			jmb.add(menus.get(s));	
		}
		
		setJMenuBar(jmb);
		add(jta);
		pack();
		
		
		
		
	}
	
	public void setEditorFontSize(float FontSize){
		editorFontSize=FontSize;
		jta.setFont(getJMenuBar().getFont().deriveFont(editorFontSize));
		
	}
	
	
	
	

}
