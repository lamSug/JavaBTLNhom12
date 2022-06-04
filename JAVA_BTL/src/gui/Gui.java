package gui;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

import basic.Sensor;

public class Gui extends JPanel{
	ArrayList<Sensor> slist = new ArrayList<Sensor>();
	Sensor sParent[];
	int width;
	int height;
	public Gui(ArrayList<Sensor> slist, Sensor[] sParent, int width, int height) {
		this.slist = slist;
		this.sParent = sParent;
		this.width = width;
		this.height = height;

	}
	
	public void paint(Graphics g){
		g.drawRect(100, 50, width, height);
		
		//ve vi tri sensor va vung anh huong (hinh tron mau xanh)
		for (Sensor s: slist) {
			int diameter = s.getRadius()*2;
			int x = s.getCenter().getX() - s.getRadius() + 100;
			int y = s.getCenter().getY() - s.getRadius() + 50;
			g.setColor(java.awt.Color.green);
			g.fillOval(x, y, diameter, diameter);
		}
		
		// Ve duong noi giua cac sensor
		if (sParent[slist.size()-1].getIndex() != -1) {
			Sensor end = slist.get(slist.size()-1);
			while (end!=slist.get(0)) {
				g.setColor(java.awt.Color.blue);
				g.drawLine(end.getCenter().getX()+100, end.getCenter().getY()+50, 
						sParent[end.getIndex()].getCenter().getX()+100, 
						sParent[end.getIndex()].getCenter().getY()+50);
				end = sParent[end.getIndex()];
				
			}	
		}
		g.setColor(java.awt.Color.black);
		g.drawRect(100, 50, width, height);

	}

}