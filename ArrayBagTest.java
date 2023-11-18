public class ArrayBagTest{
    public static void main(String[] args){

        /** 
         * Creating resizeable arraybags and adding values for testing 
         * First, print out contents of bags
         * Second, print outputs for union, intersection, and difference (both ways)
         */

        ResizeableArrayBag<Integer> arrayBag1 = new ResizeableArrayBag<>();

        arrayBag1.add(5);
        arrayBag1.add(7);
        arrayBag1.add(2);
        arrayBag1.add(9);
        arrayBag1.add(1);

        ResizeableArrayBag<Integer> arrayBag2 = new ResizeableArrayBag<>();

        arrayBag2.add(9);
        arrayBag2.add(7);
        arrayBag2.add(3);
        arrayBag2.add(1);
        arrayBag2.add(4);

        Object[] arr1 = arrayBag1.toArray();
        System.out.print("Bag2: ");
        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        Object[] arr2 = arrayBag2.toArray();
        System.out.print("Bag2: ");
        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println();

        BagInterface<Integer> union = arrayBag1.union(arrayBag2);

        BagInterface<Integer> intersection = arrayBag1.intersection(arrayBag2);

        BagInterface<Integer> difference1 = arrayBag1.difference(arrayBag2);
        BagInterface<Integer> difference2 = arrayBag2.difference(arrayBag1);

        Object[] arr = union.toArray();
        System.out.print("Union:\nExpected: 5 7 2 9 1 9 7 3 1 4\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        
        
        arr = intersection.toArray();
        System.out.print("Intersection:\nExpected: 7 9 1\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        arr = difference1.toArray();
        System.out.print("Difference1:\nExpected: 5 2\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        arr = difference2.toArray();
        System.out.print("Difference2:\nExpected: 3 4\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }


    }
}