package miscUIs;

import javax.swing.*;

public class optionP extends JFrame {
	public optionP(){
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setUP(){
		//JOptionPane jop=new JOptionPane();
		//JOptionPane.showMessageDialog(this,"This is a game");
		int opt =JOptionPane.showOptionDialog(this,"Save to DefDir","Save", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,  null, 
				new  Object[]{"sdf","sdfffff","ssssqqweer"}, "sdf");
		//jop.setVisible(true);
		System.out.println(opt);
	}
}
