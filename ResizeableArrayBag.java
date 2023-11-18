import java.util.Arrays;

public class ResizeableArrayBag<T> implements BagInterface<T>{
    private T[] bag; // cannot be final, allows for doubling / size readjust
    private static final int DEFAULT_CAPACITY = 30;
    private int numberOfEntries;

    /**
     * default ArrayBag constructor, sets size to DEFAULT_CAPACITY and numberOfEntries to 0,
     * creates new bag
     */
    public ResizeableArrayBag(){
        numberOfEntries =0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[DEFAULT_CAPACITY];
        bag = tempBag;
    }

    /**
     * ArrayBag constructor with capaity parameter, sets size to capacity and numberOfEntries to 0,
     * creates new bag
     * @param capacity maximum size of the arraybag
     */
    public ResizeableArrayBag(int capacity){
        numberOfEntries =0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }

    /**
     * Adds a new entry to the bag
     * @param new date entry for bag
     * @return true to show that item was properly added
     */
    public boolean add(T newEntry){
        boolean result = true;
        if(isFull()){
            resize();
        }
            bag[numberOfEntries++] = newEntry; // make sure the ++ works
        return result;
    }

    /**
     * Removes the last object in the bag
     * @return true or false
     */
    public T remove(){
        if(isEmpty()){
            return null;
        }
        T temp = bag[numberOfEntries - 1];
        bag[--numberOfEntries] = null;  // check --
        return temp;
    }

    /**
     * Removes a specific object in the bag
     * @param entry to be removed
     * @return true if item was removed, false if no itmes are in the bag
     * or the item to be removed was not found
     */
    public boolean remove(T anEntry){
        if(isEmpty()){
            return false;
        }
        else{
            for(int i=0; i<numberOfEntries;i++){
                if(bag[i].equals(anEntry)){
                    bag[i] = bag[numberOfEntries - 1];
                    remove();
                    return true;
                }
            }
            return false;
        }
    }

    public int getCurrentSize(){
        return numberOfEntries;
    }

    public void clear(){
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T anEntry){
        int count =0;

        for(int i=0; i<numberOfEntries; i++){
            if(bag[i] == anEntry){
                count++;
            }
        }
        return count;
    }

    public boolean contains(T anEntry){
        for(int i=0; i<numberOfEntries; i++){
            if(bag[i] == anEntry){
                return true;
            }
        }
        return false;
    }

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[numberOfEntries];

        for(int i=0; i<numberOfEntries;i++){
            tempArray[i] = bag[i];
        }
        return tempArray;
    }

    /**
     * Combines data items from two bags and returns new bag containing both data items
     * @param bag second bag to be combine data items with 
     * @return new ResizeableArrayBag with data items from both bags
     */
    public BagInterface<T> union(BagInterface<T> bag){
        ResizeableArrayBag<T> newBag = new ResizeableArrayBag<T>(); 

        T[] arr1 = this.toArray();
        T[] arr2 = bag.toArray();

        for(int i=0; i<arr1.length; i++){
            newBag.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            newBag.add(arr2[i]);
        }

        return newBag;
    }

    /**
     * Compares data items from two bags and returns new bag containing itersecting items
     * @param bag second bag to be used to compare data items with 
     * @return new ResizeableArrayBag with data items that intersect/present in both bags
     */
    public BagInterface<T> intersection(BagInterface<T> bag){
        ResizeableArrayBag<T> newBag = new ResizeableArrayBag<T>(); 

        T[] arr1 = this.toArray();
        T[] arr2 = bag.toArray();

        for(int i=0; i<arr1.length; i++){
            for(int j =0; j<arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    newBag.add(arr1[i]);
                    arr2[j] = null;
                    break;
                }
            }
        }

        return newBag;
    }
    
    /**
     * Compares data items from two bags and returns new bag containing difference in items based on first bag
     * @param bag second bag to be used to compare data items with 
     * @return new ResizeableArrayBag with data items that are present in frist bag, but not present in second bag
     */
    public BagInterface<T> difference(BagInterface<T> bag){
        ResizeableArrayBag<T> newBag = new ResizeableArrayBag<T>(); 

        T[] arr1 = this.toArray();
        T[] arr2 = bag.toArray();

        for(int i=0; i<arr2.length; i++){
            for(int j=0; j<arr1.length; j++){
                if(arr1[j] == arr2[i]){
                    arr1[j] = null;
                }
            }
        }
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != null){ 
                newBag.add(arr1[i]);
            }
        }

        return newBag;
    }

    private void resize(){
        bag = Arrays.copyOf(bag, 2 * bag.length);
    }

    private boolean isFull(){
        return numberOfEntries == bag.length;
    }

    private boolean isEmpty(){
        return numberOfEntries == 0;
    }


}
