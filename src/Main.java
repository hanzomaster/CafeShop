import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  /**
   * Nhấn run để chạy chương trình.
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Hàm khởi động.
   */
  public void start(Stage primaryStage) {
    primaryStage.setTitle("CafeShop");
    primaryStage.setResizable(false);
    try {
      Parent root = FXMLLoader
          .load(getClass().getClassLoader().getResource("resources/fxml/Controller.fxml"));
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setOnCloseRequest(arg0 -> {
        Platform.exit();
        System.exit(0);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
