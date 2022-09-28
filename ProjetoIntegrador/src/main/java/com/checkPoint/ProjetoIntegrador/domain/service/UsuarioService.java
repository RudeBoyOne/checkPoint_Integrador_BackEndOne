package com.checkPoint.ProjetoIntegrador.domain.service;

import com.checkPoint.ProjetoIntegrador.domain.exception.RecursoNaoEncontradoException;
import com.checkPoint.ProjetoIntegrador.domain.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService implements UserDetailsService {

    private IUsuarioRepository IUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return IUsuarioRepository.findByLogin(login)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado, tente novamente!"));
    }

}
