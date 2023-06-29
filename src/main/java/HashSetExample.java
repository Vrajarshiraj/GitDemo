import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample
{
    public static void main(String[] args)
    {
        HashSet hs=new HashSet<String>();
        hs.add("Rohit");
        hs.add("Kohli");
        hs.add("Gill");
        hs.add("Suryakumar");
        hs.add("Rahane");
        hs.add("Jadeja");
        hs.add("Y Jaiswal");
        hs.add(("M S Dhoni"));
        System.out.println(hs);
        System.out.println(hs.remove("M S Dhoni"));
        System.out.println(hs.isEmpty());
        System.out.println(hs.size());

        System.out.println("--------------------");

        Iterator<String> it= hs.iterator();

        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
