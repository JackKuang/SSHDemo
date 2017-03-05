package com.hurenjieee.action;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.hurenjieee.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "json") // Ӧ��ȫ�ְ�
@Scope("prototype")
@Namespace(value = "/admin")
@Action(results = {
		@Result(name = "json", type = "json", params = { "root", "resultMap"}) })
public class ExcelImportAction extends ActionSupport{
	
	/** 
	 * ��ȡExcel���ԣ����� Excel 2003/2007/2010 
	 */  
	public String readExcel()  
	{  
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
	    try {  
	        //ͬʱ֧��Excel 2003��2007  
	        File excelFile = new File("/home/zht/test.xls"); //�����ļ�����  
	        FileInputStream is = new FileInputStream(excelFile); //�ļ���  
	        Workbook workbook = WorkbookFactory.create(is); //���ַ�ʽ Excel 2003/2007/2010 ���ǿ��Դ����  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet������  
	        //����ÿ��Sheet  
	        for (int s = 0; s < sheetCount; s++) {  
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //��ȡ������  
	            //����ÿһ��  
	            for (int r = 0; r < rowCount; r++) {  
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //��ȡ������  
	                //����ÿһ��  
	                for (int c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);  
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //�ı�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //���֡�����  
	                        	// FIXME
	                            if(true) {  
	                                cellValue = fmt.format(cell.getDateCellValue()); //������  
	                            }  
	                            else {  
	                                cellValue = String.valueOf(cell.getNumericCellValue()); //����  
	                            }  
	                            break;  
	                        case Cell.CELL_TYPE_BOOLEAN: //������  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //�հ�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //����  
	                            cellValue = "����";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //��ʽ  
	                            cellValue = "����";  
	                            break;  
	                        default:  
	                            cellValue = "����";  
	                    }  
	                    System.out.print(cellValue + "    ");  
	                }  
	                System.out.println();  
	            }  
	        }  
	  
	    }  
	    catch (Exception e) {  
	        e.printStackTrace();  
	    }
	    // FIXME
	    return "S";
	}  

}
