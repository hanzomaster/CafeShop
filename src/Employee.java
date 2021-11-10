public class Employee {
  public enum Position {
    SERVE, BARTENDING, MANAGER
  }

  private String name;
  private int age;
  private Position position;

  public Employee(String name, int age, Position position) {
    this.name = name;
    this.age = age;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public String getPosition() {
    return position.name();
  }

  public void setPosition(final String position) {
    this.position = Position.valueOf(position);
  }
}
