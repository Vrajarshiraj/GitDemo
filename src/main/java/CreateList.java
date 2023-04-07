import java.util.ArrayList;
import java.util.List;

public class CreateList
{
    public static void main(String[] args)
    {
        List<String> Suggestions= new ArrayList<String>();

        Suggestions.add("Wrogn");
        Suggestions.add("Fortuner");
        Suggestions.add("Figo");


        for(String car:Suggestions)
        {
            System.out.println(car);
        }
    }
}
