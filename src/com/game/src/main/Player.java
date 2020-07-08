package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.src.libs.Animation;

public class Player {
	
	private double playerX;
	private double playerY;
	private double velX=0;
	private double velY=0;
	
	Animation animateUp;
	Animation animateDown;
	Animation animateLeft;
	Animation animateRight;
	
	
	int cell=9;
	
	private BufferedImage[] player = new BufferedImage[cell];
	private BufferedImage[] playerl = new BufferedImage[cell];
	private BufferedImage[] playerr = new BufferedImage[cell];
	private BufferedImage[] playerd = new BufferedImage[cell];
	
	public Player (double playerX, double playerY, Game_Project game)
	{
		this.playerX=playerX;
		this.playerY=playerY;
		SpriteSheet ss= new SpriteSheet(game.getSpriteSheet());
		
		//up
		player[0] = ss.grabImg(1, 1, 64, 60);
		player[1] = ss.grabImg(2, 1, 64, 60);
		player[2] = ss.grabImg(3, 1, 64, 60);
		player[3] = ss.grabImg(4, 1, 64, 60);
		player[4] = ss.grabImg(5, 1, 64, 60);
		player[5] = ss.grabImg(6, 1, 64, 60);
		player[6] = ss.grabImg(7, 1, 64, 60);
		player[7] = ss.grabImg(8, 1, 64, 60);
		player[8] = ss.grabImg(9, 1, 64, 60);
		
		
		animateUp= new Animation(1,player[1],player[2],player[3],player[4],player[5],player[6],player[7],player[8]);
		
		//down
		
		playerd[0] = ss.grabImg(1, 1, 64, 60);
		playerd[1] = ss.grabImg(2, 1, 64, 60);
		playerd[2] = ss.grabImg(3, 1, 64, 60);
		playerd[3] = ss.grabImg(4, 1, 64, 60);
		playerd[4] = ss.grabImg(5, 1, 64, 60);
		playerd[5] = ss.grabImg(6, 1, 64, 60);
		playerd[6] = ss.grabImg(7, 1, 64, 60);
		playerd[7] = ss.grabImg(8, 1, 64, 60);
		playerd[8] = ss.grabImg(9, 1, 64, 60);
		
		animateDown= new Animation(1,playerd[0],playerd[1],playerd[2],playerd[3],playerd[4],playerd[5],playerd[6],playerd[7],playerd[8]);
		
		
		//left
		playerl[0] = ss.grabImg(1, 1, 64, 60);
		playerl[1] = ss.grabImg(2, 1, 64, 60);
		playerl[2] = ss.grabImg(3, 1, 64, 60);
		playerl[3] = ss.grabImg(4, 1, 64, 60);
		playerl[4] = ss.grabImg(5, 1, 64, 60);
		playerl[5] = ss.grabImg(6, 1, 64, 60);
		playerl[6] = ss.grabImg(7, 1, 64, 60);
		playerl[7] = ss.grabImg(8, 1, 64, 60);
		playerl[8] = ss.grabImg(9, 1, 64, 60);
		
		
		animateLeft= new Animation(1,playerl[0],playerl[1],playerl[2],playerl[3],playerl[4],playerl[5],playerl[6],playerl[7],playerl[8]);
		
		
		//right
		playerr[0] = ss.grabImg(1, 1, 64, 60);
		playerr[1] = ss.grabImg(2, 1, 64, 60);
		playerr[2] = ss.grabImg(3, 1, 64, 60);
		playerr[3] = ss.grabImg(4, 1, 64, 60);
		playerr[4] = ss.grabImg(5, 1, 64, 60);
		playerr[5] = ss.grabImg(6, 1, 64, 60);
		playerr[6] = ss.grabImg(7, 1, 64, 60);
		playerr[7] = ss.grabImg(8, 1, 64, 60);
		playerr[8] = ss.grabImg(9, 1, 64, 60);
		
		
		animateRight= new Animation(1,playerr[0],playerr[1],playerr[2],playerr[3],playerr[4],playerr[5],playerr[6],playerr[7],playerr[8]);
	}
	
	public void tick() {
		
		playerX+=velX;
		playerY+=velY;
		
		
		if (playerX <= 0+155)
			playerX=0+155;
		if (playerX >= 640-195)
			playerX= 640-195;
		if (playerY <= 0)
			playerY = 0;
		if (playerY >= 960-61)
			playerY=960-61;
		
		animateUp.runAnimation();
		animateDown.runAnimation();
		animateLeft.runAnimation();
		animateRight.runAnimation();
	}
	
	public void render( Graphics g) {
		
			animateUp.drawAnimation(g, playerX, playerY, 0 );
			animateDown.drawAnimation(g, playerX, playerY, 0 );
			animateLeft.drawAnimation(g, playerX, playerY, 0 );
			animateRight.drawAnimation(g, playerX, playerY, 0 );
			
		
		//g.drawImage(player[0], (int)playerX, (int)playerY,null);
	}

	public double getPlayerX() {
		return playerX;
	}

	public void setPlayerX(double playerX) {
		this.playerX = playerX;
	}

	public double getPlayerY() {
		return playerY;
	}

	public void setPlayerY(double playerY) {
		this.playerY = playerY;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	

	
	
}
