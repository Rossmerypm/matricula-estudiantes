/*package com.mitocode.security;

import com.mitocode.model.User;
import com.mitocode.repo.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//COMO OBTENER LOS USUARIOS Y LOS ROLES DE MI BASE DE DATOS
//CLASE2
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final IUserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findOneByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> students = new ArrayList<>();
        String student = user.getStudent().getName();
        students.add(new SimpleGrantedAuthority(student));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), students);
    }
}*/