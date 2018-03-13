/*
Minimum stack implementation using two stacks. Useful when applying
for very large stacks.
*/
import java.util.*;

public class stackMin extends Stack<Integer> {
  Stack<Integer> s2;

  public stackMin(){
    s2 = new Stack<Integer>();
  }

public static void main(String[] args){
  stackMin inst = new stackMin();
  inst.push(8);
  System.out.println(inst.min());
  inst.push(19);
  System.out.println(inst.min());
  inst.push(5);
  System.out.println(inst.min());
  inst.push(12);
  System.out.println(inst.min());
  inst.push(4);
  System.out.println(inst.min());
  inst.pop();
  System.out.println(inst.min());
  inst.pop();
  System.out.println(inst.min());
}

  public void push(int value){
    if(value <= min()){
      s2.push(value);
    }
    super.push(value);
  }

  public Integer pop(){
    int value = super.pop();
    if(value == min()){
      s2.pop();
    }
    return value;
  }

  public int min(){
    if(s2.isEmpty()){
      return Integer.MAX_VALUE;
    }
    else return s2.peek();
  }

}
