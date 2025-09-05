package fr.univamu.progav.cours9;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IntListReader {

  public static List<Integer> readV1(String file) throws IOException {
    Scanner scanner = new Scanner(Path.of(file));
    List<Integer> ints = new ArrayList<>();
    try {
      while (scanner.hasNext()) {
        ints.add(scanner.nextInt());
      }
    } catch (InputMismatchException exc) {
      System.out.println("Wrong input at " + ints.size());
    } finally {
      scanner.close();
    }
    return ints;
  }

  public static List<Integer> readV2(String file) throws IOException {
    List<Integer> ints = new ArrayList<>();
    try (Scanner scanner = new Scanner(Path.of("data.txt"))) {
      while (scanner.hasNext()) {
        ints.add(scanner.nextInt());
      }
    } catch (InputMismatchException exc) {
      System.out.println("Wrong input at " +  ints.size());
    }
    return ints;
  }


  public static void analyzeFile(String filename) {
    List<Integer> valid = null;
    System.out.println("File:" + filename);
    try {
      valid = readV1(filename);
      valid.forEach(System.out::println);
    } catch (IOException e) {
      System.out.println("Unable to open file");
    }
  }

  public static void main(String[] args) {
    analyzeFile("src/main/resources/validInts.txt");
    analyzeFile("src/main/resources/invalidInts.txt");
  }

}
