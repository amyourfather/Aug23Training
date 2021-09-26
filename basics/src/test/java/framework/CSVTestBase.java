package framework;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;

import com.opencsv.CSVReader;

public class CSVTestBase {
	protected CSVReader csvReader;
	
	@Before
	public void Preinit() throws FileNotFoundException {
		ReadProperties readproperties = new ReadProperties();
		String csvName = "";
		try {
			csvName = readproperties.ReadCSVName();
		} catch(Exception ex) {
			throw new RuntimeException("property file not found in the classpath");
		}
		String filePathName = ClassLoader.getSystemResource(csvName + ".csv").getFile();
		this.csvReader = new CSVReader(new FileReader(filePathName));
	}
	
	@After
	public void CleanUp() throws IOException {
		this.csvReader.close();
	}
	
}
