package ManageSources;

public class Fare {


  private String name;
  private int price;
  private String type;
  private int number;

  public Fare(String name, int price, String type) {
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
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = Integer.parseInt(number);
  }

  public String toString() {
    return name + "\t" + price + "\t" + type + "\t\t" + number + "\n";
  }
}
