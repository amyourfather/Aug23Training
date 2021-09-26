package CSVTest;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import org.junit.Test;

import com.opencsv.exceptions.CsvValidationException;

import framework.CSVTestBase;

public class ReadBassCSVTest extends CSVTestBase{	
	@Test
	public void AbleToReadBassToHashMap() throws CsvValidationException, IOException {
		HashMap<String, String> Output = new HashMap<String, String>();
		HashMap<String, String> Expected = new HashMap<String, String>();
		
		Expected.put("Warwick", "Corvette");
		Expected.put("Warwick", "Thumb");
		Expected.put("Warwick", "Streamer");
		Expected.put("Fender", "Precision");
		Expected.put("Fender", "Jazz");
		Expected.put("Yamaha", "BB500");
		
		String [] nextLine;
		csvReader.readNext();
	    while ((nextLine = csvReader.readNext()) != null) {
	    	Output.put(nextLine[0], nextLine[1]);
	    }
	   
	    assertTrue("Does match the expected HashMap", Output.equals(Expected));
	   
	}
}
