package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivo {

    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-00", "João", LocalDate.parse("1990-10-15"), "joao@provedor.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-00", "Maria", LocalDate.parse("1990-10-15"), "maria@provedor.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-00", "José", LocalDate.parse("1990-10-15"), "jose@provedor.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-00", "Carlos", LocalDate.parse("1990-10-15"), "carlos@provedor.com"));

        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");

//        System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
    }

}
