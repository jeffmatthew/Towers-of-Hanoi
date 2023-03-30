package Towers_of_Hanoi;

public class Recursion {
    static void TowerofHanoi(int n, char leftrod, char thirdrod, char middlerod)
    {
        if (n == 1) // if there is only 1 disk
        {
            System.out.println("Move disk 1 from rod " +  leftrod + " to rod " + thirdrod);
            return;
        }
        TowerofHanoi(n-1, leftrod, middlerod, thirdrod);
        System.out.println("Move disk " + n + " from rod " +  leftrod + " to rod " + thirdrod);
        TowerofHanoi(n-1, middlerod, thirdrod, leftrod);
    }

    public static void main(String args[])
    {
        int n = 3;  // n is the number of disk
        TowerofHanoi(n,'A','C', 'B');
    }

}
