
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    private int idx;
    private Node next;
    private Node previous;
    
    public Node(){
        this.idx =-1;
        this.next = null;
        this.previous = null;
    }
    
    public void setIdx(int idx){
        this.idx = idx;
    }
    
    public int getIdx(){
        return this.idx;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public Node getPrevious(){
        return this.previous;
    }
    
    public void setNext(Node node){
        this.next = node;
    }
    
    public void setPrevious(Node node){
        this.previous =  node;
    }
}
