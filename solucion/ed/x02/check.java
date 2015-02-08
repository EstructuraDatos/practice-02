package ed.x02;

/**
 *
 * @author dorian
 */
public class check {
    /**
     * Método que comprueba si una expresión tiene los paréntesis, corchetes
     * y llaves correctamente balanceados
     * @param expr
     * @return 
     */
    public static boolean isCorrect(String expr){
        int longitud=expr.length();
        //creo una pila
        ArrayNStack<String> stack=new ArrayNStack<String>((longitud/2)+1);
        //presupongo que de antemano la expresión está bien
        boolean correct=true;
        char oneCharacter;
        
        //mientras la expresión tenga caracteres y esté bien de momento...
        for(int i=0; i<longitud && correct; i++){
            oneCharacter=expr.charAt(i);
            if(oneCharacter=='(' || oneCharacter=='[' 
                    || oneCharacter=='{'){
                //si es de apertura, lo guardo en la pila
                stack.push(String.valueOf(oneCharacter));
                
            }else if(oneCharacter==')' || oneCharacter==']' 
                    || oneCharacter=='}'){
                
                //en el caso de los cierres, tiene que coincidir que el elemento
                //inmediatamente anterior sea su homólogo de apertura
                //las expresiones intermedias, al ser cerradas, se eliminan
                //de la pila por lo que no interfieren
                if(!stack.isEmpty()){
                    switch (oneCharacter) {
                        case ')':
                            oneCharacter='(';
                            break;
                        case ']':
                            oneCharacter='[';
                            break;
                        case '}':
                            oneCharacter='{';
                            break;
                    }
                    if(!stack.pop().equals(String.valueOf(oneCharacter))){
                        correct=false;
                    }
                }else{
                    correct=false;
                }
            }
        }
        
        if(!stack.isEmpty()){
            correct=false;
        }
        
        return correct;
    }
}
