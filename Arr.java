/*
    Author: Michael Moschetti
    Reference: https://stackoverflow.com/questions/13991494/resetting-a-nextline-scanner
*/
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

class Arr {
    public static void main(String args[]) {
        try {
            File f = new File("hw3b.txt");
            FileReader fr = new FileReader(f);
            Scanner s = new Scanner(new BufferedReader(fr));
            int count = 0;
            while(s.hasNextDouble()) {
                s.nextDouble();
                count++;
            }
            s.close();
            /*
                Need to reset FileReader and Scanner since buffer empties on nextType() method
                Doing this so the array doesn't have padded values that would affect average, min, & max
            */
            FileReader fr2 = new FileReader(f);
            Scanner n = new Scanner(new BufferedReader(fr2));
            double[] nums = new double[count];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = n.nextDouble();
            }
            n.close();
            
            Arrays.sort(nums);
            double avg = 0;
            double min = nums[0];
            double max = nums[0];
            for (double x : nums) {
                avg += x;
                if(x < min) {
                    min = x;
                } else if (x > max) {
                    max = x;
                }
                System.out.print(x + " ");
            } System.out.println();
            avg /= nums.length;
            System.out.println("Average value is: " + avg);
            System.out.println("Minimum value is: " + min);
            System.out.println("Maximum value is: " + max);
        
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
