package Towers_of_Hanoi;

public class Iteration {
    class Stack
    {
        int capacity;
        int top;
        int array[];
    }

    Stack createStack(int capacity)
    {
        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.array = new int[capacity];
        return stack;
    }

    // condition when the rod is full
    boolean isFull(Stack stack)
    {
        return (stack.top == stack.capacity - 1);
    }

    // condition when the rod is empty
    boolean isEmpty(Stack stack)
    {
        return (stack.top == -1);
    }

    // to add a disc to rod
    void push(Stack stack, int item)
    {
        if (isFull(stack))
            return;

        stack.array[++stack.top] = item;
    }

    // to remove a disc from rod
    int pop(Stack stack)
    {
        if (isEmpty(stack))
            return Integer.MIN_VALUE;

        return stack.array[stack.top--];
    }

    void moveDisksBetweenTwoPoles(Stack src, Stack dest,
                                  char a, char b)
    {
        int rod1TopDisk = pop(src);
        int rod2TopDisk = pop(dest);

        // when pole 1 is empty
        if (rod1TopDisk == Integer.MIN_VALUE)
        {
            push(src, rod2TopDisk);
            moveDisk(b, a, rod2TopDisk);
        }

        // when pole 2 pole is empty
        else if (rod2TopDisk == Integer.MIN_VALUE)
        {
            push(dest, rod1TopDisk);
            moveDisk(a, b, rod1TopDisk);
        }

        // when top disc of pole 1 > top disk of pole 2
        else if (rod1TopDisk > rod2TopDisk)
        {
            push(src, rod1TopDisk);
            push(src, rod2TopDisk);
            moveDisk(b, a, rod2TopDisk);
        }
        // when top disc of pole 1 < top disk of pole 2
        else
        {
            push(dest, rod2TopDisk);
            push(dest, rod1TopDisk);
            moveDisk(a, b, rod1TopDisk);
        }
    }

    void moveDisk(char start, char finale, int disk)
    {
        System.out.println("Move the disk " + disk +
                " from " + start +
                " to " + finale);
    }

    void tohIterative(int n, Stack
            start, Stack middle, Stack finale)
    {
        int i, total_num_of_moves;
        char a = 'A', b = 'B', c = 'C';

        if (n % 2 == 0)
        {
            char temp = b;
            b = a;
            a  = temp;
        }
        total_num_of_moves = (int)(Math.pow(
                2, n) - 1);


        for(i = n; i >= 1; i--)
            push(start, i);

        for(i = 1; i <= total_num_of_moves; i++)
        {
            if (i % 3 == 1)
                moveDisksBetweenTwoPoles(start, finale, a, b);

            else if (i % 3 == 2)
                moveDisksBetweenTwoPoles(start, middle, a, c);

            else if (i % 3 == 0)
                moveDisksBetweenTwoPoles(middle, finale, c, b);
        }
    }

    public static void main(String[] args)
    {
        int n = 3; // n is the number of disc

        Iteration ob = new Iteration();
        Stack start, finale, middle;

        start = ob.createStack(n);
        finale = ob.createStack(n);
        middle = ob.createStack(n);

        ob.tohIterative(n, start, middle, finale);
    }
}
