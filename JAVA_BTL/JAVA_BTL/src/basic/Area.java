package basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.math.*;

public class Area {
	private int width, height, xAxis, yAxis;
	private ArrayList<Sensor> sensorList;
	
	public Area() {
		this.width = 0;
		this.height = 0;
		sensorList = new ArrayList<Sensor>();
	}
	
	//nos : number of sensor
	public Area(int width, int height, int nos, int radius) {
		this.xAxis = 50;
		this.yAxis = 50;
		this.width = width;
		this.height = height;
		
		// Tao list sensor
		Sensor s;
		sensorList = new ArrayList<Sensor>();
		for (int i=0; i<nos; i++) {
			// sensor duoc danh so tu 1 den nos
			s = new Sensor(i+1, radius, width, height);
			sensorList.add(s);
		}
		
		// tạo sensor ảo
		s = new Sensor(0);
		Point p = new Point();
		p.setX(xAxis - 2*radius-1);
		p.setY((yAxis+height)/2);
		s.setCenter(p);
		sensorList.add(0,s);
		
		Sensor s2=new Sensor(nos+1);
		s2.setIndex(nos+1);
		Point q = new Point(xAxis+ width + 2*radius+1, (yAxis+height)/2);
		s2.setCenter(q);
		sensorList.add(s2);
		
		//Xác định các cạnh
		setEgde();
		
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public ArrayList<Sensor> getSensorList() {
		return sensorList;
	}

	public void setSensorList(ArrayList<Sensor> sensorList) {
		this.sensorList = sensorList;
	}
	
	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	
	//Xac dinh canh cua do thi
	public void setEgde() {

		for(Sensor s1: sensorList) {

			for(Sensor s2: sensorList) {
				double temp = Math.sqrt(Math.pow((s2.getCenter().getX() - s1.getCenter().getX()), 2) + Math.pow((s2.getCenter().getY() - s1.getCenter().getY()), 2));
				if (temp <= 2*s1.getRadius() & temp > 0) {
					s1.addNeiborhoodSensor(s2);
				}
			}
			
		}

		Sensor sStart = sensorList.get(0);
		Sensor sEnd = sensorList.get(sensorList.size()-1);
		
		for(Sensor s: sensorList) {
			if (s.getIndex()!=0){
				if (s.getCenter().getX() <= s.getRadius()) {
					s.addNeiborhoodSensor(sStart);
					sStart.addNeiborhoodSensor(s);
				}
			}
			
			if (s.getIndex()!=sEnd.getIndex())
			if (s.getCenter().getX() >= width - s.getRadius()) {
				s.addNeiborhoodSensor(sEnd);
				sEnd.addNeiborhoodSensor(s);
			}
		}
	
	}
	
	//tìm đường giữa 2 sensor 0, nos;
	public void dfsUtil(Sensor s, boolean visited[], Sensor sParent[]) {
		visited[s.getIndex()] = true;
//		System.out.print(s.getIndex() + " ");
		Iterator<Sensor> itrSensor = s.getNeighborhood().iterator();
		while (itrSensor.hasNext()) {
			Sensor s1 = itrSensor.next();
			if(!visited[s1.getIndex()]) {
				sParent[s1.getIndex()] = s;
				dfsUtil(s1, visited, sParent);
			}
		}
	}
	
	public Sensor[] DFS(Sensor sStart, Sensor sEnd) {
		boolean visited[] = new boolean[sensorList.size()];
		Sensor sParent[] = new Sensor[sensorList.size()];
		Sensor sNull = new Sensor(-1);
		for (int i=0; i<sensorList.size(); i++) {
			sParent[i] = sNull;
		}
		dfsUtil(sStart, visited, sParent);

		if (sParent[sensorList.size()-1].getIndex()==-1) {
			System.out.print("Weak Barrier Coverage");
		}
		else {
			System.out.print("Strong Barrier Coverage");
		}
		return sParent;
	}
}
