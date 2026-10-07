package mycontacts;

import mycontacts.exceptions.FormatoInvalidoException;
import mycontacts.utils.Validador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorTest {

    @Test
    public void deveAceitarEmailValido() {
        // Se o e-mail estiver correto, o método não deve lançar nenhum erro
        assertDoesNotThrow(() -> Validador.validarEmail("matheus@gmail.com"));
    }

    @Test
    public void deveRejeitarEmailInvalido() {
        // Se faltar o @ ou o ponto, TEM de lançar a FormatoInvalidoException
        assertThrows(FormatoInvalidoException.class, () -> {
            Validador.validarEmail("matheus_sem_arroba.com");
        });
    }

    @Test
    public void deveAceitarTelefoneValido() {
        assertDoesNotThrow(() -> Validador.validarTelefone("85999887766"));
    }
}