//package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Player {
	int score;
	int playNO;
	int selection;
	boolean turn;
	String message;
	JLabel desc; 
	
	public int getNO()
	{
		return playNO;
	}
	
	public JLabel getMessage()
	{
		return desc;
	}
	
	
	   public String getGoal (int task) 
	   {
		  switch(task)
		  {
		   case 0 :
			  return "Please wait for your turn";
		   
		   case 1 :
			   return "Pease select your first square";
		    
		   case 2:
			   return "Please select the next square!";
		   case 3 :
			   return "match!!! press any button to continue";
		   case 4 :
			   return "Incorrect match, press a square to end turn";
		   case 5 :
			   return "match!!, end of game";
		   case 6:
			   	return "press any square";
			    
		   }
		return null;
	   
	   }
	   public void setmessage (int goal)
	   { String message;
		 message= getGoal(goal);
		 desc.setText("player :" +  playNO + " "+ "score: " + score +  "-" + message);
		 if (turn==true)
   	     {
   	    	 desc.setBackground(Color.green);
   	     }
		 else
		 desc.setBackground(Color.red);
		
		   
	   }

	public int getSelection()
	{
		return selection;
	}
	
	public void resetScore(int intial)
	{
		score=intial;
	}
	
	
	
	
	public void setselection(int n)
	{
			   System.out.println("selection= "+n);
			   selection=n;
	}
	
	
	public int getScore()
	{
		return score;
	}
	
	
	
	
	public void setScore(int points)
	{
			   score=score+points;
	}
	
	
	public int getNumber()
	{
		return playNO;
	}
	
	public boolean getTurn()
	{
		return turn;
	}
	
	public void setTurn(boolean go)
	{
			   turn=go;
	}
	
	
	
	public Player (int points,int number, boolean go, JLabel label)
	{
		score=points;
		selection=0;
		playNO=number;
		turn=go;
		desc=label;
		desc.setFont(new Font("Ariel", Font.BOLD, 30));
	}

}
