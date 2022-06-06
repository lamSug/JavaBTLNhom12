package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import basic.Sensor;

public class WriteFile {
	private FileWriter fw;
	private PrintWriter pw;
	
	public WriteFile(String fileName) throws IOException {
		fw = new FileWriter(fileName);
		pw = new PrintWriter(fw);
	}
	
	public void writeSensorCoordinates(ArrayList<Sensor> sensorList) throws IOException {
		for (Sensor s: sensorList) {
			pw.printf("%d;%d;%d\n", s.getIndex(), s.getCenter().getX(), s.getCenter().getY());
		}
		pw.flush();
		
	}
}
