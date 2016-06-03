package chapter03;

/**
 * Created by ghufran on 6/2/16.
 */
public class DoubleLinkedList<T> {
    
    private class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private T data;
        
        public Node(Node<T> p,
             Node<T> n,
             T d){
            previous = p;
            next = n;
            data = d;
        }
        
        public Node<T> getPrevious() { return previous; }
        public Node<T> getNext() { return next; }
        public T getData() { return data; }
        
        public void setPrevious(Node<T> p) { previous = p; }
        public void setNext(Node<T> n) { next = n; }
        public void setData(T d) { data = d; }
        
    }
    
    // comparison between my version and book version: no constructor for DoubleLinkedList
    private Node<T> header;
    private Node<T> trailer;
    private int size = 0 // no size variable declared
    
    public DoubleLinkedList<T> {
        header = new Node<>(null, null, null);
        trailer = new Node<>(header, null, null);
        header.setNext(trailer);
    }
   
    // no size() method declared
    public int size(){ return size; }
    
    
    public T getFirst(){
        if (isEmpty()) { return null; }
        else {
            return header.getNext().getData(); // my method returned the node, they return the data from the node
        }
    }
    
    public void addFirst(T d){ // my method added a  node, their version adds the data
        // since the node is an implementation detail, it makes more sense to add / return the data, not the node
        
        Node<T> newNode = new Node<>(header, header.getNext(), d);
        header.setNext(newNode);
        size++;
        
        
        //n.setNext() = header.getNext();
        //n.setPrevious(header);
        // header.setNext(n);
        
    }
    
    public T removeFirst(){
        if (isEmpty()) { return null; }
        else{
            Node<T> resultNode = header.getNext();
            header.setNext(resultNode.getNext());
            header.getNext().setPrevious(header);
            return resultNode.getData();
            size--;
        }
        
    }
    
    
    public T getLast(){
        if (isEmpty()) { return null; }
        else {
            return trailer.getPrevious().getData(); // changed to return data, not node
        }
    }
    
    public void addLast(Node<T> n){
        Node<T> oldLast = trailer.getPrevious();
        n.setPrevious(oldLast);
        n.setNext(trailer);
        oldLast.setNext(n);
        trailer.setPrevious(n);
        size++;
    }
    
    // they declare private addBetween and remove methods, then use those for the update methods e.g. addFirst, removeLast etc
    
    public Node<T> removeLast(){
        if (isEmpty()) { return null; }
        else {
            Node<T> result = getLast();
            Node<T> newLast = result.getPrevious();
            newLast.setNext(trailer);
            trailer.setPrevious(newLast);
            size--;
            return result;
        }
        
    }
    
    public boolean isEmpty(){
        return header.getNext() == trailer;
    }

}
