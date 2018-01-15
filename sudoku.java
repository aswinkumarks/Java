import java.util.*;
class sudoku
{
    static int grid[][]=new int[9][9];
    static int ques[][]=new int[9][9];
    //static LinkedList number = new LinkedList();
    static int l=0,q=0;
    static int used[]=new int[9];
    static int removed[]=new int[20];
   /* static void ins_ele()
    {
        for(int i=1;i<10;i++)
            number.add(i);
        q=9;
    }*/
    static void create_questions()
    {
        int x,y,flag,r=0;
        Random rand = new Random();
        while(r<15)
        {
            flag=0;
            x=rand.nextInt(9);
            y=rand.nextInt(9);
            for(int i=0;i<20;i++)
            {
                if(removed[i]==(x*10)+y)
                {
                    flag=1;break;
                }
            }
            if(flag!=1)
            {
                removed[r]=(x*10)+y;
                //System.out.print(r+" ");
                r++;ques[x][y]=grid[x][y];
            }
        }
    }
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
        int i,j,b_m,b_n;
        for(j=0;j<n;j++)//Check row
        {
            if(grid[m][j]==k)
                return 1;
        }
        for(i=0;i<m;i++)//Check column
        {
            if(grid[i][n]==k)
                return 1;
        }
        b_m=m/3;b_n=n/3;
        for(i=b_m*3;i<(b_m*3)+3;i++)//Check sub-square
        {
            for(j=b_n*3;j<(b_n*3)+3;j++)
            {
                if(grid[i][j]==k)
                    return 1;
            }
        }
        return 0;
    }
    static void grid_print(int grid[][])
    {
        int i,j;
        System.out.print(" --- --- --- --- --- --- --- --- --- ");
        for(i=0;i<9;i++)
        {
            System.out.print("\n|");
            for(j=0;j<9;j++)
            {
                if(grid[i][j]==0)
                    System.out.print("   |");
                else
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
            //ins_ele();
            for(j=0;j<9;j++)
            {
                k=rand.nextInt(9)+1;
                //k=(int)number.get(m);
                tried(k);
                flag=0;
                if(l==9)
                {
                    clr_used();
                    System.out.println("Hailkndf");
                    clr_grid_row(i);
                    i--;
                    break;
                }
                flag=check_present(i,j,k);
                if(flag!=1)
                {
                    grid[i][j]=k;
                    //grid_print(grid);
                    //number.remove(m);q--;
                    clr_used();
                }
                else
                    j--;
            }
        }
        grid_print(grid);
        System.out.println("");
        create_questions();
        grid_print(ques);
    }
}