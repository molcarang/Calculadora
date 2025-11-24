import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {

    @Test
    public void testOperacionesBasicas() {
        assertEquals(5, Calculadora.sumar(2, 3), 0.0001);
        assertEquals(2, Calculadora.restar(5, 3), 0.0001);
        assertEquals(12, Calculadora.multiplicar(4, 3), 0.0001);
        assertEquals(5, Calculadora.dividir(10, 2), 0.0001);
    }
    
}