import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.Date;

public class Main {
  public static void main (String[] args) {
    Calendar cal1 = new GregorianCalendar(1901, 0, 1);

    int sunday_number=0;
    while (cal1.get(Calendar.YEAR) != 2001){
      if (isSunday(cal1)) {
        //System.out.println(cal1.get(Calendar.DAY_OF_MONTH) + "/" + cal1.get(Calendar.MONTH) + "/" + cal1.get(Calendar.YEAR) + " is a " + getDay(cal1));
        sunday_number++;
      }
      cal1 = incMonth(cal1);
    }
    System.out.println("Number of Sundays " + sunday_number);
  }

  private static Calendar incMonth(Calendar cal) {
    if (cal.get(Calendar.MONTH) == Calendar.DECEMBER) {
      cal.set(Calendar.MONTH, Calendar.JANUARY);
      cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)+1);
    }
    else
      cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
    return cal;
  }

  private static void print(Calendar cal) {
      System.out.println("Year: "  + cal.get(Calendar.YEAR));
      System.out.println("Month: " + (cal.get(Calendar.MONTH)));
      System.out.println("Days: "  + cal.get(Calendar.DAY_OF_MONTH));
      System.out.println("Day: "   + getDay(cal));
  }

  private static String getDay(Calendar cal) {
    String day = "";
    switch (cal.get(Calendar.DAY_OF_WEEK)) {
      case Calendar.SUNDAY    : day="Sunday"    ; break;
      case Calendar.MONDAY    : day="Monday"    ; break;
      case Calendar.TUESDAY   : day="Tuesday"   ; break;
      case Calendar.WEDNESDAY : day="Wednesday" ; break;
      case Calendar.THURSDAY  : day="Thursday"  ; break;
      case Calendar.FRIDAY    : day="Friday"    ; break;
      case Calendar.SATURDAY  : day="Saturday"  ; break;
    }
    return day;
  }

  private static boolean isSunday(Calendar cal) {
    return (getDay(cal) == "Sunday") ? true : false;
  }
}
