package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    private static final String nomeValido = "Teste";
    private static final String emailValido = "email@provedor.com";
    private static final String nascimentoValido = "1991-05-15";
    private static final String nascimentoInvalido = "2007-07-15";
    private static final String cpfValido = "123.456.789-10";

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789", nomeValido, LocalDate.parse(nascimentoValido), emailValido));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Teste", LocalDate.parse(nascimentoValido), emailValido));
    }

    @Test
    public void naoDeveCadastrarUsuarioMenorDeIdade(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(cpfValido, nomeValido, LocalDate.parse(nascimentoInvalido), emailValido));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento(nomeValido, cpfValido, LocalDate.parse(nascimentoValido));
        Assertions.assertEquals(nomeValido, usuario.getNome());

        usuario = fabrica.incluiEndereco("12345-789", 10, "sem complemento");
        Assertions.assertEquals("sem complemento", usuario.getEndereco().getComplemento());
    }

}
