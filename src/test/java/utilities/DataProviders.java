package utilities;
 
//import java.io.FileInputStream;

import java.io.IOException;
 
import org.testng.annotations.DataProvider;
 
public class DataProviders {

	@DataProvider(name="DP1")
	public String[][] data() throws IOException
	{

		ExcelUtils excelUtil=new ExcelUtils();
		int rowCount=excelUtil.getLastRowNum();
		int cellCount=excelUtil.getLastCellNum();
		String [][] s=new String[rowCount][cellCount];
		int j=1;
		
		while(j<=rowCount)
		{
			for(int i=0;i<cellCount;i++)
			{
				s[j - 1][i] = excelUtil.getCellData(j, i);
			}
			j++;
		}
		return s;

	}
 
}

 