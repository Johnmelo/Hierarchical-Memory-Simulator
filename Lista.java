
/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lista
{
    private Node head;
    private Node tail;
    private int size;
    
    public Lista(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void create(int x){
        this.head = new Node();
        this.head.setIdx(x);
        this.tail = this.head;
        
        this.size++;
    }
    
    public void push_back(int x){
        if(this.size == 0){
            this.create(x);
        }else{
            Node node = new Node();
            node.setIdx(x);
            node.setPrevious(this.tail);
            this.tail.setNext(node);
            this.tail = node;
            this.size++;
        }
    }
    
    public void pop_front(){
        Node aux = this.head.getNext();
        this.head = aux;
        this.size--;
    }
    
    public int front(){
        return this.head.getIdx();
    }
    
    public void list(){
        if(this.size>0){
            Node aux = this.head;
        
            while(aux.getNext()!= null){
                System.out.print(aux.getIdx()+" ");
                aux = aux.getNext();
            }
            System.out.println(aux.getIdx());
        }else{
            System.out.println("Lista vazia");
        }
    }
    
    public void remove(int x){
        if(this.size>0){
            Node aux = this.head;
            boolean flag = false;
            while(aux.getNext()!= null){
                if(aux.getIdx() == x){
                    flag = true;
                    break;
                }
                aux = aux.getNext();
            }
            if(aux.getIdx() == x){
                flag = true;
            }
            if(flag){
                if(aux == this.head){
                    this.pop_front();
                }else{
                    Node node = aux.getPrevious();
                    node.setNext(aux.getNext());
                    this.size--;
                }
            }
        }
    }
    
    public int getSize(){
        return this.size;
    }


}