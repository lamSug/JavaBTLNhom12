package gui;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

import basic.Sensor;

public class Gui extends JPanel{
	ArrayList<Sensor> slist = new ArrayList<Sensor>();
	Sensor sParent[];
	public Gui(ArrayList<Sensor> slist, Sensor[] sParent) {
		this.slist = slist;
		this.sParent = sParent;

	}
	
	public void paint(Graphics g){
		g.drawRect(100, 50, 500, 300);

		for (Sensor s: slist) {
			int diameter = s.getRadius()*2;
			int x = s.getCenter().getX() - s.getRadius()/2 + 100;
			int y = s.getCenter().getY() - s.getRadius()/2 + 50;
			g.setColor(java.awt.Color.green);
			g.fillOval(x, y, diameter, diameter);
		}
		if (sParent[slist.size()-1].getIndex() != -1) {
			Sensor end = slist.get(slist.size()-1);
			while (end!=slist.get(0)) {
				g.setColor(java.awt.Color.blue);
				g.drawLine(end.getCenter().getX(), end.getCenter().getY(), 
						sParent[end.getIndex()].getCenter().getX(), 
						sParent[end.getIndex()].getCenter().getY());
				end = sParent[end.getIndex()];
				
			}	
		}

	}

}