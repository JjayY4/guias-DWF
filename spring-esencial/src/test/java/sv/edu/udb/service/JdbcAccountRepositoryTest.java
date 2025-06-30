package sv.edu.udb.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sv.edu.udb.repository.implementation.JdbcAccountRepository;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //habilita mockito
public class JdbcAccountRepositoryTest {
    @Mock //es una simulacion de la interfaz(mockDataSource)
    private DataSource mockDataSource;

    @InjectMocks //es pa inyectar mocks en la instancia de la clase que estamos testeando
    private JdbcAccountRepository accountRepository;
    @BeforeEach
    void setUp() {
        //no se pone nada aqui ya que el metodo (findAccountNumber no es utilizado en dicha implementacion
    }
//test para findAccountNumber para verificar num para ID
    //verifica un return que no se anulo ni vacio
    @Test
    @DisplayName("Retorne un número de cuenta no nulo y no vacío para un ID de usuario")
    void shouldReturnNonEmptyAccountNumberForGivenUserId() {
        //definimos un userId para poder reflejar el contrato de la interfaz
        Integer userId = 123;
        //llamamos al metodo de testeo (findAccountNumber)
        String accountNumber = accountRepository.findAccountNumber(userId);
        //verificamos su comportamiento
        assertNotNull(accountNumber, "El número de cuenta no tiene q seer nulo");
        assertFalse(accountNumber.isEmpty(), "El número de cuenta no tiene q estar vacío");
    }
    //esta hace una prueba si el userId retorna valor nulo, no tiene un "exception" esta verifica el comportamiento actual
    //si se añaden validaciones, se modifica el test de acorde a que casos se presenten en la validacion
    @Test
    @DisplayName("Debe retornar un número de cuenta no nulo y no vacío incluso si el ID de usuario es nulo")
    void shouldReturnNonEmptyAccountNumberWhenUserIdIsNull() {
        Integer userId = null;
        String accountNumber = accountRepository.findAccountNumber(userId);
        assertNotNull(accountNumber, "El número de cuenta no debe de ser nulo");
        assertFalse(accountNumber.isEmpty(), "El número de cuenta no debería estar vacío");

    }

}
