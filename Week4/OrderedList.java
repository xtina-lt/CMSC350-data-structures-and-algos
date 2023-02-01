import java.util.List;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OrderedList {
    private static List<Polynomial> polynomialExpression = new ArrayList<>();

    public OrderedList(){
        process();
    }

    public static <T extends Comparable<? super T>> boolean getStrongOrder(List<T> list) {
        boolean result = true;
        for (int i = list.size() - 1; i > 0; i--) {
            T current = list.get(i);
            if (!getStrongOrder(list, current)) {
                result = false;
            }
        }
        return result;
    }

    public static <T extends Comparable<? super T>> boolean getStrongOrder(List<T> list, T current) {
        T one = list.get(list.indexOf(current));
        T two = list.get(list.indexOf(current) - 1);

        return (two != null) ?  one.compareTo(two) >=0 : true;
    }

    public static boolean getWeakOrdered(List<Polynomial> list) {
        boolean result = true;
        Polynomial previous = list.get(list.size() - 1);

        for (int i = list.size() - 2; i > 0; i--) {
            if (previous.compareExponents(list.get(i)) < 0) result = false;
        }

        return result;
    }

    public static ArrayList<String> getExpression() {
        ArrayList<String> expression = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        // Show both directories and files
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // use current directory for ease
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                Scanner scannedFile = new Scanner(file);
                if (file.isFile()) {
                    System.out.println("isfile");
                    if (!scannedFile.hasNextLine()){
                        throw new InvalidPolynomialSyntax ("ERRR WRONG!\nNothing in there! :)");
                    }
                    while (scannedFile.hasNextLine()) {
                        String e = scannedFile.nextLine();
                        expression.add(e);
                    }
                }
            } catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Nothing in there :( !");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Gimme a file :) ");
            }
        }

        return expression;
    }

    public static void process() {
        try {
            ArrayList<String> expression = getExpression();
            for (String e : expression) {
                Polynomial p = new Polynomial(e);
                System.out.println(p);
                polynomialExpression.add(p);
            }
        } catch (InvalidPolynomialSyntax e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), e.getMessage());
        }

        System.out.printf("Are we strongly ordered? %s.\n", getStrongOrder(polynomialExpression));
        System.out.printf("Are we weakly ordered?: %s.", getWeakOrdered(polynomialExpression));

    }

}