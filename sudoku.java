 import java.util.Random;
class sudoku
{
    static int grid[][]=new int[9][9];
    static int l=0;
    static int used[]=new int[9];
    static void clr_grid_row(int m)
    {
        for(int i=0;i<9;i++)
            grid[m][i]=0;
    }
    static void clr_used()
    {
        for(int i=0;i<9;i++)
        {
            used[i]=0;
        }
        l=0;
    }
    static int tried(int k)
    {
        int i;
        for(i=0;i<9;i++)
        {
            if(used[i]==k)
                return 1;
        }
        used[l]=k;
        l++;
        return l;
    }
    static int check_present(int m,int n,int k)
    {
        int i,j;
        for(j=0;j<9;j++)//Check row
        {
            if(grid[m][j]==k)
                return 1;
        }
        for(i=0;i<9;i++)//Check column
        {
            if(grid[i][n]==k)
                return 1;
        }
        return 0;
    }
    static void grid_print()
    {
        int i,j;
        System.out.print(" --- --- --- --- --- --- --- --- --- ");
        for(i=0;i<9;i++)
        {
            System.out.print("\n|");
            for(j=0;j<9;j++)
            {
                System.out.format("%3d|",grid[i][j]);
            }
            System.out.print("\n --- --- --- --- ---  --- --- --- ---");
        }
    }
    public static void main(String args[])
    {
        Random rand = new Random();
        int i,j,k,m,flag;
        for(i=0;i<9;i++)
        {
            loop_j:for(j=0;j<9;j++)
            {
                k=rand.nextInt(9) + 1;
                tried(k);
                flag=0;
                if(l==9)
                {
                    //System.out.print(k+"Invalid \n");
                    clr_used();
                    clr_grid_row(i);
                    //grid_print();
                    i--;
                    break loop_j;
                }
                if(check_present(i,j,k)==1)
                {
                    flag=1;
                }
                if(flag!=1)
                {
                    grid[i][j]=k;
                    clr_used();
                    //System.out.print(grid[i][j]+" ");
                }
                else
                    j--;
            }
        }
        grid_print();
    }
}