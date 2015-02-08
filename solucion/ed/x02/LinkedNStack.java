package ed.x02;

@SuppressWarnings("serial")
public class LinkedNStack<T> extends AbstractNStack<T>{
    private static int DEFAULT_CAPACITY=5;
    private int size;
    private int count;
    private LinearNode<T> top;
    private LinearNode<T> start;

    public LinkedNStack() {
        this(DEFAULT_CAPACITY);
    }
    
    public LinkedNStack(int capacity) {
        size=capacity;
        top=null;
        start=null;
        count=0;
    }

    @Override
    public void push(T x) {
        LinearNode<T> node=new LinearNode<T>(x);
        if(count==0){
            top=node;
            start=top;
            count++;
        }else if(count<size){
            node.setNext(top);
            top.setPrevious(node);
            top=node;
            count++;
        }else{
            start=start.getPrevious();
            start.setNext(null);
            node.setNext(top);
            top=node;
        }
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if(count==0){
            throw new EmptyCollectionException("Stack is empty");
        }else{
            count--;
            T target=top.getElement();
            top=top.getNext();
            return target;
        }
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public boolean isFull() {
        return count==size;
    }

    @Override
    public int capacity() {
        return size;
    }

}
