package DealsDray.DealsDray;

import java.util.List;
import java.io.IOException;

public class Mainclass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ScreenshotAutomation automation = new ScreenshotAutomation();

	    List<String> browsers = List.of("firefox");
	    
	    List<int[]> desktopResolutions = List.of(
	        new int[]{1920, 1080}, 
	        new int[]{1366, 768}, 
	        new int[]{1536, 864}
	    );

	    List<int[]> mobileResolutions = List.of(
	        new int[]{360, 640}, 
	        new int[]{414, 896}, 
	        new int[]{375, 667}
	    );

	    // Run tests for desktop and mobile
	    automation.runTests(browsers, desktopResolutions);
	    automation.runTests(browsers, mobileResolutions);
	}


	}


	


