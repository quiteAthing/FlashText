package myTextGUI;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;



public class windowTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame win=new JFrame();
		JButton Yes=new JButton("Yes");
		JButton No=new JButton("No");
		JButton stufA=new JButton("stuff");
		//win.setPreferredSize(new Dimension(480,220));
		GroupLayout gl=new GroupLayout(win.getContentPane());
		win.setLayout(gl);
		GroupLayout.SequentialGroup gsg=gl.createSequentialGroup();
		GroupLayout.ParallelGroup gsgp=gl.createParallelGroup(Alignment.BASELINE);
		GroupLayout.SequentialGroup gsga=gl.createSequentialGroup();
		gsgp.addComponent(Yes, Alignment.CENTER);
		gsgp.addComponent(No, Alignment.CENTER);
		gsgp.addComponent(stufA, Alignment.CENTER);
		gsg.addContainerGap();
		gsg.addComponent(Yes);
		gsg.addGap(10);
		gsg.addComponent(No);
		gsg.addGap(10);
		gsg.addComponent(stufA);
		gsg.addContainerGap();
		gsga.addGroup(gsgp);
		gl.setHorizontalGroup(gsg);
		gl.setVerticalGroup(gsga);
		win.pack();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		
		
	}

}
