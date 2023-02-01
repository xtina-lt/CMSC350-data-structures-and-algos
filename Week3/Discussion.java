import java.util.*;

class Discussion{
    public static void main(String[] args) {
        ArrayList<String> vacations = new ArrayList<>(Arrays.asList("Alaska", "Ireland", "Main", "Niagra Falls"));
        System.out.println(vacations.toString());
        System.out.println( "Niagra Falls is at index: " + vacations.indexOf("Niagra Falls") );
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10,3,8,5,9));
        System.out.println(nums.toString());
        System.out.println( "The integer 9 is at index: " + nums.indexOf(9) );
    }
}