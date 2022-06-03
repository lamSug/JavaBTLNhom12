package basic;
import java.util.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sensor {
	private int index;
	private Point center;
	private int radius;
	private ArrayList<Sensor> neighborhood = new ArrayList<Sensor>();
	
	public Sensor(int index) {
		this.index = index;
	}
	
	public Sensor(int index, int radius, int width, int height) {
		this.index = index;
		Random r = new Random();
		center = new Point();
		center.setX(r.nextInt(width+1));
		center.setY(r.nextInt(height+1));
		this.radius = radius;
//		neighborhood = new ArrayList<Sensor>();
	}
	

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public ArrayList<Sensor> getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(ArrayList<Sensor> neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public void addNeiborhoodSensor(Sensor s) {
		this.neighborhood.add(s);
	}

	@Override
	public int hashCode() {
		return Objects.hash(index);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		return index == other.index;
	}
	
	
	
//	public void writeFile() throws IOException {
//		FileWriter fw = new FileWriter("ToaDo.txt");
//		PrintWriter pw = new PrintWriter(fw);
//		pw.printf("%d;%f;%\nf", index, center.getX(), center.getY());
//	}
//	
}
