package com.amydegregorio.javabasics.fileio;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStreamsExample {
   private static final String STREAM_OUTPUT_FILE = "streamOutput.txt";
   private static final String WRITER_OUTPUT_FILE = "writerOutput.txt";
   private static final String BUFFERED_OUTPUT_FILE = "bufferedOutput.txt";
   
   private static final String OUTPUT_TEXT = 
            "This is my example text.\nI'ts not terribly long or exciting";

   public static void main(String[] args) {
      OutputStreamsExample ex = new OutputStreamsExample();
      try {
         ex.useFileOutputStream();
      } catch (IOException e) {
         System.err.println(String.format("Exception in useFileOutputStream: %s", e.getMessage()));
      }
      
      System.out.println();
      
      try {
         ex.useFileWriter();
      } catch (IOException e) {
         System.err.println(String.format("Exception in useFileWriter: %s", e.getMessage()));
      }
      
      System.out.println();
      
      try {
         ex.useBufferedWriter();
      } catch (IOException e) {
         System.err.println(String.format("Exception in useBufferedWriter: %s", e.getMessage()));
      }
      
      System.out.println();

   }
   
   public void useFileOutputStream() throws IOException {
      System.out.println(String.format("Writing file %s using a FileOutputStream", STREAM_OUTPUT_FILE));
      
      try (FileOutputStream out = new FileOutputStream(STREAM_OUTPUT_FILE);){
         byte[] data = OUTPUT_TEXT.getBytes();
         out.write(data);
         out.flush();
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Exception creating FileOutputStream for file %s: %s", STREAM_OUTPUT_FILE, e.getMessage()));
      } catch (IOException e) {
         System.err.println(String.format("Exception writing to file %s: %s", STREAM_OUTPUT_FILE, e.getMessage()));
      }
   }
   
   public void useFileWriter() throws IOException {
      System.out.println(String.format("Writing file %s using a FileWriter", WRITER_OUTPUT_FILE));
      
      try (FileWriter out = new FileWriter(WRITER_OUTPUT_FILE)) {
         out.write(OUTPUT_TEXT);
         out.flush();
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Exception creating FileWriter for file %s: %s", WRITER_OUTPUT_FILE, e.getMessage()));
      } catch (IOException e) {
         System.err.println(String.format("Exception writing to file %s: %s", WRITER_OUTPUT_FILE, e.getMessage()));
      }
   }
   
   public void useBufferedWriter() throws IOException {
      System.out.println(String.format("Writing file %s using a BufferedWriter", BUFFERED_OUTPUT_FILE));
      BufferedWriter out = null;
      String[] lines = {"This is my first line of text", "This is the second line", "And this is the third line"};
      
      try {
         out = new BufferedWriter(new FileWriter(BUFFERED_OUTPUT_FILE));
         for (String line : lines) {
            out.write(line);
            out.newLine();
         }
         out.flush();
      } catch (FileNotFoundException e) {
         System.err.println(String.format("Exception creating FileWriter for file %s: %s", BUFFERED_OUTPUT_FILE, e.getMessage()));
      } catch (IOException e) {
         System.err.println(String.format("Exception writing to file %s: %s", BUFFERED_OUTPUT_FILE, e.getMessage()));
      } finally {
         if (out != null) {
            out.close();
         }
      }
   }

}
