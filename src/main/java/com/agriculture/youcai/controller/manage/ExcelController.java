package com.agriculture.youcai.controller.manage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/manage/excel")
public class ExcelController {

    @GetMapping("/pricelist/export")
    public ResponseEntity<byte[]> pricelistExport(
            @RequestParam String guestId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date pdate
    ) throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("abc");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "workbook.xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        wb.write(outByteStream);
        return new ResponseEntity<byte[]>(outByteStream.toByteArray(), headers, HttpStatus.OK);
    }

}
