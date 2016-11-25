package FlashTextUI;

import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class mainEditorWindow extends JFrame{

	
	private static final long serialVersionUID = 1L;
	public String Title="Flash Text";
	Dimension mdi;
	JMenuBar jmb=new JMenuBar();
	JTextArea jta=new JTextArea();
	Map<String,JMenuItem> menuItems=new LinkedHashMap<>();
	Map<String,JMenu> menus=new LinkedHashMap<>();
	String[] loadMenuSequence={"File","Edit","Tools"}; //�D��檺���e��
	String[] FileMenuSequence={"New","Open","Save","Save_As","Save and QUIT","Discard and Quit","Quit"};//�ɮ׿�檺���e��
	String[] EditMenuSequence={"Copy","Cut","Paste","Font","Environment"};//�s���檺���e��
	String[] ToolsMenuSequence={"HighLighter","HookCompiler","Plugin","Contact","About"};//�u���檺���e��
	private float editorFontSize;
	public mainEditorWindow(){
		super();
	}
	
	//�]�w�����j�p
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
			tmp.add(new JMenuItem(FileMenuSequence[j]));
			tmp.setMinimumSize(new Dimension(60,10));
			tmp.setFont(tmp.getFont().deriveFont(DefaultFontSize));
		}
			tmp=menus.get("Edit");
		for(int j=0;j<EditMenuSequence.length;j++){
			tmp.add(new JMenuItem(EditMenuSequence[j]));
			tmp.setMinimumSize(new Dimension(60,10));
			tmp.setFont(tmp.getFont().deriveFont(DefaultFontSize));
			
		}
		
			tmp=menus.get("Tools");
		for(int j=0;j<ToolsMenuSequence.length;j++){
			tmp.add(new JMenuItem(ToolsMenuSequence[j]));
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