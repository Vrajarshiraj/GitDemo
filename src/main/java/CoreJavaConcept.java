public class CoreJavaConcept
{
    public static void main(String args[])
    {
        int MyNum=5;
        String myString="String is Non-Primitive Data Type";
        char letter='v';
        double doub=7.9;
        boolean flagvar=true;

//        System.out.println(MyNum+":This is Integer");
//        System.out.println(myString);

        int[] array1={1,2,3,4,5};

        for(int i=0;i<array1.length;i++)
        {
            System.out.println(array1[i]);
        }

        String[] name={"Dhoni","Virat","Rohit"};

        for(String s:name)
        {
            System.out.print(s +"\n");
        }
    }
}
