public class childclassdemo extends ParentClassDemo {

    public void engine()
    {
        System.out.println("Engine code is Implemented");
    }

    public static void main(String[] args)
    {
        ParentClassDemo obj=new childclassdemo();
        obj.Break();
        obj.gear();
    }
}
