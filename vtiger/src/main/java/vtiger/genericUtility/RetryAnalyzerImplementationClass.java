package vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementationClass implements IRetryAnalyzer
{
	int limit=3;
	int count=1;
	public boolean retry(ITestResult result) 
	{
		while(count<=limit)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
