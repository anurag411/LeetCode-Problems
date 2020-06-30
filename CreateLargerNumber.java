import java.util.*;

public class CreateLargerNumber {

    static void printLargest(List<String> arr){
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String X, String Y) {
                String XY=X + Y;
                String YX=Y + X;
                return XY.compareTo(YX) > 0 ? -1:1;
            }
        });

        Iterator it = arr.iterator();
        while(it.hasNext())
            System.out.print(it.next());
    }

    public static void main (String[] args) {

        List<String> arr;
        arr = new ArrayList<>();
        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }
}
