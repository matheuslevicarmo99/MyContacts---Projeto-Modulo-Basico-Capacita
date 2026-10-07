package mycontacts;

import mycontacts.exceptions.FormatoInvalidoException;
import mycontacts.utils.Validador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorTest {

    @Test
    public void deveAceitarEmailValido() {
        assertDoesNotThrow(() -> Validador.validarEmail("matheus@gmail.com"));
    }

    @Test
    public void deveRejeitarEmailInvalido() {
        assertThrows(FormatoInvalidoException.class, () -> {
            Validador.validarEmail("matheus_sem_arroba.com");
        });
    }

    @Test
    public void deveAceitarTelefoneValido() {
        assertDoesNotThrow(() -> Validador.validarTelefone("85999887766"));
    }
}