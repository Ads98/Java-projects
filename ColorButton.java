//package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ColorButton extends JButton implements ActionListener
{
	public int state;
	PSYADSTmain ref;
	int ButtonNo;
	Color drawColor; 
	Color DisplayColor; 
	int borderSize;
	
	public Color getDisplay() {
		return DisplayColor;
	}
	
	public void setDisplay(Color c)
	{
		DisplayColor=c;
	}
	
	public int getButtonNo()
	{
		return ButtonNo;
	}
	
	
	public int getState()
	{
		return state;
	}
	
	public void setstate(int status)
	{
			   state=status;
	}
	
	public void setDrawColor(Color drawColor) 
	{
		this.drawColor = drawColor;
	}

	
	public ColorButton(int number, PSYADSTmain ob, int min_w, int min_h)
	{	
		this.addActionListener(this);
		ref=ob; 
		ButtonNo = number; 
		state=1;
		DisplayColor=null; 
		//drawColor=Color.GRAY;
		this.setBackground(Color.GRAY);
		borderSize=0;
		setMinimumSize( 
				new Dimension(min_w, min_h) );
			setPreferredSize( 
				new Dimension(min_w, min_h));
	}
	
	public void remove()
	{
		this.setBackground(Color.BLACK);
		state=3;
	}
	
	public void flip(boolean show)
	{
		if (show == true) 
				{
					//drawColor=DisplayColor;
					System.out.println("fliping");
					this.setBackground(DisplayColor);
					state=2;
					
				}
		else
		{
			this.setBackground(Color.GRAY);
			state=1;
		}
		
	}
	

	
	protected void draw(Graphics g)
	{
		if ( drawColor != null )
		{
			g.setColor(drawColor);
			g.fillRect( borderSize, borderSize,
				getWidth()-borderSize*2,
				getHeight()-borderSize*2 );
		}
	}
	
	
	   @Override
	  	public void actionPerformed(ActionEvent e)
	  	{
	  	// TODO Auto-generated method stub
	  		ref.buttonClicked(ButtonNo);
	  		
	  	}
     
     
  }

	
	


