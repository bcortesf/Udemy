package com.company.springboot3di.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.springboot3di.models.Invoice;

@Component
public class InvoiceData {/*FACTURA */
    private List<Invoice> dataList;


    public InvoiceData() {
        this.dataList = new ArrayList<>();
    }


    public List<Invoice> getDataList() {
        return dataList;
    }
    public void setDataList(List<Invoice> list) {
        this.dataList = list;
    }


    public void add(Invoice bill) {
        this.dataList.add(bill);
    }

    @Override
    public String toString() {
        return "BillData [dataList=" + dataList + "]";
    }

}