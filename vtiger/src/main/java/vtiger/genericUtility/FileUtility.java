package vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains the methods to fetch data from property file
 * @author user
 *
 */
public class FileUtility
{
	/**
	 * This method fetches data from the property file using the key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String toFetchDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTYFILEPATH);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
