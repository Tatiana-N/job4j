package ru.job4j.filestream;

import java.io.File;
import java.io.FileOutputStream;

public class ResultFile {
  private String fileName;

  public static void main(String[] args) {
    ResultFile resultFile = new ResultFile("C:/Tanusha/BOOKS/java/task/result.txt");
    for (int i = 0; i < 10; i++) {
      if (i != 0) {
        resultFile.writeInFile("\t" + i);
      } else {
        resultFile.writeInFile("\t");
      }
      for (int j = 1; j < 10; j++) {
        String multiply = " \t" + i * j;
        if (i == 0) {
          resultFile.writeInFile("\t" + j);
        } else {
          resultFile.writeInFile(multiply);
        }
      }
      resultFile.writeInFile("\n\n");
    }
  }

  public ResultFile(String fileName) {
    this.fileName = fileName;

  }

  public void writeInFile(String s) {
    File file = new File(fileName);
    try (FileOutputStream out = new FileOutputStream(file, true)) {
      out.write(s.getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}