import java.util.Arrays;

public class Table {
  private boolean[] tables = new boolean[12];

  public Table() {
    Arrays.fill(tables, false);
  }

  public void taken(int position) {
    tables[position] = true;
  }

  public boolean[] getTable() {
    return tables;
  }

  public boolean getTableAt(int position) {
    return tables[position];
  }

  public void away(int position) {
    tables[position] = false;
  }
}
