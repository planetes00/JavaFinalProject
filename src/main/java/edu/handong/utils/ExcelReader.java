package edu.handong.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public ArrayList<String> getData(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		
		try (InputStream inp = is) {
		    	//InputStream inp = new FileInputStream("workbook.xlsx");

		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        int rowindex=0;
		        int columnindex=0;
		        String temp="";
		        //행의 수
		        int rows=sheet.getPhysicalNumberOfRows();
		        for(rowindex=1;rowindex<rows;rowindex++){
		            //행을읽는다
		            Row row=sheet.getRow(rowindex);
		            if(row !=null){
		                //셀의 수
		                int cells=row.getPhysicalNumberOfCells();
		                for(columnindex=0;columnindex<=cells;columnindex++){
		                    //셀값을 읽는다
		                    Cell cell=row.getCell(columnindex);
		                    String value="";
		                    if(cell==null){
		                        continue;
		                    }else value=cell.getStringCellValue()+"";
		                    temp=temp+"헬로"+value;
		                }
		                values.add(temp);
		                temp="";
		            }
		        }
		        
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return values;
	}
}
