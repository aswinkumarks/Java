import java.util.*;
import java.awt.event.KeyEvent;
class test
{
    static void keyTyped() {
        KeyEvent event;
        /*if (event.getKeyChar() == KEY_LEFT) {
            cTDirection = LEFT;
        }
        if (event.getKeyChar() == 40) {
            cTDirection = DOWN;
        }
        if (event.getKeyChar() == 39) {
            cTDirection = RIGHT;
        }*/
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            System.out.print("Hai");
        }
    }
    public static void main(String args[]) 
    {
        int k;
        Random rand = new Random();
        char input;
        Scanner s=new Scanner(System.in);
        //input=s. next(). charAt(0);
        //System.out.print(input+" ");
        keyTyped();
    }
}