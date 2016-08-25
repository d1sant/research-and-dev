package com.my.research.and.dev.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeightsExtractor {

    private static final String PATH_TO_MATH = "/Users/dmitry.palaznik/American Dad-math-94.14%_v1.2_PT.xlsx";
    private static final String SHEET = "Re-spin Francine Main math";
    private static final int START_COLUMN_INDEX = 1;
    private static final int END_COLUMN_INDEX = 4;
    private static final int CELL_VALUE_MULTIPLIER = 1000;
    private static final int FIRST_ROW_INDEX = 14;
    private static final int LAST_ROW_INDEX = 20;

    public static void main(final String[] args) throws Exception {

        final Workbook workbook = WorkbookFactory.create(new File(PATH_TO_MATH));
        final Sheet firstSheet = workbook.getSheet(SHEET);
        final List<Integer> weights = new ArrayList<>();
        for (int rowIndex = FIRST_ROW_INDEX; rowIndex < LAST_ROW_INDEX; rowIndex++) {
            final Row row = firstSheet.getRow(rowIndex);
            for (int columnIndex = START_COLUMN_INDEX; columnIndex <= END_COLUMN_INDEX; columnIndex++) {
                final Cell cell = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
                final Double cellValue = cell.getNumericCellValue();
                System.out.println("[" + cell.getRowIndex() + ":" + columnIndex + "] : " + cellValue);
                final Double multipliedValue = cellValue * CELL_VALUE_MULTIPLIER;
                weights.add(multipliedValue.intValue());
            }
        }
        System.out.println();
        System.out.println("{" + getStickyWildsAsString(weights) + "}");
    }

    private static String getStickyWildsAsString(final List<Integer> weights) {
        return weights.stream().map(Object::toString).map(s -> s + "d").collect(Collectors.joining(", "));
    }
}
