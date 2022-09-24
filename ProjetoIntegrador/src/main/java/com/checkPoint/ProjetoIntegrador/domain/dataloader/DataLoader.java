package com.checkPoint.ProjetoIntegrador.domain.dataloader;

import com.checkPoint.ProjetoIntegrador.domain.model.Usuario;
import com.checkPoint.ProjetoIntegrador.domain.model.UsuarioRoles;
import com.checkPoint.ProjetoIntegrador.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("teste");
        String password2 = bCryptPasswordEncoder.encode("teste2");
        Usuario usuario = new Usuario("lucasVidaLoka", password, UsuarioRoles.ROLE_USER);
        Usuario usuario2 = new Usuario("lucasVidaDeBoa", password2, UsuarioRoles.ROLE_ADMIN);
        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario2);
    }
}
