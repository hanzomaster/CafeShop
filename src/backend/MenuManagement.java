package backend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ManageSources.Fare;
import ManageSources.Menu;

public class MenuManagement {

    private static Menu menu = new Menu();
    private static List<String> menuList = new ArrayList<>();

    public static void insertFood() {
        // url file dictionaries.txt
        String url = "src\\resources\\menu.txt";
        // Read data from File with BufferedReader.
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            int count = 0;
            while (line != null) {
                // Separte word and explain.
                for (int i = 1; i < line.length() && count != 0; i++) {

                    if (line.charAt(i) == '\t') {
                        String foodName = line.substring(0, i);
                        String priceString = line.substring(i + 1, i + 6);
                        int price = Integer.parseInt(priceString);
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
        } finally {
            // Đóng file.
            try {
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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

}


