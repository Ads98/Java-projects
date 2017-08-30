import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements ActionListener
{
	JFrame guiFrame = new JFrame();
	ColorLabel[] ArrayLables = new ColorLabel[64];
	Random rand = new Random();
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Main gui = new Main();
		gui.createGUI();
	}
	public void createGUI()
	{
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setTitle("Label demo");
		
		JPanel panel1= new JPanel();
		JPanel panel2= new JPanel();
		guiFrame.setLayout(new BorderLayout(2,2));
		panel1.setLayout(new GridLayout(8,8));
		panel2.setLayout(new BorderLayout(2,2));
		guiFrame.add(panel2, BorderLayout.NORTH);

		for(int i=0;i<64;i++)
		{
			Color c= new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)); 
			ArrayLables[i]= new ColorLabel(30,30,c);
			guiFrame.add(panel1, BorderLayout.NORTH);
			panel1.add(ArrayLables[i]);
		}
		JButton button1 = new JButton("Press me to refresh labels");
		button1.addActionListener(this); 
		guiFrame.add(button1, BorderLayout.SOUTH);
		guiFrame.pack();
		guiFrame.setVisible(true);

		
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
	// TODO Auto-generated method stub
		int x;
		for(x=0;x<ArrayLables.length;x++)
		{
			Color c = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
			ArrayLables[x].setDrawColor(c);
		}
		guiFrame.repaint();
		
	}
}

