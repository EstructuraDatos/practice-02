package ed.x02;


@SuppressWarnings("serial")
public class ArrayNStack<T> extends AbstractNStack<T> {
    /**
     * array donde guardar los elementos
     */
    private T[] stack;
    /**
     * Posición del último elemento
     */
    private int top;
    /**
     * Posición del primer elemento
     */
    private int start;
    /**
     * Tamaño de la lista
     */
    private int size;
    /**
     * Número de elementos
     */
    private int count;
    /**
     * Tamaño predeterminado de la lista
     */
    private static int DEFAULT_SIZE=5;

    /**
     * Crea una lista con el tamaño por defecto
     */
    public ArrayNStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Crea una lista con el tamaño dado
     * @param capacity tamaño máximo de la lista
     */
    public ArrayNStack(int capacity) {
        //creo el array
        stack = (T[]) new Object[capacity];
        //recojo el tamaño
        //inicializo el resto a cero
        size=capacity;
        top = 0;
        start=0;
        count=0;
    }

    /**
     * 
     * @see AbstractNStack#push 
     */
    @Override
    public void push(T x) {
        //sumo uno para la siguiente posición, y le hago módulo capacidad para
        //que si llegó al tope, empieze de nuevo al principio de la lista
        //4%5=4 5%5=0->comienza de nuevo en el principio del array
        top=(top+1)%size;
        //guardo el elemento, pisando el principio de la cola si ya estaba al
        //máximo de elementos
        stack[top]=x;
        //si no estaba al máximo de elementos, incremento el contador
        if(count<size){
            count++;
            
        //si ya estaba al máximo, avanzo el principio de la cola ya que el primero
        //ha sido pisado por el top. Uso el módulo por la misma razón que el push
        }else{
            start=(start++)%size;
        }
    }

    @Override
    public T pop() throws EmptyCollectionException {
        //si está vacío lanzo excepción
        if(count==0){
            throw new EmptyCollectionException("Stack is empty");
            
        
        }else{
            //decremento el contador
            count--;
            //recojo el último elemento
            T target=stack[top];
            //actualizo el índice del top
            //la fórmula inicial sería restar uno al top
            //el problema es cuando está a cero y tiene que volver a la posición
            //size-1 del array, al restarle queda negativo y el % lo deja así
            //por lo que le sumo primero la capacidad (que al hacer el módulo
            //quedará como si no le hubiera sumado nada) y así al restar no queda
            //negativo. El módulo resuelve el problema de que quede dentro del
            //rango de índices (2+5=7 %5=2 =>el resultado se queda entre los índices 0 y 4)
            top=((top+size)-1)%size;
            //devuelvo el elemento
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
