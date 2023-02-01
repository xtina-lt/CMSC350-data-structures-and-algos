public class Arry {
    String arr[];
    // Object objArray[];
    // Collection[] collectionArray;
    public Arry(String[] e){
        // String[] quotes = {"Hello", "You're", "Awesome"};
        // char charArr[] = new char[]{ 'A', 'B', 'C' };
        arr = new String[5];
        arr = e;
    }
    @Override
    public String toString(){
        String result = "";
        for (String i : arr) result+=(String.format("'%s', ", i));
        return result;
    }
    void read(){
        // LOOP THROUGH
        // for (int i=0; i<arr.length; i++){
        //     System.out.println(arr[i]);
        // }
        // or
        String result = "";
        for (String i : arr) result+=(String.format("'%s', ", i));
        System.out.println(result);
    }
    void update(int i, String str) { arr[i] = str; }
    void delete(String str){
        for (int i=1; i<arr.length; i++){
            if (arr[i-1] == str){
                arr[i-1] = arr[i];
            }
        }
    }
    public static void main(String[] args) {
        Arry test = new Arry(new String[]{"Alaska", "Ireland", null});
        test.toString(); // [I@4617c264
        test.read();
        test.update(test.arr.length-1, "Niagra Falls");
        test.read();
        test.delete("Ireland");
        test.read();
    }

}

