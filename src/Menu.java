import java.util.ArrayList;
import java.util.List;

public class Menu {
  private List<Fare> menuList = new ArrayList<>();

  public List<Fare> getList() {
    return menuList;
  }

  public void addNewMenu(Fare fare) {
    menuList.add(fare);
  }

  public void deleteFare(String name) {
    menuList.removeIf(fare -> fare.getName().equals(name));
  }

  public void clearMenu() {
    menuList.clear();
  }
}
