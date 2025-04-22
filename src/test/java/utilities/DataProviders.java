package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name ="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\testData\\Opencart_LoginData.xlsx";			//taking xls file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path); 					//creating an object for ExcelUtility class.
		
		int totalrows = xlutil.getRowCount("Sheet2");
		int totalcols = xlutil.getCellCount("Sheet2", 1);
		
		String logindata[][] = new String[totalrows][totalcols];
		
		
		for(int i=1; i<=totalrows; i++) {
			
			for(int j=0; j<totalcols; j++) {
				
				logindata[i-1][j] = xlutil.getCellData("Sheet2", i, j);
			}
		}
		return logindata;			// returning two dimension array
		
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4

}
