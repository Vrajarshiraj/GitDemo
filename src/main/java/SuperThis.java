public class SuperThis
{
   String College ="Sigma";

   public void classify(int RollNo,String Name)
   {
       System.out.println(RollNo+" "+Name+" "+College);
   }


    public static void main(String[] args)
    {
        SuperThis id1=new SuperThis();
        id1.classify(1,"Harsh");
        SuperThis id2=new SuperThis();
        id2.classify(2,"Kevin");
    }
}
