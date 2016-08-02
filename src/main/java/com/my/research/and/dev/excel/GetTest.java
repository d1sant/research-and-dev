package com.my.research.and.dev.excel;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

public class GetTest {

    public static void main(String[] args) throws Exception {
        final InputStream in = new FileInputStream("/Users/dmitry.palaznik/temp.xls");
        final HSSFWorkbook workbook = new HSSFWorkbook(in);
        final Sheet sheet = workbook.getSheetAt(0);
        for (final Row row : sheet) {
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                final Cell cell = cells.next();
                final int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "=");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print("[" + cell.getNumericCellValue() + "]");
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        System.out.print("[" + cell.getNumericCellValue() + "]");
                        System.out.print("[" + cell.getCellFormula() + "]");
                        // cell.setCellFormula("SUM(B1:B2)");
                        break;
                    default:
                        System.out.print("|");
                        break;
                }
            }
            System.out.println();
        }
        /*
        HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
        final FileOutputStream outputStream = new FileOutputStream(new File("/Users/dmitry.palaznik/temp.xls"));
        workbook.write(outputStream);
        outputStream.close();
        */
    }
}
