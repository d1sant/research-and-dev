package com.my.research.and.dev.excel;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.Collection;
import java.util.stream.Collectors;

public class ConnectedWildsExtractor {

    private static final String PATH_TO_MATH = "/Users/dmitry.palaznik/American Dad-math-94.14%_v1.2_PT.xlsx";
    private static final String SHEET = "FG Steve Trail_of_10_Wild";
    private static final int START_COLUMN_INDEX = 15;
    private static final int END_COLUMN_INDEX = 24;
    private static final int FIRST_ROW_INDEX = 9;
    private static final int LAST_ROW_INDEX = 109;

    public static void main(String[] args) throws Exception {
        final Workbook workbook = WorkbookFactory.create(new File(PATH_TO_MATH));
        final Sheet firstSheet = workbook.getSheet(SHEET);
        final ListMultimap<Integer, Integer> wildScenarious = ArrayListMultimap.create();
        for (int rowIndex = FIRST_ROW_INDEX; rowIndex < LAST_ROW_INDEX; rowIndex++) {
            final Row row = firstSheet.getRow(rowIndex);
            for (int columnIndex = START_COLUMN_INDEX; columnIndex <= END_COLUMN_INDEX; columnIndex++) {
                final Cell cell = row.getCell(columnIndex, Row.CREATE_NULL_AS_BLANK);
                final Double cellValue = cell.getNumericCellValue();
                System.out.println("[" + cell.getRowIndex() + ":" + columnIndex + "] : " + cellValue);
                wildScenarious.put(rowIndex - FIRST_ROW_INDEX, cellValue.intValue());
            }
        }
        System.out.println();
        System.out.println("Scenarious size: " + wildScenarious.asMap().size());
        System.out.println();
        for (final Collection<Integer> wilds : wildScenarious.asMap().values()) {
            System.out.println("{" + String.join(", ", getWildsAsString(wilds) + "}," ));
        }
    }

    private static String getWildsAsString(final Collection<Integer> wilds) {
        return wilds.stream().map(i -> i - 1).map(Object::toString).collect(Collectors.joining(", "));
    }
}
