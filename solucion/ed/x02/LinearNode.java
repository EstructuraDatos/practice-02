package ed.x02;

import java.io.Serializable;

/**
 * Implementa Serializable para poder ser clonado en los métodos del padre
 * @author dorian
 */
@SuppressWarnings("serial")
public class LinearNode<T> implements Serializable {
    private LinearNode<T> next;
    private LinearNode<T> previous;
    private T element;

    /**
     * Constructor predeterminado
     */
    public LinearNode() {
        next=null;
        element=null;
        previous=null;
    }

    /**
     * Constructor de linear node a partir de un elemento
     * @param element elemento del nodo
     */
    public LinearNode(T element) {
        this.next = null;
        this.element = element;
    }
    
    /**
     * Establece el siguiente nodo a él
     * @param node elemento siguiente a este
     */
    public void setNext(LinearNode<T> node){
        next=node;
    }
    
    /**
     * Devuelve el siguiente nodo a él
     * @return el siguiente nodo a él
     */
    public LinearNode<T> getNext(){
        return next;
    }

    /**
     * Devuelve el anterior nodo a él
     * @return el anterior nodo a él
     */
    public LinearNode<T> getPrevious() {
        return previous;
    }

    /**
     * Establece el anterior nodo a él
     * @param previous el anterior nodo a él
     */
    public void setPrevious(LinearNode<T> previous) {
        this.previous = previous;
    }
        
    /**
     * Devuelve el elemento del nodo
     * @return elemento del nodo
     */
    public T getElement(){
        return element;
    }
    
    /**
     * Establece el elemento del nodo
     * @param element el elemento del nodo
     */
    public void setElement(T element){
        this.element=element;
    }
}
