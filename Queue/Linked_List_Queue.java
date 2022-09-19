import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IQueue {
  /*** Inserts an item at the queue front.*/
  public void enqueue(Object item);
  /*** Removes the object at the queue rear and returnsit.*/
  public Object dequeue();
  /*** Tests if this queue is empty.*/
  public boolean isEmpty();
  /*** Returns the number of elements in the queue*/
  public int size();
}

public class LinkedListQueue implements IQueue {
       
   class myNode{
       Object item;
       myNode next;
       myNode prev;
   }

    int lenth = 0;
    myNode front = null , rear = null; 

    //---------------------------------------------------------------------------

    public void enqueue (Object element){
        
        myNode input = new myNode(); 
        input.item = element; 

        if (this.lenth == 0){ 
            this.front = this.rear = input; 
            input.next = input.prev = null; 
        } 
        else { 
            input.prev = this.rear;
            this.rear.next = input; 
            this.rear = input; 
            input.next = null;
        } 

        this.lenth++; 
        return;
    } 

    
    //-------------------------------------------------------------------------

    public boolean isEmpty(){ 
        return this.lenth == 0 || this.front == null; 
    } 

    //-------------------------------------------------------------------------

    public int size(){ 
        return this.lenth; 
    }  

    //-------------------------------------------------------------------------

    public Object dequeue (){ 
        
        if(this.isEmpty()){ 
            System.out.println("Error");
            return null; 
        }
        
        else if(lenth == 1){
            myNode tbr = this.front;
            this.front = this.rear = null;
            return tbr;
        }
        
        myNode f = this.front;
        front = front.next;
        front.prev = null;
       
        myNode cur = this.front;
        myNode del = this.front; 
        this.lenth--; 
        return f.item;
        
    } 
    
    //-------------------------------------------------------------------------

    public void print(){ 
        myNode cur; 
        cur = this.rear; 

        System.out.print("["); 
        while (cur != null){ 
            System.out.print(cur.item); 
            if(cur.prev != null) 
                System.out.print(", "); 
            cur = cur.prev ; 
        } 
        System.out.print("]"); 
    }

 
    //--------------------------------------------------------------------------------------------------------------
    
    
    public static void main(String[] args) {
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] q = sin.split(", ");
        LinkedListQueue queue = new LinkedListQueue();
        
        if(!(q[0].isEmpty()))
            for(int i = 0; i < q.length; i++)
                queue.enqueue(q[q.length-1-i]);
        
        
        String method = sc.nextLine();
        
        if(method.equalsIgnoreCase("enqueue")){
            int tbq = sc.nextInt();
            queue.enqueue(tbq);
            queue.print();
        }
        
        else if(method.equalsIgnoreCase("dequeue")){
            if(queue.isEmpty())
                System.out.println("Error");
            else{
                queue.dequeue();
                queue.print();
                }
        }
        
        else if(method.equalsIgnoreCase("size"))
            System.out.println(queue.size());
        
        else if(method.equalsIgnoreCase("isEmpty")){
            if(queue.isEmpty() == false)
                System.out.println("False");
            else
                System.out.println("True");
        }
            
        
        else 
            System.out.println("Error");

        
    }
}