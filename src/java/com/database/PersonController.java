/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;


@Named
@ViewScoped
public class PersonController implements Serializable{

    @EJB
    private PersonFacadeLocal personFacade;
    private Person person;
    private UploadedFile file;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    @PostConstruct
    public void init(){
        person = new Person();
    }
    
    public void upload(FileUploadEvent event) {
        System.out.println("Good");
        this.file = event.getFile();
        if(file.getSize()>0){
            System.out.println("Size Good ");  
            try { 
                InputStream input = file.getInputStream();
                XSSFWorkbook lib = new XSSFWorkbook(input);
                Sheet sheet = lib.getSheetAt(0);
                Iterator<Row> iterator = sheet.iterator();
                int i=0;
                while (iterator.hasNext()) {
                    Row next = iterator.next(); 
                    if(i>0){
                        if(next.getCell(0)!=null &&
                               next.getCell(1)!=null &&
                               next.getCell(2)!=null &&
                               next.getCell(3)!=null){ 
                            person.setName(next.getCell(1).getStringCellValue());
                            person.setEmail(next.getCell(2).getStringCellValue());
                            person.setPhone(next.getCell(3).getStringCellValue());
                            
                            personFacade.create(person);
                            System.out.println("Bravooo !!! ");
                        }
                        else {
                            System.out.println("Sorry ... ");
                        }
                    }
                    i++;
                    
                }
                
            } catch (Exception e) {
                System.err.println(e);
            }
            
        }
        
    }
    
    
}
