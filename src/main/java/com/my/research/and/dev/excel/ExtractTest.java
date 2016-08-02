package com.my.research.and.dev.excel;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExtractTest {

    public static void main(final String[] args) throws Exception {
        final InputStream in = new FileInputStream("/Users/dmitry.palaznik/temp.xls");
        final HSSFWorkbook workbook = new HSSFWorkbook(in);
        final ExcelExtractor extractor = new ExcelExtractor(workbook);
        extractor.setFormulasNotResults(false);
        extractor.setIncludeSheetNames(true);
        final String text = extractor.getText();
        System.out.println(text);
    }
}
