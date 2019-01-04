package com.amydegregorio.javabasics.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamsExample {
   private static final String FILE_NAME = "exampleInput.txt";

   public static void main(String[] args) {
      InputStreamsExample ex = new InputStreamsExample();
      
      try {
         ex.useFileInputStream();
      } catch (IOException e) {
         System.err.println(String.format("Exception in useFileInputStream: %s", e.getMessage()));
      }
      
      System.out.println();
      
      try {
         ex.useFileReader();
      } catch (IOException e) {
         System.err.println(String.format("Exception in useFileReader: %s", e.getMessage()));
      }
      
      System.out.println();
      
      try {
         ex.useBufferedReader();
      } catch (IOException e) {
         System.err.println(String.format("Exception in useBufferedReader: %s", e.getMessage()));
      }
      
      System.out.println();

      System.exit(0);
   }
   
   public void useFileInputStream() throws IOException {
      System.out.println(String.format("Reading file %s using a FileInputStream", FILE_NAME));
      InputStream is = null;
      try {
         is = new FileInputStream(FILE_NAME);
         int input;
         String output = "";
         
         while ((input = is.read()) != -1) {
            output += (char) input;
         }
         System.out.println(output);
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Exception creating FileInputStream for file %s: %s", FILE_NAME, e.getMessage()));
      } finally {
         if (is != null) {
            is.close();
         }
      }
   }
   
   public void useFileReader() throws IOException {
      System.out.println(String.format("Reading file %s using a FileReader", FILE_NAME));
      InputStreamReader reader = null;
      try {
         reader = new FileReader(FILE_NAME);
         int input;
         String output = "";
         
         while ((input = reader.read()) != -1) {
            output += (char) input;
         }
         System.out.println(output);
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Exception creating FileReader for file %s: %s", FILE_NAME, e.getMessage()));
      } finally {
         if (reader != null) {
            reader.close();
         }
      }
   }
   
   public void useBufferedReader() throws IOException {
      System.out.println(String.format("Reading file %s using a BufferedReader", FILE_NAME));
      try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
         String line;
         
         while ((line = reader.readLine()) != null) {
            System.out.println(line);
         }
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Exception creating BufferedReader for file %s: %s", FILE_NAME, e.getMessage()));
      }
   }

}
