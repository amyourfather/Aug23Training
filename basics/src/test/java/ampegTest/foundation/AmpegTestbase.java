package ampegTest.foundation;

import org.junit.Before;

import framework.Testbase;

public class AmpegTestbase extends Testbase {

	private String HomeUrl = "https://ampeg.com/index.html";
	@Before
	public void Preinit() {
		super.Preinit();
		DriverDocPage = new DriverDocPage(driver, HomeUrl);
	}
}
