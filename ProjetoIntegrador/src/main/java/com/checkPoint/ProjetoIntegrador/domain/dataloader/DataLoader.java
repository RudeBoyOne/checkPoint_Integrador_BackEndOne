package com.checkPoint.ProjetoIntegrador.domain.dataloader;

import com.checkPoint.ProjetoIntegrador.domain.model.Usuario;
import com.checkPoint.ProjetoIntegrador.domain.model.UsuarioRoles;
import com.checkPoint.ProjetoIntegrador.domain.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {

    private IUsuarioRepository IUsuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("teste");
        String password2 = bCryptPasswordEncoder.encode("teste2");
        String password3 = bCryptPasswordEncoder.encode("1234");
        Usuario usuario = new Usuario("lucasVidaLoka", password, UsuarioRoles.ROLE_USER);
        Usuario usuario2 = new Usuario("lucasVidaDeBoa", password2, UsuarioRoles.ROLE_ADMIN);
        Usuario usuario3 = new Usuario("user", password3, UsuarioRoles.ROLE_USER);
        Usuario usuario4 = new Usuario("admin", password3, UsuarioRoles.ROLE_ADMIN);
        IUsuarioRepository.save(usuario);
        IUsuarioRepository.save(usuario2);
        IUsuarioRepository.save(usuario3);
        IUsuarioRepository.save(usuario4);
    }
}