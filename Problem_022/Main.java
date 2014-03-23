import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

import java.nio.charset.Charset;

import java.util.List;
import java.util.ArrayList;

public class Main {

  private static final String FILE_PATH = "names.txt";

  private static List<String> nameList;
  private static int totalScore = 0;

  public static void main (String[] args) {
    parseFile();
    sortList();
    computeScores();
    System.out.println("Total of all the name scores: " + totalScore);
  }

  private static void parseFile() {
    try{
      FileInputStream fis = new FileInputStream(FILE_PATH);
      BufferedReader br   = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
      nameList            = new ArrayList<String>();

      String line;
      while ((line = br.readLine()) != null) {
        nameList.add(line);
      }

      br.close();
    }
    catch(FileNotFoundException e) {
      System.err.println(e.getMessage());
    }
    catch(Exception e) {
      System.err.println(e.getMessage());
    }
  }

  private static void sortList() {
    java.util.Collections.sort(nameList);
  }

  private static void computeScores() {
    int index = 1;
    int score;
    for (String name : nameList) {
      score = 0;

      for (int i=0; i<name.length(); i++)
        score += charScrore(name.charAt(i));

      //System.out.println("Name: " + name + " score: " + score + " index: " + index);
      totalScore += score * index;
      index++;
    }
  }

  private static int charScrore(char c) {
    return Character.getNumericValue(c) - 9;
  }
}
