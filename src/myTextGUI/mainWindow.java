package myTextGUI;

import javax.swing.*;
import java.awt.*;
//這個類別的內容已被 mainWindow.java 取代
public class mainWindow {
	int factorX,factorY;
	javax.swing.JFrame jf;
	JMenu[] menus={ new JMenu(),new JMenu(),new JMenu()};
	public mainWindow(int scaleX,int scaleY){
		factorX=scaleX;
		factorY=scaleY;
	}
	
	public void setUP(){
		jf=new JFrame();
		Dimension dr=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension basic= new Dimension(dr.width/factorX*factorY,dr.height/(factorX+1)*(factorY+1));
		JTextArea jt=new JTextArea();
		jt.setEditable(true);
		jt.setBackground(Color.green);
		jt.setText("Hello JAVA");
		JMenuItem open =new JMenuItem(" OPEN       ");
		JMenuItem save =new JMenuItem(" SAVE       ");
		JMenuBar jmb=new JMenuBar();
		menus[0].setText("File");
		menus[1].setText("Edit");
		menus[2].setText("Tools");
		menus[0].add(open);
		menus[0].add(save);
		jmb.setPreferredSize(new Dimension(basic.width,basic.height/20));
		
		for(JMenu j: menus){
			jmb.add(j);
		}
		jf.setPreferredSize(basic);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setJMenuBar(jmb);
		jf.getContentPane().add(jt);
		
		jf.pack();
		
		
		jf.setVisible(true);
		
	}
	public void showMainWindow(){
		
	}

}
