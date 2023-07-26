package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path = ".\\testData\\mypractice.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcolumns = xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalrows][totalcolumns];
		
		for(int i = 0; i < totalrows; i++) {
			for(int j = 0; j < totalcolumns; j++) {
				loginData[i][j] = xlutil.getCelldata("Sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
