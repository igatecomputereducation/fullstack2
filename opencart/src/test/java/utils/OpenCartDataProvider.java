package utils;

import org.testng.annotations.DataProvider;

public class OpenCartDataProvider {

	
	
	
	@DataProvider(name = "LoginData")
	public String[][] dataProviderForLogin(){
		String fpath=".//testdata//testdata.xlsx";
		String sname="Login";
		int rows=ExcelUtil.getMaxRowIndex(fpath, sname);
		int cols=ExcelUtil.getMaxCellCount(fpath, sname);
		String[][] data=new String[rows][cols];
		
		for(int r=0;r<rows;r++)
		{
			for(int c=0;c<cols;c++) {
				data[r][c]=ExcelUtil.getCellData(fpath, sname, r+1, c);
			}
		}
		return data;
	}
}
