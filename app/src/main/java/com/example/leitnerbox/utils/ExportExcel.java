package com.example.leitnerbox.utils;

import android.os.Environment;

import com.example.leitnerbox.database.Card;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class ExportExcel {

    private static final String Folder_NAME = "/LeitenerBox";
    private  String FILE_NAME = "cards.xlsx";
    File root = Environment.getExternalStorageDirectory();
    List<Card> cardList;

    public void ExportExcel(List<Card> cardLis,String GroupName) {

        this.cardList = cardList;
        this.FILE_NAME = GroupName;

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Card");

        fackeData();

        if (cardList != null) {

            int rowNum = 0;
            for (Card card : cardList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(card.getFront());
                row.createCell(1).setCellValue(card.getBack());

            }
        }
        writeFile(workbook);
    }

    private void fackeData() {

        Card card = new Card();
        card.setFront("hi");
        card.setBack("hi");

        Card card1 = new Card();
        card1.setFront("by");
        card1.setBack("by");

        cardList.add(card);
        cardList.add(card1);
    }

    private void writeFile(XSSFWorkbook workbook) {

        String outFileName = FILE_NAME;

        File dir = new File(root.getAbsolutePath() + Folder_NAME);
        if (!dir.exists()) {
            dir.mkdirs(); // build directory
        }

        //build file
        File excelFile = new File(dir, outFileName);

        // Write the output to a file
        try {
            OutputStream outputStream = new FileOutputStream(excelFile);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


