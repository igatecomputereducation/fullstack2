package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static int getMaxRowIndex(String xlfile,String xlsheet) {
		int n=0;
		try {
				FileInputStream fin=new FileInputStream(xlfile);
				XSSFWorkbook book=new XSSFWorkbook(fin);
				XSSFSheet sheet=book.getSheet(xlsheet);
				n=sheet.getLastRowNum();
		}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		return n;
	}
	public static int getMaxCellCount(String xlfile,String xlsheet) {
		int n=0;
		try {
				FileInputStream fin=new FileInputStream(xlfile);
				XSSFWorkbook book=new XSSFWorkbook(fin);
				XSSFSheet sheet=book.getSheet(xlsheet);
				XSSFRow row=sheet.getRow(0);
				n=row.getLastCellNum();
		}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		return n;
	}
	public static String getCellData(String xlfile,String xlsheet,int rowidx,int cellidx) {
		String celldata="";
		try {
				FileInputStream fin=new FileInputStream(xlfile);
				XSSFWorkbook book=new XSSFWorkbook(fin);
				XSSFSheet sheet=book.getSheet(xlsheet);
				XSSFRow row=sheet.getRow(rowidx);
				celldata=row.getCell(cellidx).toString();
		}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		return celldata;
	}
	public static void setCellData(String xlfile,String xlsheet,String data,int rowidx,int cellidx) {
		try {
			FileInputStream fin=new FileInputStream(xlfile);
			XSSFWorkbook book=new XSSFWorkbook(fin);
			XSSFSheet sheet=book.getSheet(xlsheet);
			XSSFRow row=sheet.getRow(rowidx);
			row.createCell(cellidx).setCellValue(data);
			FileOutputStream fout=new FileOutputStream(xlfile);
			book.write(fout);
			book.close();
			fout.close();
		}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
	}
	
	public static void setGreenColor(String xlfile,String xlsheet,int rowidx,int cellidx) {
		
		try {
			
			FileInputStream fin=new FileInputStream(xlfile);
			XSSFWorkbook book=new XSSFWorkbook(fin);
			XSSFSheet sheet=book.getSheet(xlsheet);
			XSSFRow row=sheet.getRow(rowidx);
			XSSFCell  cell=row.getCell(cellidx);
			CellStyle csty=book.createCellStyle();
			csty.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		    csty.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    cell.setCellStyle(csty);
			FileOutputStream fout=new FileOutputStream(xlfile);
			book.write(fout);
			book.close();
			fout.close();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void setRedColor(String xlfile,String xlsheet,int rowidx,int cellidx) {
		try {
			
			FileInputStream fin=new FileInputStream(xlfile);
			XSSFWorkbook book=new XSSFWorkbook(fin);
			XSSFSheet sheet=book.getSheet(xlsheet);
			XSSFRow row=sheet.getRow(rowidx);
			XSSFCell  cell=row.getCell(cellidx);
			CellStyle csty=book.createCellStyle();
			csty.setFillForegroundColor(IndexedColors.RED.getIndex());
		    csty.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    cell.setCellStyle(csty);
			FileOutputStream fout=new FileOutputStream(xlfile);
			book.write(fout);
			book.close();
			fout.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}	
}