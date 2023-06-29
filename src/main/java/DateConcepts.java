import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConcepts
{
    public static void main(String[] args)
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/d/yyyy");
        SimpleDateFormat ssf=new SimpleDateFormat("MM/d/yyyy hh:mm:ss");
        Date date=new Date();
        System.out.println(simpleDateFormat.format(date));
        System.out.println(ssf.format(date));
    }
}
