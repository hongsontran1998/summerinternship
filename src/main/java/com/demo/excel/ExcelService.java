package com.demo.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.entity.Category;
import com.demo.service.CategoryService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExcelService {

    @Autowired
    CategoryService categoryService;
 
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
 
    public void createExcelFile() throws IOException {
 
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");

        List<Category> categories = new ArrayList<>();
        categoryService.findAllOrFilter(null, null, null, null, null)
                .forEach(category -> categories.add(category));
 
        int rowNum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rowNum);
 
        // Id
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id");
        cell.setCellStyle(style);
        // Name
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Name");
        cell.setCellStyle(style);

        // Bonus
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Total of articles");
        cell.setCellStyle(style);

 
        // Data
        for (Category category : categories) {
            rowNum++;
            row = sheet.createRow(rowNum);
 
            // Id (CategoriesTableSeeder)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(category.getId());
            // Name (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(category.getName());
            //String formula = "0.1*C" + (rowNum + 1) + "*D" + (rowNum + 1);
            //cell = row.createCell(2, CellType.FORMULA);
            //cell.setCellFormula(formula);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Chưa có công thức tính nha");
        }
        File file = new File("C:/Users/Admin/Desktop/categories.xls");
        file.getParentFile().mkdirs();
 
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
 
    }
 
}