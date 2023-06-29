import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarObject
{
    public CalendarObject()
    {
        System.out.println("Constructor is Created.");
    }
    public static void main(String[] args)
    {

        Date date=new Date();

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("d/M/yyyy hh:mm:ss");

        System.out.println(cal.getTime());

        System.out.println(sdf.format(date));
    }
}
