package com.amydegregorio.javabasics.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
   private static final String IMAGE_FILE = "coffee.jpg";
   private static final String IMAGE_COPY = "coffeecopy.jpg";
   private static final String TEXT_FILE = "exampleInput.txt";
   private static final String TEXT_COPY = "exampleInputCopy.txt";

   public static void main(String[] args) {
      CopyExample ex = new CopyExample();
      
      try {
         ex.copyBinaryFile();
      } catch (IOException e) {
         System.err.println(String.format("Exception in copyBinaryFile: %s", e.getMessage()));
      }

      System.out.println();
      
      try {
         ex.copyTextFile();
      } catch (IOException e) {
         System.err.println(String.format("Exception in copyTextFile: %s", e.getMessage()));
      }

      System.out.println();
   }
   
   public void copyBinaryFile() throws IOException {
      System.out.println(String.format("Copying Image file %s to %s", IMAGE_FILE, IMAGE_COPY));
      
      try (
         InputStream in = new FileInputStream(IMAGE_FILE);
         OutputStream out = new FileOutputStream(IMAGE_COPY)
         ) {
         
         byte[] data = new byte[16];
         while ((in.read(data)) != -1) {
            out.write(data);
         }
         out.flush();
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Unable to find file: %s", e.getMessage()));
      } catch (IOException e) {
         System.err.println(String.format("Exception reading or writing: %s", e.getMessage()));
      }
   }
   
   public void copyTextFile() throws IOException {
      System.out.println(String.format("Copying Text file %s to %s", TEXT_FILE, TEXT_COPY));
      
      try (
         BufferedReader in = new BufferedReader(new FileReader(TEXT_FILE)); 
         BufferedWriter out = new BufferedWriter(new FileWriter(TEXT_COPY))
         ) {
         String line;
         
         while ((line = in.readLine()) != null) {
            out.write(line);
            out.newLine();
         }
         out.flush();
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Unable to find file: %s", e.getMessage()));
      } catch (IOException e) {
         System.err.println(String.format("Exception reading or writing: %s", e.getMessage()));
      }
   }

}
