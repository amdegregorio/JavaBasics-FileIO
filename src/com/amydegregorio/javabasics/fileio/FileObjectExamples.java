package com.amydegregorio.javabasics.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileObjectExamples {
   private static final String FILE_NAME = "exampleInput.txt";

   public static void main(String[] args) {
      FileObjectExamples ex = new FileObjectExamples();
      try {
         ex.usingFile();
      } catch (IOException e) {
         System.err.println(String.format("Exception in usingFile: %s", e.getMessage()));
      }
   }
   
   public void usingFile() throws IOException {
      File exampleInput = new File(FILE_NAME);
      
      System.out.println(String.format("Does it exist? %b", exampleInput.exists()));
      System.out.println(String.format("Is it a directory? %b", exampleInput.isDirectory()));
      System.out.println(String.format("Is it a file? %b", exampleInput.isFile()));
      System.out.println(String.format("Can the app read it? %b", exampleInput.canRead()));
      System.out.println(String.format("Absolute Path: %s", exampleInput.getAbsolutePath()));
      System.out.println(String.format("Path: %s", exampleInput.getPath()));
      
      FileReader reader = null;
      BufferedWriter out = null;
      try {
         reader = new FileReader(exampleInput);
         out = new BufferedWriter(new FileWriter(exampleInput));
      } finally {
         if (reader !=null) reader.close();
         if (out != null) out.close();
      }
   }

}
