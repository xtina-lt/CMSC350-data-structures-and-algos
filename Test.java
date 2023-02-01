import java.io.*;
class Test {
    static String getString() throws IOException{
        System.out.println("String: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    static char getChar() throws IOException{
        return getString().charAt(0);
    }

    static int getInt() throws IOException{
        return Integer.parseInt( getString() );
    }

    static Double getDouble() throws IOException{
        return Double.valueOf( getString() );
    }

    public static void main(String[] args) throws IOException {
        Mammal test = new Mammal("Peanut");
        test.getInfo();
        test.play();
        test.getInfo();

        // ARRAYS:
    }
}
