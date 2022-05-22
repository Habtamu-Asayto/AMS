/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.file.UploadedFile;


@Named
@ViewScoped
public class ProductsController implements Serializable{

    @EJB
    private ProductsFacadeLocal productsFacade;
    private Products products;
    private UploadedFile file;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    @PostConstruct
    public void init() {
        products = new Products();
    }
    
    public void upload(){
        Date date = new Date();
        if(file.getSize()>0){
           System.out.println("Size : "+file.getSize());
            try { 
                InputStream input = file.getInputStream();
                XSSFWorkbook lib = new XSSFWorkbook(input);
                Sheet sheet = lib.getSheetAt(0);
                Iterator<Row> iterator = sheet.iterator();
                int i=0;
                while (iterator.hasNext()) {
                    Row next = iterator.next(); 
                    if(i>0){  
                        if(next.getCell(0)==null &&
                               next.getCell(1)!=null &&
                               next.getCell(2)!=null &&
                               next.getCell(3)!=null &&
                               next.getCell(4)!=null
                                ){ 
                            products.setName(next.getCell(1).getStringCellValue()); 
                            date = next.getCell(2).getDateCellValue();
                            products.setProdate(date);
                            products.setPrice((int) next.getCell(3).getNumericCellValue());
                            products.setBarcode((int) next.getCell(4).getNumericCellValue());
                            productsFacade.create(products);
                            System.out.println("Bravooo !!! ");
                        }
                        else {
                            System.out.println("Sorry ... ");
                        } 
                    }
                    i++;
                    
                }
                //lib.close();
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        else {
            System.out.println("Empty File");
        }
    }
    
    
    public void exportDb() throws IOException, InterruptedException {
    Runtime rt = Runtime.getRuntime();
    Process p;
    ProcessBuilder pb;
    rt = Runtime.getRuntime();
    pb = new ProcessBuilder(
            "/usr/bin/pg_dump",
            "--host", "localhost",
            "--port", "5432",
            "--username", "jims",
            "jims",
            "--format", "custom",
            "--blobs",
            "--verbose", "--file", "/home/habtamu/Documents/AttorneyFolder/service_station_backup.backup", "service_station");
    try {
        final Map<String, String> env = pb.environment();
        env.put("PGPASSWORD", "root");
        p = pb.start();
        final BufferedReader r = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String line = r.readLine();
        while (line != null) {
            System.err.println(line);
            line = r.readLine();
        }
        r.close();
        p.waitFor();
        System.out.println(p.exitValue());

    } catch (IOException | InterruptedException e) {
        System.out.println(e.getMessage());
    }
}
    
}
