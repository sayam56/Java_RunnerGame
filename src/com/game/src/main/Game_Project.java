package com.game.src.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game_Project extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int width = 640-12;
	public static final int height = 960-12;
	public static final int scale = 1;
	public static double playerX = 288;
	public static double playerY = 840; 
	private static double boulderX=500;
	private static double boulderY=100;
	public final String TITLE="Runner";
	
	private boolean run = false;
	private Thread thread;
	
	//private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	
	private BufferedImage spriteSheet =  null;
	

	private Player p;
	private Player pl;
	private Player pr;
	private Player pd;
	private Boulder b;
	
	
	public boolean walkUp=true;
	public boolean walkDown=false;
	public boolean walkLeft=false;
	public boolean walkRight=false;
	
	
	private Menu menu1;
	
	public static enum STATE{
		MENU,
		GAME,
		HELP,
		CREDIT,
		INSUBMENUBACK
	};
	
	
	public static STATE state = STATE.MENU;
	
	
	public void initialize()
	{
		requestFocus();
		BufferedImageLoader bsl = new BufferedImageLoader();
		BufferedImageLoader bsleft = new BufferedImageLoader();
		BufferedImageLoader bsright = new BufferedImageLoader();
		BufferedImageLoader bsdown = new BufferedImageLoader();
		
		
		BufferedImageLoader bsl2= new BufferedImageLoader();
		
		spriteSheet = bsl.loadImage("/Character_Sprite.png");
		
		
		//SpriteSheet ss= new SpriteSheet(spriteSheet);
		
		
		
		p = new Player ((int)playerX,(int)playerY,this);
		
		spriteSheet = bsleft.loadImage("/WalkLeft.png");
		pl= new Player((int)playerX,(int)playerY,this);
		
		spriteSheet = bsright.loadImage("/WalkRight.png");
		pr= new Player((int)playerX,(int)playerY,this);
		
		
		spriteSheet = bsdown.loadImage("/WalkDown.png");
		pd= new Player((int)playerX,(int)playerY,this);
		
		
		spriteSheet=bsl2.loadImage("/Boulder.png");
		b= new Boulder ((int)boulderX,(int)boulderY,this);
	    
		menu1 = new Menu();
		
		
		this.addKeyListener(new Keyboard_Input(this));
		this.addMouseListener(new MouseInput());
	}
	
	
	
	
	
	private synchronized void start()
	{
		if (run)
			return;
		
		run=true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	
	
	
	private synchronized void stop()
	{
		if (!run)
			return;
		
		run = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(1);;
	}
	
	
	
	
	
	public void run() {
		initialize();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int update=0;
		int frames=0;
		long timer= System.currentTimeMillis();
		
		while (run)
		{
			long now = System.nanoTime();
			delta += ( now - lastTime ) / ns;
			lastTime = now;
			if (delta >= 1)
			{
				tick();	 
				update++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println(update + " Ticks, FPS " +frames);
				update =0;
				frames=0;
			}
		}
		
		stop();
	}

	
	
	
	
	private void tick() {
		
		if (state == STATE.GAME)
		{
			p.tick();
			pl.tick();
			pr.tick();
			pd.tick();
		
			b.tick();
		}
		
	}
	
	
	
	
	
	private void render() {
		Image img = null;
		Image menu = null;
		Image help = null;
		Image credit = null;
		
		try {
			img = ImageIO.read(new File("res/Game_Background.png"));
			menu = ImageIO.read(new File("res/Menu.png"));
			help = ImageIO.read(new File("res/Help.png"));
			credit = ImageIO.read(new File("res/Credit.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferStrategy bs = this.getBufferStrategy();
		
		if ( bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		 /////////////////////////////////////
		
		if (state == STATE.GAME)
		{
			g.drawImage(img, 0, 0, this);
			if(walkUp==true)
				p.render(g);
			else if (walkDown==true)
				pd.render(g);
			else if (walkRight==true)
				pr.render(g);
			else if (walkLeft==true)
				pl.render(g);
			
			b.render(g);
		}
		
		else if (state ==  STATE.MENU)
		{
			g.drawImage(menu,0,0,this);
			menu1.render(g);
			
		}
		
		else if (state == STATE.HELP)
		{
			g.drawImage(help, 0, 0, this);
			Game_Project.state = Game_Project.STATE.INSUBMENUBACK;
			menu1.render(g);
		}
		
		else if (state == STATE.CREDIT)
		{
			g.drawImage(credit, 0, 0, this);
			Game_Project.state = Game_Project.STATE.INSUBMENUBACK;
			menu1.render(g);
		}
		
		
		////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	
	
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(state == STATE.GAME)
		{
			
			if (key == KeyEvent.VK_RIGHT)
			{
				pr.setVelX(15);
				
				walkUp=false;
				walkDown=false;
				walkLeft=false;
				walkRight=true;
			} 
			else if (key == KeyEvent.VK_LEFT)
			{
				pl.setVelX(-15);
				
				walkUp=false;
				walkDown=false;
				walkLeft=true;
				walkRight=false;
			}
			
			else if (key == KeyEvent.VK_UP)
			{
				p.setVelY(-15);
				
				walkUp=true;
				walkDown=false;
				walkLeft=false;
				walkRight=false;
			}
			
			else if (key == KeyEvent.VK_DOWN) 
			{
				pd.setVelY(15);
				
				walkUp=false;
				walkDown=true;
				walkLeft=false;
				walkRight=false;
			}
		}
	}
	
	
	
	public void keyReleased (KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT)
		{
			pr.setVelX(0);
		} 
		else if (key == KeyEvent.VK_LEFT)
		{
			pl.setVelX(0);
		}
		
		else if (key == KeyEvent.VK_UP)
		{
			p.setVelY(0);
		}
		
		else if (key == KeyEvent.VK_DOWN) 
		{
			pd.setVelY(0);
		}
	}
	
	
	
	
	
	public static void main (String args[])
	{
		Game_Project game = new Game_Project();
		 
		game.setPreferredSize(new Dimension (width*scale, height*scale));
		
		JFrame frame = new JFrame(game.TITLE);
		
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
		
		
	}
	
	
	
	
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}





	public boolean isWalkUp() {
		return walkUp;
	}





	public void setWalkUp(boolean walkUp) {
		this.walkUp = walkUp;
	}





	public boolean isWalkDown() {
		return walkDown;
	}





	public void setWalkDown(boolean walkDown) {
		this.walkDown = walkDown;
	}





	public boolean isWalkLeft() {
		return walkLeft;
	}





	public void setWalkLeft(boolean walkLeft) {
		this.walkLeft = walkLeft;
	}





	public boolean isWalkRight() {
		return walkRight;
	}





	public void setWalkRight(boolean walkRight) {
		this.walkRight = walkRight;
	}

	
	
	

}
