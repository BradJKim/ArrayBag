public class LinkedBagTest {
    public static void main(String[] args){

        /** 
         * Creating linked bags and adding values for testing 
         * First, print out contents of bags
         * Second, print outputs for union, intersection, and difference (both ways)
         */

        LinkedBag<Integer> linkedBag1 = new LinkedBag<>();

        linkedBag1.add(5);
        linkedBag1.add(3);
        linkedBag1.add(8);
        linkedBag1.add(1);
        linkedBag1.add(6);

        Object[] arr1 = linkedBag1.toArray();
        System.out.print("Bag1: ");
        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        LinkedBag<Integer> linkedBag2 = new LinkedBag<>();

        linkedBag2.add(8);
        linkedBag2.add(9);
        linkedBag2.add(2);
        linkedBag2.add(1);
        linkedBag2.add(4);

        Object[] arr2 = linkedBag2.toArray();
        System.out.print("Bag2: ");
        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println();
        
        BagInterface<Integer> union = linkedBag1.union(linkedBag2); 

        BagInterface<Integer> intersection = linkedBag1.intersection(linkedBag2); 

        BagInterface<Integer> difference1 = linkedBag1.difference(linkedBag2); 
        BagInterface<Integer> difference2 = linkedBag2.difference(linkedBag1); 

        Object[] arr = union.toArray();
        System.out.print("Union:\nExpected: 5 3 8 1 6 8 9 2 1 4\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        
        
        arr = intersection.toArray();
        System.out.print("Intersection:\nExpected: 8 1\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        arr = difference1.toArray();
        System.out.print("Difference1:\nExpected: 5 3 6\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        arr = difference2.toArray();
        System.out.print("Difference2:\nExpected: 9 2 4\nOutcome: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
