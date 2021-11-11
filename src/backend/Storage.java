package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Storage {
  private static String url = "src\\resources\\Storage.txt";

  public static String StorageList() {
    String Storage = "";
    try (FileInputStream fileInputStream = new FileInputStream(url);
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(fileInputStream))) {
      String line = bufferedReader.readLine();
      while (line != null) {
        final String similarString = line;
        Storage = Storage + line + "\n";
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Storage;
  }

  public static void storageManagement(String word) {
    /* Write word to file. */
    try (FileWriter fileWriter = new FileWriter(url, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
      bufferedWriter.write(word);
      bufferedWriter.newLine();
      bufferedWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
