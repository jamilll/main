package com.joe.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Poly extends GameObject{
	
	private int[] x, y;
	private Polygon p;
	
	private double degree = 0.1;
	public Poly(float x, int y, ID id) {
		super(x, y, id);
		this.x = new int[]{100,200,100};
		this.y = new int[]{100,200,400};
		p = new Polygon(this.x, this.y, this.x.length);


	}

	public void tick() {
		//x1 = x cos ß - y sin ß
		for (int i = 0; i < x.length; i++) {
			x[i] = (int) (x[i] * Math.cos(degree) - y[i] * Math.sin(degree) );
			y[i]= (int) (x[i] * Math.sin(degree) + y[i] * Math.cos(degree) );	
		}

	
		/*x[1] = (int) (x[1] * Math.cos(degree) - y[1] * Math.sin(degree) );
		y[1] = (int) (x[1] * Math.sin(degree) + y[1] * Math.cos(degree) );*/
		//System.out.println(degree);
		//y[0]++;
	}

	
	public void render(Graphics g){
		g.setColor(Color.white);
		//g.fillPolygon(new int[]{10,200,50}, new int[]{10,200,50}, 2);
		p.xpoints = x;
		p.ypoints = y;
		
		g.fillPolygon(p);
		g.drawPolygon(p);
		
	}


	public Rectangle getBounds() {
		return null;
	}

}
