package com.teamprj.nubigo.jwt.auth;

import com.teamprj.nubigo.entity.Users;
import com.teamprj.nubigo.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users userEntity = userJpaRepository.findByuserId(username);

        return new PrincipalDetails(userEntity);
    }
}
