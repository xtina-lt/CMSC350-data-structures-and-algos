package Discussion;
import java.util.ArrayList;

public class LogN {
    int x;
    int f;
    int g;

    public LogN(int x, int f, int g){
        this.x = x;
        this.f = f;
        this.g = g;
    }

    public void display(){
        System.out.printf("%d\t%d\t%d\n", x, f, g );
    }

    static int fOfX(int x){
        return (int) ( Math.pow(x, 5) + 5*x + 3000 ); 
    }

    static int gOfX(int x){
        return (int) ( Math.pow(x, 5) );
    }

    static ArrayList<LogN> calculate(){
        ArrayList<LogN> arrList = new ArrayList<>();
        int tempF=1;
        int tempG=0;
        int count = 10;

        while ( tempF > tempG ){
            tempF = fOfX(count);
            tempG = gOfX(count);
            arrList.add( new LogN(count, tempF, tempG) );
            count += 10;
        }

        return arrList;
    }

    static void show(ArrayList<LogN> arrayList){
        LogN last = arrayList.get(arrayList.size()-1);
        for (LogN e : arrayList) {
            e.display();
        }

        // show execution
        System.out.println("The faster growing function became larger at:");
        last.display();
    }
    public static void main(String[] args) {
        System.out.println("Calculating........");
        ArrayList<LogN> results = calculate();
        System.out.println("n\tf(n)\tg(n)");
        show(results);
    }
}
