package com.my.research.and.dev.excel;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;

public class ReelsExtractor {

    private static final String PATH_TO_MATH = "/Users/dmitry.palaznik/American Dad-math-94.14%_v1.2_PT.xlsx";
    private static final String SHEET = "Re-spin Reels Stan_10.4";
    private static final int START_COLUMN_INDEX = 1;
    private static final int END_COLUMN_INDEX = 5;

    public static void main(final String[] args) throws Exception {

        final Workbook workbook = WorkbookFactory.create(new File(PATH_TO_MATH));
        final Sheet firstSheet = workbook.getSheet(SHEET);
        final ListMultimap<Integer, String> reels = ArrayListMultimap.create();
        for (final Row row : firstSheet) {
            for (int columnIndex = START_COLUMN_INDEX; columnIndex <= END_COLUMN_INDEX; columnIndex++) {
                final Cell cell = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
                try {
                    final String cellValue = cell.getStringCellValue();
                    if (cell.getRowIndex() > 0 && cellValue != null && !cellValue.isEmpty()) {
                        System.out.println("[" + cell.getRowIndex() + ":" + columnIndex + "] : "  + cellValue);
                        reels.put(columnIndex, cellValue.trim().replaceAll("[\\(\\)]", "").replace(" ", "_").toUpperCase());
                    }
                } catch (IllegalStateException ignored) {
                }
            }
        }
        System.out.println();
        for (int columnIndex = START_COLUMN_INDEX; columnIndex <= END_COLUMN_INDEX; columnIndex++) {
            System.out.println(columnIndex + " - length: " + reels.get(columnIndex).size());
        }
        System.out.println();
        for (int columnIndex = START_COLUMN_INDEX; columnIndex <= END_COLUMN_INDEX; columnIndex++) {
            System.out.println("{" + String.join(", ", reels.get(columnIndex)) + "}" + (columnIndex != 5 ? "," : ""));
        }
    }
}
