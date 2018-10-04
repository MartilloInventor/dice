package edu.desktop.CodingProblem;

import java.util.List;
import java.util.ArrayList;
import java.lang.String;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    private static int target_min(int val, int cur) {
        if(val == cur)
            return 0;
        if((val+cur) == 7)
            return 2;
        return 1;
    }

    private static int solution(int[] A) {
        int total;
        int current_minimum = -1;

        for(int target = 1; target <= 6; ++target) {
            System.out.println("Target Pips: " + target);
            total = 0;
            for(int i: A) {
                total += target_min(target, i);
            }
            System.out.println("Number of moves: " + total);
            if(current_minimum == -1 ) {
                current_minimum = total;
            } else if(total < current_minimum) {
                current_minimum = total;
            }
        }
        return current_minimum;
    }

    public static void main(String args[]) {

        List<Character> initial_configuration = new ArrayList<>();
        int [] initial_ints;
        int initial_length;
        int minimum;

        //<String> list_of_substring_lists = new HashSet<String>();

        if (args.length == 0) {
            System.err.print( "Program must have args.\n" );
            System.exit( -1 );
        }

        for (String tmp : args) {
            initial_configuration.add( tmp.charAt( 0 ) );
        }
        initial_length = initial_configuration.size();
        initial_ints = new int[initial_length];
        for(int index = 0; index < initial_length; ++index) {
            initial_ints[index] = Character.getNumericValue( initial_configuration.get(index) );
        }
        minimum = solution(initial_ints);
        System.out.println("Minimum number of moves is " + minimum);
    }
}