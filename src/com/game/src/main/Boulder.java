package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.src.libs.Animation;

public class Boulder {

	private double boulderX;
	private double boulderY=0;
	
	Animation aniB;
	
	private BufferedImage[] boulder= new BufferedImage[9];
	
	public Boulder (double boulderX, double boulderY, Game_Project game)
	{
		this.boulderX=boulderX;
		this.boulderY=boulderY;
		SpriteSheet ss= new SpriteSheet(game.getSpriteSheet());
		
		boulder[0]= ss.grabImg(1, 1, 65, 65);
		boulder[1]= ss.grabImg(1, 2, 65, 65);
		boulder[2]= ss.grabImg(1, 3, 65, 65);
		boulder[3]= ss.grabImg(2, 1, 65, 65);
		boulder[4]= ss.grabImg(2, 2, 65, 65);
		boulder[5]= ss.grabImg(2, 3, 65, 65);
		boulder[6]= ss.grabImg(3, 1, 65, 65);
		boulder[7]= ss.grabImg(3, 2, 65, 65);
		boulder[8]= ss.grabImg(3, 3, 65, 65);
		
		
		aniB= new Animation(1,boulder[0],boulder[1],boulder[3],boulder[4],boulder[5],boulder[6],boulder[7],boulder[8]);
	}
	
	public void tick() {
		
		boulderY+=20;
		
		
		if (boulderX <= 0+155)
			boulderX=0+155;
		if (boulderX >= 640-195)
			boulderX= 640-195;
		if (boulderY <= 0)
			boulderY = 0;
		if (boulderY >= 960-61)
			boulderY=960-61;
		
		
		aniB.runAnimation();
	}
	
	public void render( Graphics g) {
		
		aniB.drawAnimation(g, boulderX, boulderY, 0);
	}
}
