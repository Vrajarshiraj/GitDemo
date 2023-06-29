import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample
{
    public static void main(String[] args)
    {
        HashMap<Integer,String> hm=new HashMap<Integer, String>();
        hm.put(101,"Chirag");
        hm.put(102,"Manoj");
        hm.put(103,"Vrajarshi");

        System.out.println(hm);
        System.out.println(hm.remove(102));
        System.out.println(hm.get(102));

        Set st=hm.entrySet();
        Iterator it=st.iterator();

        while (it.hasNext())
        {
            System.out.println(it.next());
            Map.Entry mp=(Map.Entry)it.next();
            System.out.println(mp.getKey()+":"+mp.getValue());
        }
    }
}
