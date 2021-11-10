public class Fare {

  public enum Type {
    CAFE, DESSERT, DRINK, SMOOTHIE
  }

  private String name;
  private int price;
  private Type type;

  public Fare(String name, int price, Type type) {
    this.name = name;
    this.price = price;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(final int price) {
    this.price = price;
  }

  public String getType() {
    return type.name();
  }

  public void setType(final String type) {
    this.type = Type.valueOf(type);
  }
}
