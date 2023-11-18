public interface BagInterface<T>{
    
    /**
     * Gets current number of entries in the bag
     * @return The integer number of entries in the bag
     */
    public int getCurrentSize();

    /**
     * Adds a new Entry to the bag
     * @return true if entry was able to be added, false if not
     */
    public boolean add(T newEntry);

    /**
     * Removes an entry from the bag if possible
     * @return entry that was removed or null
     */
    public T remove();

    /**
     * Removes an entry from the bag if possible
     * @return true or false if entry was found and removed
     */
    public boolean remove(T anEntry);

    public void clear();

    public int getFrequencyOf(T anEntry);

    public boolean contains(T anEntry);

    public T[] toArray();

    /**
     * Combines data items from two bags and returns new bag containing both data items
     * @param bag second bag to be combine data items with 
     * @return new baginterface with data items from both bags
     */
    public BagInterface<T> union(BagInterface<T> bag);

    /**
     * Compares data items from two bags and returns new bag containing itersecting items
     * @param bag second bag to be used to compare data items with 
     * @return new baginterface with data items that intersect/present in both bags
     */
    public BagInterface<T> intersection(BagInterface<T> bag);

    /**
     * Compares data items from two bags and returns new bag containing difference in items based on first bag
     * @param bag second bag to be used to compare data items with 
     * @return new baginterface with data items that are present in frist bag, but not present in second bag
     */
    public BagInterface<T> difference(BagInterface<T> bag);

}