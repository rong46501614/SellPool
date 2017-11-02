package com.xftx.xingfeng.fileutils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by xingfeng on 2017/8/12.
 */
public class ReadExcelFile {
    public static JSONObject readExcelFileToJson(String FilePath){
        JSONObject json = new JSONObject();
        try{
            File file=new File(FilePath);
            FileInputStream fis=new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            int sheet_numbers = wb.getNumberOfSheets();
            for(int i=0;i<sheet_numbers;i++){
                HSSFSheet sheet = wb.getSheetAt(i);
                String sheetnames= sheet.getSheetName();//获取表名，存入数组
                try {
                    json.put(sheetnames,getSheetToJson(sheet));
                } catch (Exception e) {
                    continue;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }

    private static JSONArray getSheetToJson(HSSFSheet sheet){
        JSONArray jsonSheet = new JSONArray();
        for( int rows=0;rows<sheet.getLastRowNum()+1;rows++) {
            HSSFRow row = sheet.getRow(rows);
            JSONArray jsonRow = new JSONArray();
            for( int columns=0;columns<row.getLastCellNum();columns++){
                HSSFCell  cell = row.getCell(columns);
                if(cell!=null){
                    if(cell.getCellType() == 0){
                        jsonRow.put(cell.getNumericCellValue()+"");
                    }else if(cell.getCellType() == 1){
                        jsonRow.put(cell.getStringCellValue());
                    }else if(cell.getCellType() == 2){
                        jsonRow.put(cell.getBooleanCellValue()+"");
                    }else if(cell.getCellType() == 3){
                        jsonRow.put("");
                    }
                }
            }
            jsonSheet.put(jsonRow);
        }
        return jsonSheet;
    }

}
