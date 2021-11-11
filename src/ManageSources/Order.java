package ManageSources;

import java.util.ArrayList;
import java.util.List;

public class Order {
  private int table;
  private List<Fare> orderList = new ArrayList<>();

  public Order(int table, List<Fare> orderList) {
    this.table = table;
    this.orderList = orderList;
  }

  public int getTable() {
    return table;
  }

  public void setTable(final int position) {
    this.table = position;
  }

  public List<Fare> getOrderList() {
    return orderList;
  }

  public void addOrder(Fare order) {
    orderList.add(order);
  }

  public int getTotalPrice() {
    int totalPrice = 0;
    for (Fare fare : orderList) {
      totalPrice += fare.getPrice();
    }
    return totalPrice;
  }
}
