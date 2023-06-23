public class Array
{
    public static void main(String[] args)
    {
        int ab[]= new int[5]; // Declare an Array and Allocate the Memory
        ab[1]=5;
        ab[0]=2;
        ab[2]=3;
        ab[3]=4;
        ab[4]=7;

        for(int i=0;i<ab.length;i++)
        {
            System.out.println(ab[i]);
        }
        System.out.println("next");

        int a[]={1,2,3};

        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }

        //Multi Dimensional Array

    }

}
