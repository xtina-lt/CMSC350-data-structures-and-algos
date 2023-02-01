import java.util.Arrays;

public class Search {
    public static String[] arr0 = new String[]{"Alaska", "Ireland", "Niagra Falls"};
    // public static int arr[] = {5, 10, 15, 20, 25, 30, 35}; 
    public static int arr[] = {5, 10, 35, 25, 20, 15, 30}; 
    public static int key = 30;

    public static void linear(){
        int count = 0;
        for (int e : arr){
            if (e == key) {
                System.out.println("Found #: " + count);
                break;
            }
            count++;
        }
        System.out.println("Time complexity (O)N, where N = " + count);
    }

    public static void binary(){
        int first = 0;
        double result = 0;
        double count = 0;

        //set last to last elements in array
        int last=arr.length-1; 
        //calculate mid of the array
        int mid = (first + last)/2;  

        //while first and last do not overlap
        while( first <= last ){ 
            count++; 
            result = Math.log(count);
            //if the mid < key, then key to be searched is in the first half of array
            if ( arr[mid] < key ){  
                first = mid + 1;     
            }else if ( arr[mid] == key ){ 
                //if key = element at mid, then print the location
                System.out.println("Element is found at index: " + mid);
                break;  
            }else{  
                //the key is to be searched in the second half of the array
                last = mid - 1;  
            }  
            mid = (first + last)/2;  
       }  
       //if first and last overlap, then key is not present in the array
       if ( first > last ){  
          System.out.println("Element is not found!"); 
       }
        // Time complexity
        System.out.printf("Time complexity O( Log(%.0f) ): %.6f", count, result);    
    }

    public static void bubble(){
        // {5, 10, 20, 15, 25, 30, 35} [5]
        // {5, 10, 20, 15, 25, 30, 35} [10]
        // {5, 10, 15, 20, 25, 30, 35} [20] # 20 > 15; SWAP
        // {5, 10, 15, 20, 25, 30, 35} [25] 
        // {5, 10, 15, 20, 25, 30, 35} [30] 
        int count = 0;
        int out, in;
        // backwards loop, decrement
        // start at right
        for (out = arr.length-1; out > 1; out--){
            // nested forward loop, increment
            // start at left
            System.out.printf("Out: %d\n", out);
            for( in = 0; in < out; in++){
                System.out.printf("In: arr[%d] = %d\n", in, arr[in]);
                // if left SIDE element is greater than right SIDE...
                // swap
                if (arr[in] > arr[in+1]){
                    int temp = arr[in];
                    arr[in] = arr[in+1];
                    arr[in+1] = temp;
                }
                count++;
            }
        }

        for (int i : arr) System.out.print(i + ", ");
        System.out.println("\nO(n^2): " + count);
    }

    public static void selection(){
        // {5, 10, 20, 15, 25, 30, 35} [10]
        // {5, 10, 20, 15, 25, 30, 35} [20]
        // {5, 10, 15, 20, 25, 30, 35} [15] # 20 > 15; SWAP, min=[15]
        // {5, 10, 15, 20, 25, 30, 35} [20] 
        // {5, 10, 15, 20, 25, 30, 35} [25] 
        // {5, 10, 15, 20, 25, 30, 35} [30] 
        // {5, 10, 15, 20, 25, 30, 35} [35] 
        int count = 0;
        int in, min;

        for (int out = 0; out < arr.length-1; out++){
            min = out;
            System.out.println("Min => out " + min);
            for(in = out+1; in < arr.length; in++){
                System.out.println("in: " + in);
                if (arr[in] < arr[min]) {
                    System.out.println("Min = in " + min + " : " + in);
                    min = in;
                }
                count++;
            }
            int temp = arr[out];
            arr[out] = arr[min];
            arr[min] = temp;
            
        }

        for (int e : arr) System.out.print(e + ", ");
        System.out.println("\nO(n^2): " + count);
    }

    public static void insertion(){
        for(int k=1; k<arr.length-1; k++)   {  
            int temp = arr[k];  
            int j= k-1;  
            while(j>=0 && temp <= arr[j])   {  
                arr[j+1] = arr[j];   
                j = j-1;  
            }  
            arr[j+1] = temp;  
        } 
        for (int e : arr) System.out.print(e + ", ");  
    }
     


    public static void main(String[] args) {
        insertion();
        // selection();
        // bubble();
        // linear();
        // binary();
    }
}
