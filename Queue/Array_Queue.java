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

public class ArrayQueue implements IQueue {
    
    int n = 1000;
    Object[] queue = new Object[n];
    int front = n / 2;
    int rear = front;
    
    //-------------------------------------------------------------------------
    
    public void enqueue(Object item){
        if (rear == (front - 1)){
            System.out.println("Error");
            return;
        }
        queue[rear] = item;
        rear = (rear+1) % (n-1);
        return;
    }
    
    //-------------------------------------------------------------------------
    
    public Object dequeue(){
        if(rear == front){
            System.out.println("Error");
            return null;
        }
        Object lead = queue[front];
        queue[front] = null;
        front = (front + 1) % (n - 1);
        return lead;
    }
    
    //-------------------------------------------------------------------------
    
    public boolean isEmpty(){
        return front == rear;
    }

    //-------------------------------------------------------------------------
    
    public int size(){
        return (rear - front);
    }
    
    //-------------------------------------------------------------------------
    
    public void print(){
        
        if(this.isEmpty()){
            System.out.println("[]");
            return;
        }
        
        else{
            int r = rear-1;
            System.out.print("["); 
            for (int i = 0; i < this.size(); i++){
                System.out.print(queue[r]);
                if(r == 0) r = n - 1;
                else r--;
                if(i != this.size() - 1) 
                    System.out.print(", "); 
            } 
            System.out.print("]"); 
        }
        
    } 
    
    //----------------------------------------------------------------------

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] q = sin.split(", ");
        ArrayQueue queue = new ArrayQueue();
        
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