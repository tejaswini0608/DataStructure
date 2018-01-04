package portfolio;

//code to construct a stack of arrays

public class StackArray<E> {

	private E[] elements;
	private int x = -1;
	public static final int size_of_array=200; 
	
	//constructor
	//Creates an array of given size
	public StackArray( )
	{ 
		this(size_of_array); 
		}
	
	
	//construct that constructs the stack
	public StackArray(int capacity) { 
		
		elements = (E[ ]) new Object[capacity]; 
	}
	
	//checks if stacks is empty
	public boolean isEmpty()
	{
		return(x==-1);
	}
		
	//returns size of elements in the stack
	public int size()
	{
		return (x+1);
	}
		
	
	
	//returns the element at the top of the stack
		public E top()
		{
			if (isEmpty( )) return null;
			return elements[x];
		}
		
		
	//insert an element to stack
	//exception is thrown just to ensure that stack is not empty
	public void push(E e) throws IllegalStateException
	{
		if(size()==elements.length)throw new IllegalStateException("No place: stack full");
		elements[++x] = e;
	}
	

	
	
	//removes the top element and returns it
	public E pop()
	{
		if (isEmpty( ))
			return null;
		
		E answer = elements[x];
		
		elements[x] = null;
		x--;
		
		return answer;
	}
}

