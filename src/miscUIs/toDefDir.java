package miscUIs;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import myText.myTextMain;

@SuppressWarnings("serial")
public class toDefDir extends JFrame {
	private String hint="本檔案沒有預設存檔位置，存到FlashText預設位置? \n (您可以在FlashText.ini 中的DefaultSaveDir設定預設位置)";
	private static int defFacX =10,defFacY =10;
	private JButton[] buttons=new JButton[2];
	public toDefDir(){
		//空建構子
		setFactors(defFacX,defFacY);
	}
	
	
	public toDefDir(String qos,int factorX,int factorY){
		hint=qos;
		setFactors(factorX,factorY);
	}
	
	public toDefDir(int factorX,int factorY){
		
		setFactors(factorX,factorY);
	}
	
	
	//設定數值同時初始化物件
	public void setFactors(int factorX,int factorY){
		setPreferredSize(new Dimension((int)myTextMain.sysDim.width/factorX*3,(int)myTextMain.sysDim.height/factorY*3));
		
		buttons[0]=new JButton("是");
		buttons[0].addActionListener(new yesListener());
		buttons[0].setSize(new Dimension (100,50));
		buttons[0].setVisible(true);
		
		
		buttons[1]=new JButton("否");		
		buttons[1].addActionListener(new noListener());
		buttons[1].setSize(new Dimension (100, 50));
		buttons[1].setVisible(true);
		
		
		pack();
		
		
	}
	
	//傳送一個boolean回去給saveLisenter做判斷
	//由saveListener呼叫
	public boolean getUserRespond(){
		boolean respond=false;
		 setVisible(true);
		 
		
		
		return respond;
	}
	
	class yesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	class noListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	

}
