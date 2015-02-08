package ed.x02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public abstract class AbstractNStack<T> implements NStack<T>, Serializable {

        /**
	 * Push several elements onto the stack.
	 * 
	 * See {@link AbstractNStack}
	 * 
	 * @param x array of elements to push.
	 */
        @Override
	public void push(T ... x) {
		//Just rely on the push(x) method
		for (T Xi : x) { push(Xi); }
	}
	
        /**
         * Check if the list has the element
         * @param element
         * @return true if has the element, false otherwise
         */
        public boolean contains(T element){
            //clona el array
            NStack<T> clone=this.clone();
            boolean result=false;
            T target;
            
            //mientras no se haya encontrado y haya elementos...
            while(!clone.isEmpty() && !result){
                //extrae un elemento
                target=clone.pop();
                //comprueba si es el buscado
                if(target.equals(element)){
                    result=true;
                }
            }
            
            return result;
        }
        
        /**
         * Remove all the ocurrences of the element in the list
         * @param element the element to remove
         * @return number of elements removed
         */
        public int delete(T element){
            //conteo
            int count=0;
            //compruebo que tenga el elemento una vez al menos
            if(contains(element)){
                //creo un array de la misma capacidad
                int capacity=this.capacity();
                NStack<T> buffer=new ArrayNStack<T>(capacity);
                T target;
                
                //mientras haya elementos....
                while(!this.isEmpty()){
                    //saco uno de la lista
                    target=this.pop();
                    //mientras no sea el que tengo que borrar
                    if(!target.equals(element)){
                        //lo guardo en la lista temporal
                        buffer.push(target);
                    }else{
                        //incremento el contador
                        count++;
                    }
                }
                
                //devuelvo todo a la pila original
                while(!buffer.isEmpty()){
                    this.push(buffer.pop());
                }
            }
            
            return count;
        }
        
        /**
         * Clone the array with all the elements
         * @return a copy of the list
         */
        @Override
        public NStack<T> clone(){
            
            ObjectOutputStream oos = null;
            AbstractNStack<T> copy=null;
            
            try {
                //preparo un flujo de escritura
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bos);
                
                //escribo los datos de la lista en el flujo (va copiando datos)
                oos.writeObject(this);
                oos.flush();
                
                //creo un flujo de lectura a partir del de escritura anterior
                ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bin);
                // lee el objeto guardado y lo convierto al objeto que es
                copy=(AbstractNStack<T>) ois.readObject();
                ois.close();
            } catch (IOException ex){
                Logger.getLogger(AbstractNStack.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AbstractNStack.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //intento cerrar
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(AbstractNStack.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //devuelvo la copia
            return copy;
        }
	
        /**
         * Check if the lists are equals
         * @param stack the list compare with
         * @return true if they are equals
         */
	@Override
	public boolean isEqualTo(NStack<T> stack) {
            //si son iguales en su representación de string, son iguales
            return stack.toString().equals(this.toString());
	}

        /**
         * Return a string with the elements
         * @return a string with the elements
         */
	@Override
	public String toString(){
            //hago una copia de la lista para no preocuparme por las modificaciones
            NStack<T> clone=this.clone();
            StringBuilder result=new StringBuilder();
            //mientras tenga elementos, voy sacando y formando el string
            while(!clone.isEmpty()){
                result.append(clone.pop().toString());
                result.append(", ");
            }
            
            //borro las dos últimas posiciones para quitar la coma final
            if(result.length()>0){
                result.delete(result.length()-2, result.length());
            }
            return result.toString();
        }

}
