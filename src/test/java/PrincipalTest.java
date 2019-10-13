import dao.postgresql.AutorizadorDAOPostgreSQL;
import junit.framework.TestCase;
import modelo.Autorizador;
import modelo.Validador;
import org.junit.Test;

public class PrincipalTest extends TestCase {
    Autorizador autorizador = new Autorizador();
    AutorizadorDAOPostgreSQL dao = new AutorizadorDAOPostgreSQL();
    Validador validador = new Validador();

    @Test
    public void testProcedimento(){
        autorizador.setNr_procedimento(1234);
        assertTrue(dao.validarProcedimento(autorizador));

        autorizador.setNr_procedimento(999999);
        assertFalse(dao.validarProcedimento(autorizador));
    }

    @Test
    public void testValidarSexo (){
        assertTrue(validador.validarSexo("F"));
        assertTrue(validador.validarSexo("m"));
        assertFalse(validador.validarSexo("g"));
    }

    @Test
    public void testValidarNumeroNegativo (){
        assertTrue(validador.validarNumeroNegativo(14278));
        assertFalse(validador.validarNumeroNegativo(-999));
    }
}
