package org.Maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
@SuppressWarnings("resource")
public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\ExcelSheets\\Login.xlsx");
	File f1 = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\ExcelSheets\\New.xlsx");
	
	FileInputStream s = new FileInputStream(f);
	
	Workbook wb = new XSSFWorkbook(s);
	Workbook wb1 = new XSSFWorkbook();
	Sheet ss = wb.getSheet("Login");
	Sheet s1 = wb1.createSheet("New");
	Row r1 = s1.createRow(1);
	Cell c1 = r1.createCell(1);
	c1.setCellValue("JAFFIR");
	FileOutputStream fos =new  FileOutputStream(f1);
	wb1.write(fos);
	for (int i = 0; i <ss.getPhysicalNumberOfRows(); i++) {
		Row R = ss.getRow(i);
	System.out.println("_____________________________");
		for (int j = 0; j <R.getPhysicalNumberOfCells(); j++) {
			Cell C = R.getCell(j);
			CellType ct= C.getCellType();
			switch (ct) {
			case STRING:
				String sv = C.getStringCellValue();
				System.out.println(sv);
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(C)) {
					Date dcv = C.getDateCellValue();
					SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
					String format = df.format(dcv);
					System.out.println(format)	;	
				} 
				else {
				double nv = C.getNumericCellValue();
//				BigDecimal bd = BigDecimal.valueOf(nv);
				long r = Math.round(nv);
//				String num = String.valueOf(bd);
//				System.out.println(num);
					if (nv==r) {
						String valueOf = String.valueOf(r);
						System.out.println(valueOf);
					} else {
						String value2 = String.valueOf(nv);
						System.out.println(value2);

					}
					
				}
				break;
			default:
				break;
			}
		}
	}
	
	
	
	
}
}
