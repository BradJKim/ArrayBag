public class LinkedBag<T> implements BagInterface<T> {
    
    private int numberOfEntries;
    private Node firstNode; 

    public LinkedBag(){
        firstNode =null;
        numberOfEntries =0;
    }

    public boolean add(T entry){
        Node newNode = new Node(entry);

        if(firstNode == null){
            firstNode = newNode;
        }
        else{
            newNode.setNext(firstNode);
            firstNode = newNode;
        }
        numberOfEntries++;
            return true;
    }

    public T remove(){
        if(firstNode == null){
            return null;
        }
        else{
            Node tempNode = firstNode;
            firstNode = firstNode.getNext();
            numberOfEntries--;
            return tempNode.getData();
        }
    }

    public boolean remove(T entry){
        if(firstNode == null){
            return false;
        }

        Node reference = this.getReferenceTo(entry);
        
        if(reference == null){
            return false;
        }
        else{
            reference.setData(firstNode.getData());
            firstNode = firstNode.getNext();
            numberOfEntries--;
            return true;
        }
    }

    public Node getReferenceTo(T entry){
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && currentNode != null){
            if(currentNode.getData().equals(entry)){
                found = true;
            }
            else{
                currentNode = currentNode.getNext();
            }
        }

        return currentNode;
    }

    public void clear(){
        numberOfEntries =0;
        firstNode = null;
    }

    public int getFrequencyOf(T anEntry){
        int count =0;
        Node currentNode = firstNode;

        while(currentNode != null){
            if(currentNode.getData().equals(anEntry)){
                count++;
            }
        }
        return count;
    }

    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode =  firstNode;

        while(!found && currentNode != null){
            if(currentNode.getData().equals(anEntry)){
                found = true;
            }
            else{
                currentNode = currentNode.getNext();
            }
        }

        return found;
    }

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[numberOfEntries];
        Node currentNode =  firstNode;

        if(currentNode != null){
            for(int i=0; i<numberOfEntries; i++){
                array[i] = currentNode.getData();
                currentNode = currentNode.getNext();
            }
        }
        return array;
    }

    public int getCurrentSize(){
        return numberOfEntries;
    }

    /**
     * Combines data items from two bags and returns new bag containing both data items
     * @param bag second bag to be combine data items with 
     * @return new linkedbag with data items from both bags
     */
    public BagInterface<T> union(BagInterface<T> bag){
        LinkedBag<T> newBag = new LinkedBag<T>();
        
        T[] tempArr1 = bag.toArray();
        T[] tempArr2 = this.toArray();

        for(int i=0; i<tempArr1.length; i++){
            newBag.add(tempArr1[i]);
        }
        for(int i=0; i<tempArr2.length; i++){
            newBag.add(tempArr2[i]);
        }

        return newBag;
    }

     /**
     * Compares data items from two bags and returns new bag containing itersecting items
     * @param bag second bag to be used to compare data items with 
     * @return new linkedbag with data items that intersect/present in both bags
     */
    public BagInterface<T> intersection(BagInterface<T> bag){
        LinkedBag<T> newBag = new LinkedBag<T>();
        
        T[] tempArr1 = this.toArray();
        T[] tempArr2 = bag.toArray();

        for(int i=0; i<tempArr1.length; i++){
            for(int j=0; j<tempArr2.length; j++){
                if(tempArr1[i] == tempArr2[j]){
                   newBag.add(tempArr1[i]);
                   tempArr2[j] = null;
                   break; 
                }
            }
        }
        
        return newBag;
    }

    /**
     * Compares data items from two bags and returns new bag containing difference in items based on first bag
     * @param bag second bag to be used to compare data items with 
     * @return new linkedbag with data items that are present in frist bag, but not present in second bag
     */
    public BagInterface<T> difference(BagInterface<T> bag){
        LinkedBag<T> newBag = new LinkedBag<T>();

        T[] tempArr1 = this.toArray();
        T[] tempArr2 = bag.toArray();

        for(int i=0; i<tempArr2.length; i++){
            for(int j=0; j<tempArr1.length; j++){
                if(tempArr1[j] == tempArr2[i]){
                    tempArr1[j] = null;
                }
            }
        }

        for(int i=0; i<tempArr1.length; i++){
            if(tempArr1[i] != null){ 
                newBag.add(tempArr1[i]);
            }
        }

        return newBag;
    }


    private class Node{
        private T data;
        private Node next;

        private Node(){
            data = null;
            next = null;
        }

        private Node(T entry){
            data = entry;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data){
            this.data = data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }
}