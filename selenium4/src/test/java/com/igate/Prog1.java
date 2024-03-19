package com.igate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utilities.*;

public class Prog1 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("http://127.0.0.1:5500/calc.html");
		driver.manage().window().maximize();

		//getting maximum index of row
		int maxrowidx = ExcelUtil.getMaxRowIndex("d:\\calculator.xlsx", "Sheet1");

		for (int r = 1; r <= maxrowidx; r++) {
			//reading data from excel sheet
			String dfir = ExcelUtil.getCellData("d:\\calculator.xlsx", "Sheet1", r, 0);
			String dsec = ExcelUtil.getCellData("d:\\calculator.xlsx", "Sheet1", r, 1);
			String expdata = ExcelUtil.getCellData("d:\\calculator.xlsx", "Sheet1", r, 2);

			//sending data to calculator
			driver.findElement(By.id("txt1")).sendKeys(dfir);
			driver.findElement(By.id("txt2")).sendKeys(dsec);
			driver.findElement(By.id("add")).click();

			//getting result from calculator
			String actdata = driver.findElement(By.id("txt3")).getAttribute("value").toString();

			//writing actual actual data
			ExcelUtil.setCellData("d:\\calculator.xlsx", "Sheet1", actdata, r, 3);

			//writing test result
			if (Float.parseFloat(expdata) == Float.parseFloat(actdata)) {
				ExcelUtil.setCellData("d:\\calculator.xlsx", "Sheet1", "Pass", r, 4);
				ExcelUtil.setGreenColor("d:\\calculator.xlsx", "Sheet1", r, 4);
			} else {
				ExcelUtil.setCellData("d:\\calculator.xlsx", "Sheet1", "Fail", r, 4);
				ExcelUtil.setRedColor("d:\\calculator.xlsx", "Sheet1", r, 4);
			}

			driver.findElement(By.id("cls")).click();
		}
	}
}
