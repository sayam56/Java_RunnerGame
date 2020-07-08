package com.game.src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard_Input extends KeyAdapter{
	
	
	Game_Project game; 	
	
	
	public Keyboard_Input(Game_Project game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e)
	{
		game.keyPressed(e);
	}
	
	public void keyReleased (KeyEvent e)
	{
		game.keyReleased(e);
	}

}
