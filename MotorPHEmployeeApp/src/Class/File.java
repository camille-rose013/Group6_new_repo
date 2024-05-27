/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.*;
import java.util.*;

/**
 *
 * @author 63909
 */
public class File {
    private String fileName;
    private String filePath;
    private ArrayList<String> dataFile = null;
    private BufferedReader reader = null;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> readFile(String filePath){
        this.filePath = filePath ;            
        dataFile = new ArrayList<String>();
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(this.filePath));

            while((line = reader.readLine()) != null){
                //dataFile.add(line);
                dataFile.add(line);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
               reader.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            }    
        }            

        return dataFile;
    }
}
