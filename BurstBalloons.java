/* There are some spherical balloons taped onto a flat wall that represents the XY-plane... The balloons are represented as a 2D integer array points where points[i] = [start, end] denotes a balloon whose horizontal diameter stretches between start and end... You do not know the exact y-coordinates of the balloons... Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis... A balloon with start and end is burst by an arrow shot at x if start <= x <= end... There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path... Given the array points, return the minimum number of arrows that must be shot to burst all balloons...
 * Eg 1: Input = [[10, 16], [1, 6], [2, 8], [7, 12]]        Arrows = 2
 * Eg 2: Input = [[1, 2], [2, 3], [3, 4], [4, 5]]           Arrows = 2
 * Eg 3: Input = [[1, 2], [3, 4], [4, 5], [5, 6]]           Arrows = 4
 */
import java.util.*;
public class BurstBalloons
{
    public int[][] SelectionSort(int[][] array)     // Time Complexity - 0(n^2) time...
    {
        for(int i = 0; i < array[0].length; i++)    // Method to get length of 2d array...
        {
            int min = array[0][i];
            for(int j = 0; j < array[0].length; j++)
            {
                if(min < array[0][j])    // Sorting using Selection Sort... O(n^2) time...
                {
                    int temp1 = min;     // Sorting the first row...
                    min = array[0][j];
                    array[0][i] = array[0][j];
                    array[0][j] = temp1;
                    temp1 = array[1][i];   // Simultaneously sorting the second row...
                    array[1][i] = array[1][j];
                    array[1][j] = temp1;
                }
            }
        }
        return array;
    }
    public int MinimumArrows(int array[][])    // Time Complexity - O(n) time...
    {
        int arrows = 1, i = 0;         // Initializing...
        int arrow_index = array[1][0];    // First shot at the end of first balloon...
        System.out.print("The Arrows are shot at : "+arrow_index+", ");
        do
        {
            if(arrow_index < array[0][i])
            {   // If the end and start of two balloons do not coincide...
                arrow_index = array[1][i];     // Another arrow shot at the end of the next balloon...
                System.out.print(arrow_index+", ");
                arrows++;
            }   // If the domains are coinciding then we can hit them with a single array...
            i++;
        }while(i < array[0].length);   // Till the last balloon...
        System.out.println();
        return arrows;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, a, p;
        System.out.print("Enter the number of Balloons over the wall : ");
        x = sc.nextInt();
        BurstBalloons burstballoons = new BurstBalloons();    // Object creation...
        int balloons[][] = new int[2][x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter "+(i+1)+" Balloon start : ");
            a = sc.nextInt();
            System.out.print("Enter "+(i+1)+" Balloon end : ");
            p = sc.nextInt();
            balloons[0][i] = a;
            balloons[1][i] = p;
        }
        System.out.println("Balloon Array formed !!");
        for(int i = 0; i < x; i++)
            System.out.print("["+balloons[0][i]+","+balloons[1][i]+"] ,");
        System.out.println();
        burstballoons.SelectionSort(balloons);   // Function call...
        for(int i = 0; i < x; i++)
            System.out.print("["+balloons[0][i]+","+balloons[1][i]+"] ,");
        System.out.println();
        System.out.println("The Minimum arrows shot are : "+burstballoons.MinimumArrows(balloons));
        sc.close();
    }
}

// Time Complexity  - O(n^2) time...
// Space Complexity - O(1) space...
// Optimal Time Complexity - O(nlogn) time...
// Optimal Space Complexity - O(1)space...

/* DEDUCTIONS :-
 * 1. The Balloons are placed on a flat surface (wall) such that if they are overlapping a single arrow will pierce through all overlapping balloons...
 * 2. Since the domain is from start to end, we will shoot at arrows at end and not at middle...
 * 3. If the end and start of two balloons is overlapping, they will burst by the same arrow...
 */