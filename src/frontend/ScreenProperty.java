package frontend;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
  private ListView menuView;
  @FXML
  private TextArea BillArea;
  @FXML
  private Label dishes;
  @FXML
  private Label number;
  @FXML
  private Label bill;
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
  private Button[] tableAvail = new Button[13];


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
  }

  public void staffManageClicked() {
    observablTextArea.setVisible(true);
  }

  public void TableManage() {
    menuPane.setVisible(true);
    for (int i = 1; i <= 12; i++) {
      tableAvail[i].setVisible(true);
      int set = i;
      tableAvail[i].setOnAction(e -> tableAvail[set].setText("Occupied"));
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
  }

}
