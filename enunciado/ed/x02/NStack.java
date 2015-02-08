package ed.x02;


public interface NStack<T>  {

	public void push(T x);
	
	/**
	 * Push several elements onto the stack.
	 * 
	 * See {@link AbstractNStack}
	 * 
	 * @param x array of elements to push.
	 */
	public void push(T ... x);
	
	/**
	 * Pops the top element from the stack.
	 * 
	 * @return the element that was on top.
	 * 
	 * @throws EmptyStackException if the stack was empty.
	 */
	public T pop() throws EmptyCollectionException;
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public int capacity();

	boolean isEqualTo(NStack<T> stack);
}
