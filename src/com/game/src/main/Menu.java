package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle (Game_Project.width /2 -95,400,200,70);
	public Rectangle helpButton = new Rectangle (Game_Project.width /2 -95,500,200,70);
	public Rectangle creditButton = new Rectangle (Game_Project.width /2 -95,600,200,70);
	public Rectangle exitButton = new Rectangle (Game_Project.width /2 -95,700,200,70);
	public Rectangle backButton = new Rectangle (Game_Project.width/2 - 95,800,200,70);
	
	public void render (Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		
		if (Game_Project.state == Game_Project.STATE.INSUBMENUBACK)
		{
			Font fnt = new Font("comicsans", Font.BOLD, 50);
			g.setColor(Color.RED);
			g.setFont(fnt);
			g.setColor(Color.RED);
			g.drawString("Back", backButton.x+45, backButton.y+50);
			g.setColor(Color.black);
			g2d.draw(backButton);
		}
		else
		{
			Font fnt = new Font("comicsans", Font.BOLD, 50);
			g.setColor(Color.RED);
			g.setFont(fnt);
			g.drawString("Play", playButton.x + 50, playButton.y + 50);
			g.setColor(Color.black);
			g2d.draw(playButton);

			g.setColor(Color.RED);
			g.drawString("Help", helpButton.x + 50, helpButton.y + 50);
			g.setColor(Color.black);
			g2d.draw(helpButton);

			g.setColor(Color.RED);
			g.drawString("Credits", creditButton.x + 15, creditButton.y + 50);
			g.setColor(Color.black);
			g2d.draw(creditButton);

			g.setColor(Color.RED);
			g.drawString("Exit", exitButton.x + 50, exitButton.y + 50);
			g.setColor(Color.black);
			g2d.draw(exitButton);
		}
		
		
	}
}
