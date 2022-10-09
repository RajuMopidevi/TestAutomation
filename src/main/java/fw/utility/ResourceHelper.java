package fw.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Sudharsan Raju
 *	
 *
 */
public class ResourceHelper {

	public static String getResourcePath(String resource) {
		String path ="";
		try {
			path = getBaseResourcePath() + resource;
		}catch(Exception e) {
			path="src/main/resources/"+ resource;
		}
		
		return path;
	}
	
	public static String getBaseResourcePath() {
		String path = ResourceHelper.class.getClass().getResource("/").getPath();
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String resource) throws FileNotFoundException {
		return new FileInputStream(ResourceHelper.getResourcePath(resource));
	}
	
}
