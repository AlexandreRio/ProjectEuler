public class Main {

  static private String triangle =
    "75<br>" +
    "95 64<br>" +
    "17 47 82<br>" +
    "18 35 87 10<br>" +
    "20 04 82 47 65<br>" +
    "19 01 23 75 03 34<br>" +
    "88 02 77 73 07 63 67<br>" +
    "99 65 04 28 06 16 70 92<br>" +
    "41 41 26 56 83 40 80 70 33<br>" +
    "41 48 72 33 47 32 37 16 94 29<br>" +
    "53 71 44 65 25 43 91 52 97 51 14<br>" +
    "70 11 33 28 77 73 17 78 39 68 17 57<br>" +
    "91 71 52 38 17 14 91 43 58 50 27 29 48<br>" +
    "63 66 04 68 89 53 67 30 73 16 69 87 40 31<br>" +
    "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

  static private String[][] cells;
  static private int number_rows;
  static private String maximum_path;
  static private int maximum_sum = -1;

  public static void main (String[] args) {
    String[] rows      = triangle.split("<br>");
    number_rows    = rows.length;
    int number_columns = rows[number_rows-1].split(" ").length;

    cells   = new String[number_rows][number_columns];

    String[] cur_cells;
    for (int i=0; i<number_rows; i++) {
      cur_cells = rows[i].split(" ");

      for (int j=0; j<cur_cells.length; j++)
        cells[i][j] = cur_cells[j];
    }

    move(0,0, "", 0);
    System.out.println("Path: " + maximum_path + " Sum:" + maximum_sum);
  }

  private static void move(int row, int column, String path, int sum) {
    if (column <= row && row < number_rows) {
      path += cells[row][column];
      sum  += Integer.valueOf(cells[row][column]).intValue();
      move(row+1, column, path, sum);
      move(row+1, column+1, path, sum);
    }
    else
      if (sum > maximum_sum) {
        maximum_sum  = sum;
        maximum_path = path;
      }
  }
}
