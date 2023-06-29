
import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args)
    {
        ArrayList<String> a=new ArrayList<String>();
        a.add("Manoj");
        a.add("Chirag");
        System.out.println(a);
        a.add(0,"Vrajarshi");
        System.out.println(a);
        a.remove("Vrajarshi");
        System.out.println(a);
        System.out.println(a.get(0));

        System.out.println(a.contains("Manoj"));

        System.out.println(a.indexOf("Chirag"));

        //Checking size
        System.out.println(a.isEmpty());
        System.out.println(a.size());
    }
}
