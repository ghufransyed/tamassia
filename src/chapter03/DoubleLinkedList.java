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
    
    private Node<T> header = new Node<>(null, null, null);
    private Node<T> tail = new Node<>(header, null, null);
    header.next = tail;
    
    public Node<T> getFirst(){
        if (isEmpty()) { return null; }
        else {
            return header.getNext();
        }
    }
    
    public void addFirst(Node<T> n){
        n.setNext() = header.getNext();
        n.setPrevious(header);
        header.setNext(n);
        
    }
    
    public Node<T> removeFirst(){
        if (isEmpty()) { return null; }
        else{
            Node<T> result = header.getNext();
            header.setNext(result.getNext());
            header.getNext().setPrevious(header);
            return result;
        }
        
    }
    
    
    public Node<T> getLast(){
        if (isEmpty()) { return null; }
        else {
            Node<T> result = tail.getPrevious();
        }
    }
    
    public void addLast(Node<T> n){
        Node<T> oldLast = tail.getPrevious();
        n.setPrevious(oldLast);
        n.setNext(tail);
        oldLast.setNext(n);
        tail.setPrevious(n);
    }
    
    public Node<T> removeLast(){
        if (isEmpty()) { return null; }
        else {
            Node<T> result = getLast();
            Node<T> newLast = result.getPrevious();
            newLast.setNext(tail);
            tail.setPrevious(newLast);
            return result;
        }
        
    }
    
    public boolean isEmpty(){
        return header.getNext() == tail;
    }
    
    
    
    
    


}
