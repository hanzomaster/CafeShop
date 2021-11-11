package frontend;


import backend.MenuManagement;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import ManageSources.Fare;
import ManageSources.Menu;
import javafx.beans.value.ChangeListener;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ScreenProperty implements Initializable {

  public AnchorPane menuPane;
  public TextArea observablTextArea;
  public TextField DishesText;
  public TextField numberofPiece;
  public ListView<String> menuView;
  public TextArea BillArea;
  public Label dishes;
  public Label number;
  public Label bill;
  public Label Sumtext;
  public Label sumLabel;
  public Button table1;
  public Button table2;
  public Button table3;
  public Button table4;
  public Button table5;
  public Button table6;
  public Button table7;
  public Button table8;
  public Button table9;
  public Button table10;
  public Button table11;
  public Button table12;
  public Button addButton;
  public Button orderedButton;
  public Button tableAvail[] = new Button[13];
  public static Menu menu;
  public static List<String> menuList = new ArrayList<>();
  private int Revenue = 0;
  private List<Fare> orderedFare = new ArrayList<>();


  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub
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
    MenuManagement.insertFood();


  }

  public void staffManageClicked() {
    observablTextArea.setVisible(true);
    menuPane.setVisible(false);
  }

  public void TableManage() {
    menuPane.setVisible(true);
    for (int i = 1; i <= 12; i++) {
      tableAvail[i].setVisible(true);
      int set = i;
      tableAvail[i].setOnAction(e -> {
        tableAvail[set].setText("Occupied");
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

        for (int j = 1; j <= 12; j++) {
          tableAvail[j].setVisible(false);
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
  }

  public void addButtonClicked() {
    String bills = BillArea.getText();
    String food = DishesText.getText();
    String numberOfFood = numberofPiece.getText();
    if (food != "" && numberOfFood != "" && numberOfFood != "0") {
      for (Fare f : MenuManagement.getFareList()) {
        if (f.getName().equals(food) && (numberOfFood != "0")) {
          f.setNumber(numberOfFood);
          orderedFare.add(f);
          for (Fare tmp : orderedFare) {
            bills = bills + tmp.toString();
            Revenue = Revenue + tmp.getNumber() * tmp.getPrice();
          }
        }
      }
    }
    sumLabel.setText(String.valueOf(Revenue));
    BillArea.setText(bills);
  }
}

