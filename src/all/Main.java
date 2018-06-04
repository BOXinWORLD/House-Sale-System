package all;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class Main {
	public static void main(String[] args)  {
		EventQueue.invokeLater(
				new Runnable(){
					public void run(){
						try {
					    JFrame loginframe=new Login();
						loginframe.setVisible(true);
						loginframe.setLocationRelativeTo(null);
							
					    }
					    catch(Exception e){
					    e.printStackTrace();
					    }	
				    }
			    }
			);
			
			
	}



}
