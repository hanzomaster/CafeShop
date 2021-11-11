package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ManageSources.Fare;
import ManageSources.Menu;

public class MenuManagement {

  private static Menu menu = new Menu();
  private static List<String> menuList = new ArrayList<>();
  private static String url = "src\\resources\\Menu.txt";

  /**
   * Tạo menu đồ ăn từ file txt.
   */
  public static void insertFood() {
    // url file dictionaries.txt
    try (FileInputStream fileInputStream = new FileInputStream(url);
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(fileInputStream))) {
      String line = bufferedReader.readLine();
      int count = 0;
      while (line != null) {
        // Tách từ với nghĩa
        for (int i = 1; i < line.length() && count > 1; i++) {
          if (line.charAt(i) == '\t') { // Các file được ngăn cách bằng tab
            String foodName = line.substring(0, i);
            String priceString = line.substring(i + 1, i + 6);
            int price = Integer.parseInt(priceString); // Chuyển từ String về int
            String type = line.substring(i + 7, line.length());
            Fare fare = new Fare(foodName, price, type);
            menu.addNewMenu(fare);
            menuList.add(foodName);
            break;
          }
        }
        count++;
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Trả về menu.
   */
  public static List<String> getStringList() {
    ArrayList<String> newList = new ArrayList<>(menuList.size());
    for (int i = menuList.size() - 1; i >= 0; i--) {
      newList.add(menuList.get(i));
    }
    return newList;
  }

  public static List<Fare> getFareList() {
    return menu.getList();
  }

  /**
   * Hiện menu lên app.
   */
  public static String menuList() {
    String menu = "";
    try (FileInputStream fileInputStream = new FileInputStream(url);
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(fileInputStream))) {
      String line = bufferedReader.readLine();
      while (line != null) {
        menu += line + "\n";
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return menu;
  }

  /**
   * Thêm khả năng chỉnh sửa menu vào app.
   */
  public static void menuManage(String word) {
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
