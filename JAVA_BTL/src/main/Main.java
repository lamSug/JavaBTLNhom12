package main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import basic.Area;
import basic.Sensor;
import file.*;
import gui.Gui;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		ReadFile readArea = new ReadFile("Area.txt");
		WriteFile writeSensor = new WriteFile("Sensors.txt");
		Area a = new Area();
		a = readArea.readArea();
//		System.out.println(a.getWidth());
//		System.out.println(a.getHeight());
		ArrayList<Sensor> sl = new ArrayList<Sensor>();
		sl = a.getSensorList();
		Sensor sParent[] = new Sensor[sl.size()];
		Sensor sNull = new Sensor(-1);
		for (int i=0; i<sl.size(); i++) {
			sParent[i] = sNull;
		}
		sParent = a.DFS(sl.get(0), sl.get(sl.size()-1));
		
		//test
//		for (Sensor s: sl) {
//			System.out.printf("%d;%d;%d\n", s.getIndex(), s.getCenter().getX(), s.getCenter().getY());
//			
//			if (s.getNeighborhood()!=null) {
//				for (Sensor sNei: s.getNeighborhood()) {
//					System.out.printf("%d ", sNei.getIndex());
//				}
//				System.out.println();
//			}
//			
//			
//
//		}
		//
		
		writeSensor.writeSensorCoordinates(sl);
		
		
		
		JFrame f = new JFrame("Draw a rectangle");
	    f.getContentPane().add(new Gui(a.getSensorList() , sParent));
	    f.setSize(1000, 500);
	    f.setVisible(true);
	    f.setResizable(false);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
