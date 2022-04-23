package com.idat.idatapirest.security;

import com.idat.idatapirest.model.Users;
import com.idat.idatapirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JWTUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users usuario =repository.findByUsuario(username);

       if(usuario!=null){
           List<GrantedAuthority> granted  = new ArrayList<GrantedAuthority>();
           GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol());
           granted.add(authority);
            return new User(usuario.getUsuario(),new BCryptPasswordEncoder().encode(usuario.getContrasenia()),granted);
       }else {
           throw new UsernameNotFoundException("El usuario no existe");
       }

    }
}
