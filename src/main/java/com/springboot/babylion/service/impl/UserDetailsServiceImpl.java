package com.springboot.babylion.service.impl;

import com.springboot.babylion.data.repository.BabyLionRepository;
import com.springboot.babylion.data.repository.UserRepository;
import com.springboot.babylion.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("[loadUserByUsername] : {} ",email);
        return userRepository.getByEmail(email);
    }
}
