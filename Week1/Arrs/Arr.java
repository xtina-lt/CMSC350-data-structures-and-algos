package Arrs;

public class Arr{
    // define a reference to an array
    // // int[] arr = new int[100]
    int[] arr; 
    int[] auto;

    public Arr(){
        // creates new array
        // sets reference to arr
        arr = new int[10];
        // numbers within the curly brackets 
        // are called the INITIALIZATION LIST.
        int[] a = {0, 3, 6, 9, 12, 15, 18, 21, 24, 27};
        auto = a;

        this.setNums();
    }

    // ACCESSORS
    public int getLength(){
        return arr.length;
    }
    public int getElement(int num){
        return arr[num];
    }
    public int getIndex(int num){
        int found = -1;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == num) found=i;
        }
        return found;
    }
    public void printAll(){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public void printAutoGen(){
        for(int i=0; i<auto.length; i++){
            System.out.println(auto[i]);
        }
    }
    // LINEAR SEARCH:
    // iterate though one element at a time
    // runtime complexity: O(n)
    // - slow for large data sets
    // + fast for s-m data sets
    // + doesn't need to be storted
    // + useful for data structures that do not 
    //      have random access structrues (linked list)
    public int linearSearch(int num){
        int found = -1;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == num) found=i;
        }
        return found;
    }
    // BINARY SEARCH:
    // opening in the middle
    // runtime complexity: O(log n)
    // + faster
    // - only works on sorted arrays
    public int binarySearch(int target){
        int found = -1;
        int start  = 0;
        int end = arr.length-1;
        while (start <= end){
        // when start = 9 and 9=9 => we are at the end
            int mid  = start + (end - start) / 2;
            // calculate the mid point
            // 0 + (9-0) /  2
            // 0 +   9   /  2
            // 0 +       4
            //           4
            System.out.printf("Start: %d\nMid: %d\nEnd: %d\n\n", start, mid, end);
            if (arr[mid] == target) {
                found = mid;
                break;
            } else if (arr[mid] > target){
                // if mid is greater -> target < mid
                // would like to only search left side
                // meaning that we will cut out the whole right side
                end = mid-1;
                // end is left index
            } else {
                // mid is less -> mid < target
                // only search right side
                // cut out the whole left side
                start = mid + 1;
                // start is right index
            }
        }
        return found;
    }

    // MUTATORS
    public int[] setNums(){
        this.arr[0] = 0;                 // insert 10 items
        this.arr[1] = 1;
        this.arr[2] = 2;
        this.arr[3] = 3;
        this.arr[4] = 4;
        this.arr[5] = 5;
        this.arr[6] = 6;
        this.arr[7] = 7;
        this.arr[8] = 8;
        this.arr[9] = 9;
        return this.arr;
    }
    public int setIndexElement(int i, int num){
        return this.arr[i] = num;
    }

    public static void main(String[] args) {
        Arr test = new Arr();
        System.out.println( test.binarySearch(20) );
        
    }
}