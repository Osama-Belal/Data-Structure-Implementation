import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}


public class MyStack implements IStack {
    
   class myNode{
       Object item;
       myNode next;
       myNode prev;
   }

    int lenth = 0;
    myNode top = null;

//---------------------------------------------------------------------------

    public void push (Object element){ 
        myNode input = new myNode(); 
        input.item = element; 

        if (this.lenth == 0){ 
            this.top = input; 
            input.next = input.prev = null; 
        } 
        else { 
            input.prev = this.top;
            this.top.next = input; 
            this.top = input; 
            input.next = null;
        } 

        this.lenth++; 
    } 

//-------------------------------------------------------------------------

    public Object peek(){
        if(this.isEmpty()){
            return null;
        }
        else
            return this.top.item;
    } 

//-------------------------------------------------------------------------

    public void clear(){ 
        this.top = null; 
    } 
//-------------------------------------------------------------------------

    public boolean isEmpty(){ 
        return this.top == null; 
    } 
//-------------------------------------------------------------------------

    public int size(){ 
        return this.lenth; 
    }  
//-------------------------------------------------------------------------

    public Object pop (){ 

        if(this.lenth == 0)
            return null;
        
        else if(this.lenth == 1){
            myNode popped = this.top;
            this.top = null; 
            this.lenth--; 
            return popped.item;
        }

        else { 
            myNode popped = this.top;
            this.top = this.top.prev; 
            this.top.next = null; 
            this.lenth--; 
            return popped.item;
        }

    } 


//-------------------------------------------------------------------------    

    public void print(){
        
        if(this.isEmpty()){
            System.out.println("[]");
            return;
        }
        
        else{
            myNode cur; 
            cur = this.top; 

            System.out.print("["); 
            while (cur != null){ 
                System.out.print(cur.item); 
                if(cur.prev != null) 
                    System.out.print(", "); 
                cur = cur.prev ; 
            } 
            System.out.print("]"); 
        }
        
    } 

//--------------------------------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] str = sin.split(", ");
        
        MyStack stack = new MyStack();
        for(int i = 0; i < str.length && !str[0].isEmpty(); i++){
            int n = str.length;
            stack.push(str[n-i-1]);
        }
        
        String method = sc.nextLine();
        
        if(method.equalsIgnoreCase("push")){
            
            int pushEl = sc.nextInt();
            stack.push(pushEl);
            stack.print();
            
            
        } else if(method.equalsIgnoreCase("pop")){
            
            if(stack.isEmpty())
                System.out.print("Error");
            else{
                stack.pop();
                stack.print();
            }
            
        } else if(method.equalsIgnoreCase("peek")){
            
            if(stack.isEmpty())
                System.out.print("Error");
            else
                System.out.print(stack.peek());
            
        } else if(method.equalsIgnoreCase("isEmpty")){
            
            if(stack.isEmpty())
                System.out.print("True");
            else
                System.out.print("False");
            
        } else if(method.equalsIgnoreCase("size")){
            
            System.out.print(stack.size());
            
        } else if(method.equalsIgnoreCase("clear")){
            
            System.out.print("[]");
            
        } else {
            System.out.print("Error");
        }
        
    }
}