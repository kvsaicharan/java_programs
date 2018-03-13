import java.util.*;
//Node object with data and next link.
class Node{
  int data;
  Node next = null;
  Node(int d){
    data = d;
  }
}

/******************************************************************/
public class LList{
  private static Node head;
  private static int listCount;
  LList(){
    this.head = null;
    this.listCount = 0;
  }

/******************************************************************/
// Insertion of a node in a sigle linked list.
  private Node insert(int d){
    if(head == null){
       head = new Node(d);
    }
    else{
      Node link = head;
      while(link.next != null)
          link = link.next;
      link.next = new Node(d);
    }
    listCount++;
    return head;
  }

/******************************************************************/
// Insertion at specific index
  private Node insertAt(int value, int index){
    Node current = head;
    Node prev = null;
    if(index > listCount){
      System.out.println("Index " + index +" out of bounds");
    }
    else if(index == 0){
        head = new Node(value);
        head.next = current;
        listCount++;
      }
    else if(index < listCount){
        int count = 0;
        while(index > count){
          prev = current;
          current = current.next;
          count++;
        }
        prev.next = new Node(value);
        prev.next.next = current;
        listCount++;
      }
      else  insert(value);

    return head;
  }

/******************************************************************/
//Delete a node from linkedlist
private Node delete(){
  Node current = head;
  if(listCount == 0) System.out.println("No more nodes to delete");
  else if(listCount == 1){ head = null; listCount--;}
   else{
    while(current.next.next != null){ current = current.next;}
    current.next = null;
    listCount--;
  }
  return head;
}

/******************************************************************/
//Delete node with certain data
private Node deleteData(int d){
  Node current = head;
  int count = 0;
  while(current.data != d && current.next != null){
    current = current.next;
    count++;
  }
  if(count == listCount-1 && current.data != d) System.out.println("Not found");
else deleteAt(count);
return head;
}

/******************************************************************/
//Delete node at specific index
private Node deleteAt(int index){
  Node current = head, prev = null;
  if(index >= listCount) System.out.println("Index out of bounds");
  else if(index == 0){
    head = current.next;
    listCount--;
  }
  else if(index < listCount-1){
    int count = 0;
    while(index>count){
      prev = current;
      current = current.next;
      count++;
    }
    prev.next = current.next;
    current = null;
    listCount--;
  }
  else  delete();
  return head;
}

/******************************************************************/
//reverse a linked list
  private Node reverseList(){
    Node nxt = null, prev = null;
    if(head == null) System.out.println("No nodes to print");
    else{
      while(head != null){
        nxt = head.next;
        head.next = prev;
        prev = head;
        head = nxt;
      }
    }
    head = prev;
    return head;
}

/******************************************************************/
//Returns the middle element in the LinkedList
private Node midNode(){
  Node current = head, mid = head;
  int count = 0;
  while(current.next != null){
  current = current.next;
  ++count;
  if((count & 1) != 0) mid = mid.next;
  }
  System.out.println("Mid element " + mid.data);
  return head;
}

/******************************************************************/
//Remove duplicates
private Node removeDup(){
  Node current = head;
  Set<Integer> dupSet = new HashSet<Integer>();
  while(current.next != null){
  if(dupSet.contains(current.data)) deleteData(current.data);
  else dupSet.add(current.data);
  current=current.next;
  }
  return head;
}

/******************************************************************/
//print the LinkedList
  private Node print(){
    Node link = head;
    System.out.print(link.data);
    while(link.next != null){
      link = link.next;
      System.out.print(" --> " + link.data);
    }
    System.out.println("\n" + listCount);
    return head;
  }

/******************************************************************/

  public static void main(String[] args){
    LList list = new LList();
    list.insert(10);
    list.insert(20);
    list.insert(10);
    list.insert(50);
    list.insert(50);
    list.insert(30);
    list.insert(40);
    list.insert(50);
    //list.insertAt(25,2);
    list.insertAt(30,0);
    list.insertAt(60,listCount);
    //list.delete();
    //list.deleteAt(4);
    //list.deleteAt(0);
    //list.deleteData(125);
    //list.print();
    //list.midNode();
    //list.reverseList();
    list.removeDup();
    list.print();
  }
}
