package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevenueManagement {

  private static String url = "src\\resources\\revenu.txt";

  public static void insertToRevenue(String word) {
    /* Write word to file. */
    try (FileWriter fileWriter = new FileWriter(url, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
      bufferedWriter.write(word);
      bufferedWriter.newLine();
      bufferedWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String countingLastRevenue() {
    int lastRevenue = 0;
    // Read data from File with BufferedReader.
    try (FileInputStream fileInputStream = new FileInputStream(url);
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(fileInputStream))) {
      String line = bufferedReader.readLine();
      while (line != null) {
        final String similarString = line;
        lastRevenue += Integer.parseInt(similarString);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return String.valueOf(lastRevenue);
  }
}
