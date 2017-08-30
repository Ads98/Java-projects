//package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Random;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PSYADSTmain implements Iterable<ColorButton> 
   {
	   final static int WIDTH = 8;
	   final static int HEIGHT =8;
	   final static int COLOURS= 8;
	   final static int MAX_PER_COLOUR=8;
	   final static int but_size=100;
	   int board=MAX_PER_COLOUR *MAX_PER_COLOUR;
	   int GameState=1;
	   boolean match=false;
	   Color ColorPressed;
	   int numberPressed1,numberPressed2;
	   Color[] Colours = new Color[MAX_PER_COLOUR];
	   ColorButton[] ArrayButtons= new  ColorButton[board];
	   JFrame guiFrame = new JFrame();
	   Player p1;
	   Player p2;
	   Player currentPlayer; 
	   JLabel currentLabel;
	   JLabel P1Label;
	   JLabel P2Label;
	   Random rand = new Random();
	   int score_p1;
	   int score_p2;
	   
	   public static void main(String[] args)
	   {
			new PSYADSTmain().createGUI();
	   }
	   
	   
	   public void setColor()
	   {
			int n,index;
			Color currentC;
			index=0;
			for(int i=0; i<MAX_PER_COLOUR;i++)
			{
				  System.out.println("start seting");
				for(n=0;n<MAX_PER_COLOUR; n++)
				{
					index= rand.nextInt(board);
					currentC=ArrayButtons[index].getDisplay();
					if (currentC==null)
					{
						//ArrayButtons[index].setstate(2);
						ArrayButtons[index].setDisplay(Colours[i]);
					}
					else
					{
						n--;
					}
				}
					
			}
			  System.out.println("finish setting");
		}
	   
	   
	   public void generateColour()
	   {
		   boolean add=true;
		   for(int x=0; x<MAX_PER_COLOUR ; x++)
		   {
			   System.out.println("start generating");
			   Color c= new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
			   for (int num=0; num<=x; num++)
			   {
				   if (c==Colours[num])
				   {
					   add=false;
				   }
			   }
			   if (add == true)
			   {
				   Colours[x]= c;
			   }
	  
		   }
		   System.out.println("finish generating");
	   }
	   
	   public void createGUI()
		{ 
			guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			guiFrame.setLocationRelativeTo(null);
			guiFrame.setTitle("Matching pairs");
			int i=0;
			int x;
			JPanel panel1= new JPanel();
			JLabel label1 = new JLabel();
			JLabel label2 = new JLabel();
			P1Label=label1;
			P2Label=label2;
			guiFrame.setLayout(new BorderLayout(2,2));
			panel1.setLayout(new GridLayout(WIDTH,HEIGHT));
			Player Player1= new Player(0,1,true,label1);
			Player Player2= new Player(0,2,false,label2);
			p1= Player1;
			p2=Player2;
			currentPlayer=p1;
			P1Label.setOpaque(true);
			P2Label.setOpaque(true);
			P1Label.setFont(new Font("Ariel", Font.BOLD, 30));  
			P2Label.setFont(new Font("Ariel", Font.BOLD, 30)); 
			p1.setmessage (1);
			p2.setmessage ( 0);
			for(x=0;x<board;x++)
			{
				ArrayButtons[x]= new ColorButton(x, this , but_size,but_size);
			}
			generateColour();
			setColor();
			for(x=0;x<board;x++)
			{
					guiFrame.add(panel1, BorderLayout.NORTH);
					panel1.add(ArrayButtons[x]);
			}
			P1Label=p1.getMessage();
			P2Label=p2.getMessage();
			guiFrame.add(P1Label, BorderLayout.NORTH);
			guiFrame.add(P2Label, BorderLayout.SOUTH);
			guiFrame.add(panel1, BorderLayout.CENTER);
			guiFrame.pack();
			guiFrame.setVisible(true);

			
		}
	   
	   
	  public void switchTurn()
	  {
		 int play;
		 System.out.println("why???????");
		 currentPlayer.setselection(0);
  	  	 currentPlayer.setTurn(false);
  	  	 play=currentPlayer.getNumber();
  	  	currentLabel.setBackground(Color.red);
  	  	System.out.println("red");
  	  	System.out.println("play :"+play);
  		 if (play==1)
 	  		{	
  			 	currentPlayer=p2;
  			 	P1Label.setBackground(Color.red);
  			 	P2Label.setBackground(Color.green);
 	  		}
  		 else
  		 	{
 	  			currentPlayer=p1;
 	  			P2Label.setBackground(Color.red);
 	  			P1Label.setBackground(Color.green);
  		 	}
  		currentPlayer.setTurn(true);
	  }
	  
	  public boolean testSame(ColorButton button, int ButtonNO)
	  {
		  int pressed;
		  pressed=button.getButtonNo();
		  if (pressed!=ButtonNO)
		  {
			  return true;
		  }
		  return false;
	  }
	  
	  public boolean testMatch(int pressed1, int pressed2)
	  {
		Color currentColor, prevColor;
		currentColor= ArrayButtons[pressed1].getDisplay();
		prevColor=ArrayButtons[pressed2].getDisplay();
		if (prevColor==currentColor)
		{
			return true;
		}
		else
		return false;
	  }
	  
	  
	  public boolean testboard()
	  {
		  for(int i=0;i<ArrayButtons.length;i++)
		  {
			  if (ArrayButtons[i].getState() !=3)
			  {
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  public void resetBoard()
	  {
		  System.out.println("start reset");
		  for(ColorButton b: ArrayButtons)
		  {
			  System.out.println("this is your fault mark!!!!!!");
			  b.flip(false);
			  b.setDisplay(null);
		  }
		  generateColour();
		  setColor();
		  p1.resetScore(0);
		  p2.resetScore(0);
		  p1.setTurn(true);
		  p2.setTurn(false);
		  p1.setmessage(1);
		  p2.setmessage(0);
		  P1Label=p1.getMessage();
		  P2Label=p2.getMessage();
		  System.out.println("reseting");
		 
			  
	  }
	  
	  public String endOfGame()
	  {
		  int score1, score2;
		  score1=p1.getScore();
		  score2=p2.getScore();
		  if (score1>score2)
		  {
			  return "Player 1 wins!!!";
		  }
		  if (score1<score2)
		  {
			  return("player 2 wins!!!!");
		  }
		  else
		  {
			  return "draw!!!";
		  }
		  
		  
	  }
	  
	  
	  public void setLabel()
	  {
		  if (currentPlayer.getNumber()==1)
			{
			  currentLabel=P1Label;
			}
		else
			currentLabel=P2Label;
	  }
	  
	  public void setgray(int button1, int button2)
	  {
		  ArrayButtons[button1].flip(false);
		  ArrayButtons[button2].flip(false);
	  }

	  public void buttonClicked( int iButton )
      {
    	  int state ; 
    	  String text;
    	  System.out.println("i button: "+ iButton);
    	  setLabel();
    	  state=ArrayButtons[iButton].getState();
    	  System.out.println("state: "+ GameState);
    	  
    		switch (GameState)
		{
    			case 1:
    				if (state!=3 && state!=2 )
    				{
    					setLabel();
    					currentPlayer.setmessage(2);
    					currentLabel=currentPlayer.getMessage();
    					ArrayButtons[iButton].flip(true);
    					System.out.println("pressed 1");
    					numberPressed1=iButton;
    					GameState++;
    				}
    					break;
    	  	case 2:
    	  		if (state!=3 && state!=2 )
    	  		{
    	  			numberPressed2=iButton;
    	  			ArrayButtons[iButton].flip(true);
    	  			System.out.println("pressed2");
    	  			match=testMatch(numberPressed1,numberPressed2);
    	  			if (match==true)
    	  			{
    	  				currentPlayer.setScore(2);
    	  				currentPlayer.setmessage(3);
    	  				System.out.println("\n step 2");
    	  				currentPlayer.setselection(0);
    	  				if (currentPlayer.getNumber()==1)
    	  				{
    	  					P1Label=currentPlayer.getMessage();
    	  				
    	  				}
    	  				else
    	  					P2Label=currentPlayer.getMessage();
    	  			
    	  			
    	  			}
    	  			else
    	  			{
    	  				currentPlayer.setmessage(4);
    	  				if (currentPlayer.getNumber()==1)
    	  				{
    	  					P1Label=currentPlayer.getMessage();
    	  				
    	  				}
    	  				else
    	  					P2Label=currentPlayer.getMessage();
    	  			}
    	  			GameState++;
    	  		}
			break;
		case 3:
			if (match)
			{
				ArrayButtons[numberPressed1].remove();
	  			ArrayButtons[numberPressed2].remove();
			}
			else
			{
				setgray(numberPressed1,numberPressed2);
				currentPlayer.setmessage(0);
				currentLabel=currentPlayer.getMessage();
		//		currentLabel.setBackground(Color.red);
				switchTurn();
				setLabel();
				currentPlayer.setmessage(1);
		    	currentLabel=currentPlayer.getMessage();
			}
		
    	  		
			currentLabel=currentPlayer.getMessage();
    	      	  	
			
			
		GameState=1;
			
			break;
    	  	
	  	  	
   	  	}
    		
    		if (testboard()==false)
  			{
  				text=endOfGame();
  				JOptionPane.showMessageDialog(guiFrame, text);
  				System.out.println("hello adam");
  				resetBoard();
  			}
    	  	
    }

class MyIterator implements Iterator<ColorButton>
{
	int index=0;
	
	@Override
	public boolean hasNext()
	{
		return index< ArrayButtons.length;
	}
	@Override
	public ColorButton next()
	{
		return ArrayButtons[index++];
	}
	
}
	@Override
	public Iterator<ColorButton> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}
   }
  
      
   