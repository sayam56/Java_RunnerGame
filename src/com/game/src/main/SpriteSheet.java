package com.game.src.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {
			private BufferedImage image;
			
			public SpriteSheet(BufferedImage image)
			{
				this.image = image;
			}
			
			public BufferedImage grabImg(int row, int col, int width, int height)
			{
				BufferedImage img = image.getSubimage((row * 64) - 64, (col * 60) - 60, width, height);
				return img;
			}
			
}
