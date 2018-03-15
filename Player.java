package com.joe.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Player extends GameObject{

	Handler handler;
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;	
		}

	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH-36);
		y = Game.clamp(y, 0, Game.HEIGHT-60);
	
		collision();
	}
	
	
	private void collision(){
		for(int i = 0 ; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy
					|| tempObject.getId() == ID.SmartEnemy){

				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH -= 2;
				}
				
			}
		}
	}


	public void render(Graphics g) {
		g.setColor(Color.white);
		
		g.fillRect((int)x,(int) y, 32, 32);
	
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}

	
}
