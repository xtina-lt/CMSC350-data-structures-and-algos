import java.util.*;
import java.util.stream.Stream;

public class Expression {
    static Double result = 0.0;
    static String[] tokens;

    public Expression(){

    }

    public static void test(){
        ArrayList<String> ops = new ArrayList<String>(Arrays.asList("*", "/", "+", "-"));
        // System.out.println("Expression please: ");
        // Scanner scan = new Scanner(System.in);
        // String e = scan.nextLine();
        String e = "12+3";
        String[] s;

        for (int i=0; i < e.length()-1; i++){
            Character x = e.charAt(i);
            Character y = e.charAt(i+1);
            System.out.println(y);
            if (Character.isDigit(y) && (!ops.contains( String.valueOf(y) )) ) {
                System.out.println("found one");
            }
        
        }
        
    }
    public static void main(String[] args) {
        test();
    }
}
