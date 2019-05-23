package com.example.leitnerbox.utils;

import android.os.Environment;
import android.util.Log;

import com.example.leitnerbox.AppController;
import com.example.leitnerbox.database.Card;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import io.objectbox.BoxStore;

public class ImportExcel {

    public static final String SAMPLE_XLSX_FILE_PATH = Environment.getExternalStorageDirectory() + "/Leitner/cards.xlsx";
    public static final String TAG = ImportExcel.class.getSimpleName();

    public static void ImportExcel() {

        try {

            Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {
                for(Cell cell: row) {

                    String cellValue = cell.getStringCellValue();

                    Log.i(TAG, "ImportExcel: " + cellValue.toString()+"\n");
                }
            }


            workbook.close();




        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


    }

}
