package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;

public class CheckFileExist {

	private Log log = LogFactory.getLog("CheckFileExist");

	public String fileExisting(String appdir) {

		File appDir = new File(appdir);
		if (appDir.exists()) {
			log.info(appDir.getAbsolutePath() + " FILE EXISTING ");
			return appDir.getAbsolutePath();
		} else {
			throw new Error(" FILE NOT EXISTING IN  "
					+ appDir.getAbsolutePath());
		}
	}

}
