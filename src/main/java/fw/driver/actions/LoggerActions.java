package fw.driver.actions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * @author Sudhasran Raju
 *	
 *
 */
@SuppressWarnings("rawtypes")
public class LoggerActions {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class clas) {
		if(root)
			return Logger.getLogger(clas);
		
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		root = true;
		return Logger.getLogger(clas);
	}

}
