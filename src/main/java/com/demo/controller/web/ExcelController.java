package com.demo.controller.web;

import com.demo.excel.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("excel")
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @GetMapping("create")
    @ResponseBody
    public String create() {
        try {
            excelService.createExcelFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
