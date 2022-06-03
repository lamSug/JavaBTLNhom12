package file;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import basic.Area;

public class ReadFile {
	private FileReader fr;
	private BufferedReader bf;
	
	public ReadFile(String fileName) throws FileNotFoundException {
		fr = new FileReader(fileName);
		bf = new BufferedReader(fr);
	}
	
	public Area readArea() throws NumberFormatException, IOException {
		int width = Integer.parseInt(bf.readLine());
		int height = Integer.parseInt(bf.readLine());
		int nos = Integer.parseInt(bf.readLine());
		int radius = Integer.parseInt(bf.readLine());
		Area a = new Area(width, height, nos, radius);
		return a;
	}
}
