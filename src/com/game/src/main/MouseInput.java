package com.game.src.main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.game.src.main.Game_Project.STATE;

public class MouseInput implements MouseListener{
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
		int mx=e.getX();
		int my=e.getY();
		
		
		/*public Rectangle playButton = new Rectangle (Game_Project.width /2 -95,400,200,70);
		public Rectangle helpButton = new Rectangle (Game_Project.width /2 -95,500,200,70);
		public Rectangle creditButton = new Rectangle (Game_Project.width /2 -95,600,200,70);
		public Rectangle exitButton = new Rectangle (Game_Project.width /2 -95,700,200,70);*/

		
		
		//playButton
		if (mx >= Game_Project.width /2 -95 && mx <= Game_Project.width /2 +295)
		{
			if (my >= 400 && my <= 470)
			{
				Game_Project.state = Game_Project.STATE.GAME;
				
			}
		}
		
		
		//helpButton
				if (mx >= Game_Project.width /2 -95 && mx <= Game_Project.width /2 +295)
				{
					if (my >= 500 && my <= 570)
					{
						Game_Project.state = Game_Project.STATE.HELP;
						
					}
				}
				
				
				
				//creditButton
				if (mx >= Game_Project.width /2 -95 && mx <= Game_Project.width /2 +295)
				{
					if (my >= 600 && my <= 670)
					{
						Game_Project.state = Game_Project.STATE.CREDIT;
						
					}
				}
				
				
				
				//quitButton
				if (mx >= Game_Project.width /2 -95 && mx <= Game_Project.width /2 +295)
				{
					if (my >= 700 && my <= 770)
					{
						System.exit(1);
						
					}
				}
				
				
				//backButton
				//public Rectangle backButton = new Rectangle (Game_Project.width/2 - 95,800,200,70);
				
				if (mx >= Game_Project.width /2 -95 && mx <= Game_Project.width /2 +295)
				{
					if (my >= 800 && my <= 870)
					{
						Game_Project.state = Game_Project.STATE.MENU;
						
					}
				}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
