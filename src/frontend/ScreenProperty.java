package frontend;

import backend.EmployeeManagement;
import backend.MenuManagement;
import backend.Ordered;
import backend.RevenueManagement;
import backend.Storage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ManageSources.Fare;

public class ScreenProperty implements Initializable {
  @FXML
  private AnchorPane menuPane;
  @FXML
  private TextArea observablTextArea;
  @FXML
  private TextField DishesText;
  @FXML
  private TextField numberofPiece;
  @FXML
  private ListView<String> menuView;
  @FXML
  private TextArea BillArea;
  @FXML
  private Label dishes;
  @FXML
  private Label number;
  @FXML
  private Label bill;
  @FXML
  private Label Sumtext;
  @FXML
  private Label sumLabel;
  @FXML
  private Button table1;
  @FXML
  private Button table2;
  @FXML
  private Button table3;
  @FXML
  private Button table4;
  @FXML
  private Button table5;
  @FXML
  private Button table6;
  @FXML
  private Button table7;
  @FXML
  private Button table8;
  @FXML
  private Button table9;
  @FXML
  private Button table10;
  @FXML
  private Button table11;
  @FXML
  private Button table12;
  @FXML
  private Button addButton;
  @FXML
  private Button orderedButton;
  @FXML
  public Button[] tableAvail = new Button[13];
  @FXML
  Label lastRevenue;
  @FXML
  Button modifyButton;
  public static List<String> menuList = new ArrayList<>();


  private int revenue = 0;
  private List<Fare> orderedFare = new ArrayList<>();

  /**
   * Khởi tạo bàn ăn.
   */
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    tableAvail[1] = table1;
    tableAvail[2] = table2;
    tableAvail[3] = table3;
    tableAvail[4] = table4;
    tableAvail[5] = table5;
    tableAvail[6] = table6;
    tableAvail[7] = table7;
    tableAvail[8] = table8;
    tableAvail[9] = table9;
    tableAvail[10] = table10;
    tableAvail[11] = table11;
    tableAvail[12] = table12;

    for (int i = 1; i <= 12; i++) {
      tableAvail[i].setVisible(false);
    }

    menuPane.setVisible(false);
    observablTextArea.setVisible(false);
    modifyButton.setVisible(false);
    MenuManagement.insertFood(); // Tạo menu
  }

  /**
   * Hiện thị tất cả nhân viên.
   */
  public void staffManageClicked() {
    observablTextArea.setVisible(true);
    menuPane.setVisible(false);
    observablTextArea.setText(EmployeeManagement.Employee());
    modifyButton.setVisible(true);
    lastRevenue.setVisible(false);
  }

  /**
   * Quản lí bàn ăn.
   */
  public void TableManage() {
    lastRevenue.setVisible(false);
    menuPane.setVisible(true);
    for (int i = 1; i <= 12; i++) {
      tableAvail[i].setVisible(true);
      int set = i;
      tableAvail[i].setOnAction(e -> {
        if (tableAvail[set].getText().equals("FREE")) {
          tableAvail[set].setText("Occupied");
          bill.setText("Hóa đơn bàn " + Integer.toString(set));
          menuView.getItems().addAll(MenuManagement.getStringList());
          menuView.getSelectionModel().selectedItemProperty()
              .addListener((ChangeListener<String>) (arg0, arg1, arg2) -> DishesText
                  .setText(menuView.getSelectionModel().getSelectedItem()));
          DishesText.setVisible(true);
          numberofPiece.setVisible(true);
          addButton.setVisible(true);
          orderedButton.setVisible(true);
          BillArea.setVisible(true);
          menuView.setVisible(true);
          observablTextArea.setVisible(false);
          bill.setVisible(true);
          dishes.setVisible(true);
          number.setVisible(true);
          sumLabel.setVisible(true);
          Sumtext.setVisible(true);
          BillArea.setText("");
          sumLabel.setText("0");
          orderedFare.clear();

          for (int j = 1; j <= 12; j++) {
            tableAvail[j].setVisible(false);
          }
        } else {
          tableAvail[set].setText("FREE");
        }
      });
    }
    DishesText.setVisible(false);
    numberofPiece.setVisible(false);
    addButton.setVisible(false);
    orderedButton.setVisible(false);
    BillArea.setVisible(false);
    menuView.setVisible(false);
    observablTextArea.setVisible(false);
    bill.setVisible(false);
    dishes.setVisible(false);
    number.setVisible(false);
    Sumtext.setVisible(false);
    sumLabel.setVisible(false);
    modifyButton.setVisible(false);
  }

  /**
   * Thêm món ăn vào order.
   */
  public void addButtonClicked() {
    String bills = "";
    revenue = 0;
    String food = DishesText.getText();
    String numberOfFood = numberofPiece.getText();
    if (!food.equals("") && !numberOfFood.equals("")) {
      for (Fare f : MenuManagement.getFareList()) {
        if (f.getName().equals(food)) {
          if (!numberOfFood.equals("0")) {
            f.setNumber(numberOfFood);
            orderedFare.add(f);
          } else {
            orderedFare.remove(f);
          }
        }
      }
    }
    for (Fare tmp : orderedFare) {
      bills += tmp.toString();
      revenue = revenue + tmp.getNumber() * tmp.getPrice();
    }

    sumLabel.setText(String.valueOf(revenue));
    BillArea.setText(bills);
  }

  /**
   * Order đồ ăn.
   */
  public void orderedButtonClicked() {
    RevenueManagement.insertToRevenue(String.valueOf(revenue));
    Ordered.orderedManagement(bill.getText() + "\n" + BillArea.getText() + "\n\n");
    observablTextArea.setVisible(true);
    observablTextArea.setText(Ordered.Ordered());
    menuPane.setVisible(false);
  }

  public void orderManageClicked() {
    observablTextArea.setVisible(true);
    menuPane.setVisible(false);
    observablTextArea.setText(Ordered.Ordered());
    modifyButton.setVisible(true);
    lastRevenue.setVisible(false);
  }

  /**
   * Hiển thị doanh thu.
   */
  public void revenueButtonClicked() {
    menuPane.setVisible(false);
    observablTextArea.setVisible(false);
    lastRevenue.setText("Tổng doanh thu trong ngày: " + RevenueManagement.countingLastRevenue());
    lastRevenue.setTranslateX(300);
    lastRevenue.setTranslateY(150);
    lastRevenue.setVisible(true);

  }

  /**
   * Hiển thị nguyên liệu còn lại trong kho.
   */
  public void storageManageClicked() {
    observablTextArea.setVisible(true);
    menuPane.setVisible(false);
    observablTextArea.setText(Storage.StorageList());
    modifyButton.setVisible(true);
    lastRevenue.setVisible(false);
  }

  /**
   * Hiển thị menu.
   */
  public void menuManageClicked() {
    observablTextArea.setVisible(true);
    menuPane.setVisible(false);
    observablTextArea.setText(MenuManagement.menuList());
    modifyButton.setVisible(true);
    lastRevenue.setVisible(false);
  }

  public void change() {
    if (observablTextArea.getText().contains("Employee")) {
      EmployeeManagement.staffManagement(observablTextArea.getText());
    }
    if (observablTextArea.getText().contains("Storage")) {
      Storage.storageManagement(observablTextArea.getText());
    }
    if (observablTextArea.getText().contains("Menu")) {
      MenuManagement.menuManage(observablTextArea.getText());
    }
    if (observablTextArea.getText().contains("Order")) {
      Ordered.orderManagement(observablTextArea.getText());
    }

  }
}
