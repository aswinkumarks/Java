import java.util.*;
import java.awt.event.KeyEvent;
class test
{
    public static void main(String args[]) 
    {
        LinkedList number = new LinkedList();
        for(int i=10;i<20;i++)
            number.add(i);
        for(int i=9;i>0;i--)
        {

            System.out.print(number.remove(i)+" ");
        }         
    }
}