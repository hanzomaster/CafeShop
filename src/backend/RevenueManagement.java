package backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RevenueManagement {

  /**
   * Thống kê doanh thu vào file.
   */
  public static void insertWordtoHistory(String word) {
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
}
