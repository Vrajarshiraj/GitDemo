import java.util.ArrayList;

public class PrintUniqueStrings
{
    public static void main(String[] args)
    {
        Integer[] text={1,2,3,3,5,1,7,6,5,2,7,9,8,18};

        ArrayList<Integer> al=new ArrayList<>();


        for(int i=0;i<text.length;i++)
        {
            int k=0;
            if(!al.contains(text[i]))
            {
                al.add(text[i]);
                k++;

                for(int j=i+1;j<text.length;j++)
                {
                    if(text[i] == text[j])
                    {
                        k++;
                    }
                }
                System.out.println(text[i]+"\n"+"Repeated times:"+k);
            }
             if(k==1)
             {
                 System.out.println(text[i]);
             }
        }

        System.out.println(al);

    }
}
