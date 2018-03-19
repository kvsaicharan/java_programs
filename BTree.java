import java.util.*;

public class BTree {
	public static void main(String args[]) {
		 Tree tr;
		 tr = new Tree(100);
		 tr.insert(50);
		 tr.insert(125);
		 tr.insert(150);
		 tr.insert(25);
		 tr.insert(75);
		 tr.insert(20);	
		 tr.insert(20);	
		 tr.insert(20);	
		 tr.insert(90);
		 
		 tr.inord_trav();
		 //tr.preord_trav(this);
		 //tr.postord_trav(this);
		 tr.zigzag();
		 
		 tr.delete(20);
		 tr.delete(20);
		 tr.delete(20);
		 tr.delete(125);
		 tr.delete(150);
		 tr.delete(100);
		 tr.delete(50);
		 tr.delete(75);
		 tr.delete(25);
		 tr.delete(90);
	}
}

class Tree { // Defines one node of a binary search tree
	
	public Tree(int n) {
		value = n;
		left = null;
		right = null;
	}
	
	public void insert(int n) {
		if (value == n)
			return;
		if (value < n)
			if (right == null)
				right = new Tree(n);
			else
				right.insert(n);
		else if (left == null)
			left = new Tree(n);
		else
			left.insert(n);
	}
	
	
	public Tree min() {
		if (left == null) return this;
		else return left.min();
	}
	
	public Tree max() {
		if (right == null) return this;
		else return right.max();
	}
	
	
	public Tree find(int n) {
		if (value == n) return this;
		else if (value < n)
			if (right == null)
				return null;
			else
				return right.find(n);
		else if (left == null)
			return null;
		else
			return left.find(n);
	}
	
	public void delete(int n) { // assume > 1 nodes in tree
		Tree t = find(n);
		if (t == null) {  // n is not in the tree
			System.out.println("Unable to delete " + n + " -- not in the tree!");
			return; 
		}
		if (t.left == null && t.right == null) { // n is a leaf value
			if (t != this)
				case1(t, this);
			else 
				System.out.println("Unable to delete " + n + " -- tree will become empty!");
			return;
		}
		if (t.left == null || t.right == null) { // t has one subtree only
			if (t != this) { // check whether t is the root of the tree
				case2(t, this);
				return;
			} else {
				if (t.right == null)  
					case3(t, "left");
				else 
					case3(t, "right");
				return;
			}
		}
		// t has two subtrees; go with smallest in right subtree of t
		case3(t, "right");
	}
	
	protected void case1(Tree t, Tree root) { // remove the leaf
		if (t.value > root.value) 
			if (root.right == t) 
				root.right = null;
			else case1(t, root.right);
		else if (root.left == t) 
				root.left = null;
			else case1(t, root.left);
	}
	
	protected void case2(Tree t, Tree root) { // remove internal node
		if (t.value > root.value)
			if (root.right == t)
				if (t.right == null)
					root.right = t.left;
				else
					root.right = t.right;
			else
				case2(t, root.right);
		else if (root.left == t)
				if (t.right == null)
					root.left = t.left;
				else
					root.left = t.right;
			else
				case2(t, root.left);
	}
	
	protected void case3(Tree t, String side) { // replace t.value 
		if (side == "right") {
			Tree min_right_t = t.right.min();
			if (min_right_t.left == null && min_right_t.right == null)  
				case1(min_right_t, this);  // min_right_t is a leaf node
			else 
				case2(min_right_t, this);  // min_right_t is a non-leaf node
			t.value = min_right_t.value;
		}
		else {
			Tree max_left_t = t.left.max();
			if (max_left_t.left == null && max_left_t.right == null)
				case1(max_left_t, this); // max_left_t is a leaf node
			else
				case2(max_left_t, this); // max_left_t is a non-leaf node
			t.value = max_left_t.value;
		}
	}

	protected void inord_trav(){
		inord_trav(this);
	}
	protected void inord_trav(Tree node){
			if(node == null){
				return;
			}
			inord_trav(node.left);
			System.out.println(node.value);
			inord_trav(node.right);
			
	}
	
	protected void zigzag(){zigzag(this);}
	protected void zigzag(Tree root){
		if (root == null) return;
		Stack<Tree> curr_stack = new Stack<Tree>();
		Stack<Tree> next_stack = new Stack<Tree>();
		curr_stack.push(root);
		boolean ltor = true;
		
		while (!curr_stack.isEmpty()){
			Tree curr_node = curr_stack.pop();
			System.out.println(curr_node.value);
			
			if(ltor){
				if (curr_node.left != null)
				next_stack.push(curr_node.left);
         
				if (curr_node.right != null) 
				next_stack.push(curr_node.right);
		}
		else{
				if (curr_node.right != null)
				next_stack.push(curr_node.right);
         
				if (curr_node.left != null) 
				next_stack.push(curr_node.left);
		}
		
		if (curr_stack.isEmpty()) {
        ltor = !ltor;
        Stack<Tree> temp = curr_stack;
        curr_stack = next_stack;
        next_stack = temp;
    }
		
		}
	}
	
	//protected Tree root;
	protected int value;
	protected Tree left;
	protected Tree right;
}
