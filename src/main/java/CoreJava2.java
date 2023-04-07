import java.util.ArrayList;

public class CoreJava2
{
    public static void main(String args[])
    {
        int arr2[]={1,2,3,4,5,6,7};

        for(int i=0;i<arr2.length;i++)
        {
            if(arr2[i]%2==0)
            {
                System.out.println(arr2[i]);
            }
            else
            {
                System.out.println(arr2[i]+" is not multiple of 2");
            }
        }

        ArrayList<String> arr=new ArrayList<String>();
        arr.add("Ronaldo");
        arr.add("Messi");
        arr.add("Neymar");
        System.out.println(arr.get(1));
    }
}
