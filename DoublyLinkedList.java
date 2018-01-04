package portfolio;
import java.util.Iterator;


public class DoublyLinkedList<E> implements Iterable<E> {
	// declaration of the variable
	// head_of_list(header) and tail_of_list(trailer)
	private Node<E> head_of_list;
	private Node<E> tail_of_list;
	private int size ;

	// declaration of class Node
	static class Node<E> {

		// declaration of the variable

		private E element;
		private Node<E> previous_element;
		private Node<E> next_element;

		// method that assigns the values of the elements
		public Node(E e, Node<E> previous, Node<E> next) {
			this.element = e;
			this.previous_element = previous;
			this.next_element = next;
		}

		// accessors and mutators
		// to return the value and to set the value
		public E getElement() {
			return element;
		}

		public E setElement() {
			return element;
		}

		public Node<E> getNext() {
			return next_element;
		}

		public void setNext(Node<E> next) {
			this.next_element = next;
		}

		public Node<E> getPrevious() {
			return previous_element;
		}

		public void setPrevious(Node<E> previous) {
			this.previous_element = previous;
		}
	}

	// method
	public DoublyLinkedList() {

		// declaring the pointers for header and trailer of the list
		head_of_list = new Node<E>(null, null, null);
		tail_of_list = new Node<E>(null, head_of_list, null);
		//head_of_list.setNext(tail_of_list);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// return the first element if its not empty
	public E first() {
		if (isEmpty()) {
			return null;
		} else {
			return head_of_list.getNext().getElement();
		}
	}
	// return the last element if its not empty

	public E last() {
		if (isEmpty()) {
			return null;
		} else {
			return head_of_list.getPrevious().getElement();
		}
	}

	// add an element to the list

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> new_node = new Node<>(e, predecessor, successor);
		predecessor.setNext(new_node);
		successor.setPrevious(new_node);
		size++;
	}

	// remove the node from list
	private E remove_Node(Node<E> node) {
		Node<E> successor = node.getNext();
		Node<E> predecessor = node.getPrevious();
		successor.setPrevious(predecessor);
		predecessor.setNext(successor);
		size--;
		return node.getElement();
	}

	//add an element at the first position
	public void addFirst(E e) {
		addBetween(e, head_of_list, head_of_list.getNext());
	}

	//add an element at the last position

	public void addLast(E e) {
		addBetween(e, tail_of_list.getPrevious(), tail_of_list);
	}

	//remove an element at the first position

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		} else {

			return remove_Node(head_of_list.getNext());
		}
	}

	//remove an element at the last position

	public E removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			return remove_Node(tail_of_list.getPrevious());
		}
	}

	//iterator method
	public Iterator<E> iterator() {
		return new ListIterator();
	}


	//iterator class
	class ListIterator implements Iterator<E> {
		Node<E> current;

		public ListIterator() {
			current = DoublyLinkedList.this.head_of_list.getNext();
		}

		public boolean hasNext() {
			return current != DoublyLinkedList.this.tail_of_list;
		}

		public E next() {
			E r = (E) current.getElement();
			current = current.getNext();
			return r;
		}

	}

	/* String representation of the list
	 */
	public String toString() {
		String str = "";
		Node<E> variable = head_of_list.getNext();
		while (variable != tail_of_list) {
			str += variable.getElement();
			variable = variable.getNext();
			str += " | ";
			//System.out.println(str);
		}

		return str;
	}


	//to check if the contents of the list is in palindrome sequence
	public boolean isPalindrome() {
		Boolean var = false;
		//if the list is empty
		if (isEmpty()) {
			System.out.println("the list is empty");
			return var;
		}


		else {
			int left = 0;
			int right = size() - 1;
			Node<E> first = head_of_list.next_element;
			Node<E> last = tail_of_list.previous_element;

			//if the list has one element
			if (left == right) {
				var = true;
			}
           //if the list has more than 1 element
			else {

				for (int i = 0; i < size / 2; i++) {
					//compares if the last and the first element are equal.If they're not then,it returns false
					if (first.getElement() != last.getElement()) {
						return false;
					}
					//assigns the value of the following elements to the first and last element
					first = first.next_element;
					last = last.previous_element;
					var = true;
				}

			}
		}

		System.out.print("the value returned : " + var + "\no_of_total_disks");
		return var;

	}

	// question 7
//to get the value of Kth element from the list
	public E getKth(int k) {

		//checks if the list is empty or not
		if (isEmpty()) {
            return null;
        }
	    else {
			Node<E> temporary = head_of_list.next_element;

			// loop through
			for (int i = 0; i < k; i++) {
				// temporary is the next node
				temporary = temporary.next_element;
			}
			return temporary.element;
		}

	}



	// question 8

	public void reverse() {
		// TODO Auto-generated method stub

		Node<E> prev =null;
		Node<E> current =head_of_list;
		Node<E> next1 =null;

		while (current != null  ) {

			next1=current.next_element;
			current.next_element=prev;
			prev=current;
			current=next1;
			//if( current.element==null)
             // break;

		}
		/* assigning the value of head.Checking for empty list */
		if(prev!=null) {
		head_of_list=prev;
		}
	}



//Question 9
	//to find the minimum element from the list
	 public  Node findMinimum() {

			//check if the list is empty
		 if (isEmpty()) {
	            return null;
	        }
		 else {

			 head_of_list=head_of_list.getNext();
		 Node  current = head_of_list;
		 Node  min = current;

		 Integer min_value= (Integer) head_of_list.getElement();
		// System.out.println("enter loop");

		 //goes through the list,and assigns the value of the min accordingly
		 while (current != null) {
			 if(current.getElement()==null)
	        	 break;

			 if (min_value > (Integer) current.getElement()  ) {
	           // 	System.out.println("inside");
	                min = current;
	            }
		      // System.out.println("current element....."+current.element);
		     //  System.out.println("min"+min.getElement());
			    current=current.getNext();

			 }
		 //returns the min
	        return min;
		 }
 }

	 //method to pop the value of min and sort the list
 public E popMinimum() {
	 //array1 new node called minimum is created
	 head_of_list=head_of_list.getPrevious();
	 Node minimum = findMinimum();
	 //the value of min is passed
     E temporaryMinimum = (E) minimum.getElement();
     //the node is removed
     remove_Node(minimum);
     //System.out.println("Removed minimum  "+minimum.element);
     return temporaryMinimum;
		// TODO
 }



}
