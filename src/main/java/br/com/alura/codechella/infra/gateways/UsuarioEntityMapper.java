package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario domain){
        return new UsuarioEntity(domain.getCpf(), domain.getNome(), domain.getNascimento(), domain.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario(entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }
}
