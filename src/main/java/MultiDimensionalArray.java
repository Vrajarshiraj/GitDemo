public class MultiDimensionalArray
{
    public static void main(String[] args)
    {
        int a[][]=new int[2][3];
        a[0][0]=2;
        a[0][1]=4;
        a[0][2]=3;
        a[1][0]=7;
        a[1][1]=9;
        a[1][2]=11;

        int b[][]={{2,4,5},{3,4,6},{5,2,1}};

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(b[i][j]+" ");
            }
            System.out.print("\n");
        }


    }
}
