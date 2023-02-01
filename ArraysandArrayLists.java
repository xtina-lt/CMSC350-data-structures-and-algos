import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ArraysandArrayLists {
    public static void main(String[] args) {
        /* ARRAYS
        * size cannot be mutated
        */
        // CREATE
        String[] arr = {"Alaska", "Ireland", "Niagra Falls"};
        // UPDATE
        // shift left
        for (int i=1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = "Alaska";
        // READ
        // for (Object e : arr) { System.out.println( e.toString() ); }


        /* ARRAY LIST
        * The ArrayList class has a regular array inside it. 
        * When an element is added, it is placed into the array. 
        * If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.
        */
        // ArrayList<Object> arrList = new ArrayList<>( Arrays.asList("Alaska", "Canda") );
        // INITIALIZE
        ArrayList<Object> arrList = new ArrayList<Object>();

        // METHODS
        arrList.add("Canada");
        arrList.set(0, "Alaska");
        arrList.remove( arrList.size()-1 );
        arrList.clear();

        for (Object e : arr) {arrList.add(e);}
        // LOOP
        // for (Object e : arrList) System.out.println( e.toString() );

        

        /* How the LinkedList works
        * The LinkedList stores its items in "containers." 
        * The list has a link to the first container and each container has a link to the next container in the list. 
        * To add an element to the list, the element is placed into a new container 
        * and that container is linked to one of the other containers in the list. */
        LinkedList<String> linkedL = new LinkedList<String>();
        for (Object e : arr) {linkedL.add( e.toString() );}
        // addFirst()	Adds an item to the beginning of the list.	
        // addLast()	Add an item to the end of the list	
        // removeFirst()	Remove an item from the beginning of the list.	
        // removeLast()	Remove an item from the end of the list	
        // getFirst()	Get the item at the beginning of the list	
        // getLast()	Get the item at the end of the list


    }

}
