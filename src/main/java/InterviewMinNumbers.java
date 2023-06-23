public class InterviewMinNumbers
{
    public static void main(String[] args)
    {
        int[][] b ={{11,112,16},{23,45,66},{35,22,61}};
        int min=b[0][0];
        int max=b[0][0];

        int mincol = 0;

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(b[i][j]<min)
                {
                    min=b[i][j];
                    mincol=j;
                }

                if(b[i][j]>max)
                {
                    max=b[i][j];
                }
            }
        }

        System.out.println("Min Value: "+min);
        System.out.println("Max Value: "+max);
        System.out.println(mincol);

        int k=0;
        int maxfromspeccol=b[0][mincol];

        while (k<3)
        {
            if(b[k][mincol]>maxfromspeccol)
            {
               maxfromspeccol=b[k][mincol];
            }
            k++;
        }
        System.out.println("MAx Value from Column that have lowest value in matrix:"+maxfromspeccol);
    }
}
