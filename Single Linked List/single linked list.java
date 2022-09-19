import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
/**
/* printing function
*/
public void print();
}


public class SingleLinkedList implements ILinkedList{
    
        class myNode{
            Object item;
            myNode next;
        }
    
        int lenth = 0;
        myNode head = null , tail = null;
    
    
 //---------------------------------------------------------------------------
    
    
        public void add (Object element){ 
            myNode input = new myNode(); 
            input.item = element; 
 
            if (this.lenth == 0){ 
                this.head = this.tail = input; 
                input.next = null ; 
            } 
            else { 
                this.tail.next = input; 
                this.tail = input; 
                input.next = null; 
            } 
 
            this.lenth++; 
        } 
    
    
    //-------------------------------------------------------------------------
 
        public void add (int index, Object element){ 
            myNode cur = this.head; 
            myNode input = new myNode(); 
            input.item = element; 
 
            if(index < 0 || index > this.lenth){ 
                System.out.print("Error"); 
                return;
            } 
 
            else if(index == 0){ 
                input.next = this.head; 
                this.head = input; 
            } 
 
            else if(index == this.lenth){ 
                this.tail.next = input; 
                this.tail = input; 
                input.next = null; 
            } 
             
            else{ 
                for(int i = 0; i < index - 1; i++){ 
                    cur = cur.next; 
                } 
                input.next = cur.next; 
                cur.next = input; 
            } 
 
            this.lenth++; 
        } 
    //-------------------------------------------------------------------------
 
        public Object get (int index){
            myNode cur = this.head; 
 
            if(index < 0 || index >= this.lenth) 
                return null; 
             
            else { 
                for(int i = 0; i < index; i++) 
                    cur = cur.next; 
            } 
 
            return cur.item; 
        } 
    //-------------------------------------------------------------------------
 
        public void set (int index, Object newValue){ 
            myNode cur = this.head; 
 
            if(index < 0 || index >= this.lenth){ 
                System.out.print("Error"); 
            } 
            else { 
                for(int i = 0; i < index; i++){ 
                    cur = cur.next; 
                } 
            } 
 
            cur.item = newValue; 
        } 
    //-------------------------------------------------------------------------
 
        public void clear(){ 
            this.head = this.tail = null; 
	    this.lenth = 0
        } 
    //-------------------------------------------------------------------------
 
        public boolean isEmpty(){ 
            return this.head == null; 
        } 
    //-------------------------------------------------------------------------
     
        public int size(){ 
            return this.lenth; 
        }  
    //-------------------------------------------------------------------------
     
        public void remove (int index){ 
            if(index >= this.lenth || index<0){ 
                System.out.println("Error");
                return; 
            }
            
           myNode cur , del; 
            cur = this.head; 
            if(index == 0){ 
                this.head = this.head.next ; 
            } 
            else { 
                //after loop cur = node before required node 
                for(int i = 0 ; i < index - 1 ;i++){ 
                    cur = cur.next ; 
                } 
                
                if(index == this.lenth - 1){ 
                    this.tail = cur; 
                    this.tail.next = null; 
                } 
                else{ 
                    del = cur.next ; 
                    cur.next = del.next ; 
                } 
            } 
            this.lenth--; 
        } 
    //-------------------------------------------------------------------------
     
        public boolean contains (Object  element){
               myNode cur = head ; 
                while (cur!= null){ 
                    if(cur.item == element){ 
                        break; 
                    } 
                    else {cur = cur.next;} 
                } 
                return cur != null; 
        } 
    //-------------------------------------------------------------------------
     
        public ILinkedList sublist(int start , int end){
           SingleLinkedList sublist = new SingleLinkedList();
            
           myNode cur = this.head; 
            for(int i =0 ; i<start ; i++){ 
                cur = cur.next ; 
            } 
            
            sublist.head = cur; 
            
            for(int j =start ; j < end ; j++){ 
                cur = cur.next ; 
            } 
            
            cur.next = null; 
            sublist.tail = cur;
            sublist.lenth = (end - start + 1);

            return sublist; 
             
        } 
     
    //-------------------------------------------------------------------------
    
        public void print(){ 
            myNode cur; 
            cur = this.head ; 
             
            System.out.print("["); 
            while (cur != null){ 
                System.out.print(cur.item); 
                if(cur.next != null) 
                    System.out.print(", "); 
                cur = cur.next ; 
            } 
            System.out.print("]"); 
        } 
    
    //-------------------------------------------------------------------------
    
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */ 
        // Taking input  
        Scanner sc = new Scanner(System.in); 
        String sin = sc.nextLine().replaceAll("\\[|\\]", ""); 
        String[] str = sin.split(", "); 
         
        SingleLinkedList list = new SingleLinkedList(); 
         
        if (str.length > 0 && !(str[0].isEmpty())){ 
            for(int i = 0;i < str.length; i++) 
                list.add(Integer.parseInt(str[i])); 
        }
         
        String method = sc.nextLine(); 
         
    //-------------------------------------------------------------------------
 
        if(method.equalsIgnoreCase("add")){ 
            int value = sc.nextInt(); 
            list.add(value); 
            list.print(); 
        } 
        
    //-------------------------------------------------------------------------
         
        else if(method.equalsIgnoreCase("addToIndex")){ 
            int index = sc.nextInt(); 
            int value = sc.nextInt(); 
            if(index < 0 || index > list.lenth) 
                System.out.print("Error"); 
            else {
                list.add(index, value); 
                list.print(); 
            }
        } 
        
    //-------------------------------------------------------------------------
        
        else if(method.equalsIgnoreCase("get")){ 
            int index = sc.nextInt(); 
            Object wanted = list.get(index); 
            if(wanted == null) 
                System.out.print("Error"); 
            else 
                System.out.print(wanted);       
        } 
        
    //-------------------------------------------------------------------------
        
        else if(method.equalsIgnoreCase("set")){
            int index = sc.nextInt(); 
            int value = sc.nextInt(); 
            if(index < 0 || index >= list.lenth)
                System.out.print("Error"); 
            else{
                list.set(index, value); 
                list.print(); 
            }
        } 
        
    //-------------------------------------------------------------------------
        
        else if(method.equalsIgnoreCase("clear")){ 
            list.clear(); 
            list.print(); 
        } 
        
    //-------------------------------------------------------------------------
        else if(method.equalsIgnoreCase("isEmpty")){ 
            if(list.isEmpty()) 
                System.out.print("True"); 
            else 
                System.out.print("False"); 
        } 
        
    //-------------------------------------------------------------------------
        
        else if(method.equalsIgnoreCase("size")){
            System.out.print(list.size()); 
        } 
        
    //-------------------------------------------------------------------------
        
        else if(method.equalsIgnoreCase("remove")){
            int index = sc.nextInt(); 
            if(index >= list.lenth || index < 0){ 
                System.out.println("Error"); 
            } 
            else{ 
                list.remove(index); 
                list.print(); 
            } 
        } 
        
    //-------------------------------------------------------------------------
        
        else if(method.equalsIgnoreCase("sublist")){
            int start = sc.nextInt(); 
            int end = sc.nextInt(); 
            if(start<0 || end >= list.lenth || start >= list.lenth || start > end || end <= 0)
                System.out.println("Error");
            else {
                ILinkedList sublist = list.sublist(start, end);
                sublist.print();
            }
        } 
        
    //-------------------------------------------------------------------------
        
        else if(method.equalsIgnoreCase("contains")){ 
            int value = sc.nextInt(); 
            if(list.contains(value)) 
                System.out.print("True"); 
            else 
                System.out.print("False"); 
        } 
         
    } 
}