public class ExceptionsDemo
{
    public void add(int a,int b)
    {

        try
        {
            int c=a/b;
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Finally Block : Delete Cookies");
        }
    }

    public static void main(String[] args)
    {
        ExceptionsDemo obj=new ExceptionsDemo();
        obj.add(5,0);
    }
}
