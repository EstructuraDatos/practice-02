package ed.x02;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author dorian
 */
public class checkTest {
    @Test
    public void testing() {
        String expresionCorrecta="3+4*((4/[66/5])+{((2+3)*4)*[2-5]})";
        String expresionIncorrecta="3+4/(5+5))";
        String expresionIncorrecta2="(5+6*(3/4)";
        
        assertFalse(check.isCorrect(expresionIncorrecta));
        assertFalse(check.isCorrect(expresionIncorrecta2));
        assertTrue(check.isCorrect(expresionCorrecta));
    }
}
