package com.example.leitnerbox.utils;

import android.os.Environment;

import com.example.leitnerbox.database.Card;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportExcel {

    String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Backup/";

    public void ExportExcel(List<Card> cardList) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Card");

        if (cardList != null) {

            int rowNum = 0;
            for (Card card : cardList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(card.getFront());
                row.createCell(1).setCellValue(card.getBack());

            }
        }

        // Write the output to a file
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("card.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


