package com.nisum.evaluacion.service;

import com.nisum.evaluacion.dto.RegisterDto;
import com.nisum.evaluacion.exception.ExampleNisumException;
import com.nisum.evaluacion.helper.CryptoHelper;
import com.nisum.evaluacion.helper.JwtHelper;
import com.nisum.evaluacion.helper.MessageHelper;
import com.nisum.evaluacion.model.Users;
import com.nisum.evaluacion.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UsersService {

    private final UsersRepository usersRepository;
    private final CryptoHelper cryptoHelper;
    private final JwtHelper jwtHelper;

    @Transactional
    public Users save(RegisterDto registerDto) {
        log.info("save | registerDto={}", registerDto);
        String password = cryptoHelper.encode(registerDto.getPassword());
        String token = jwtHelper.createToken(registerDto.getEmail());
        return save(Users.from(registerDto, password, token));
    }

    @Transactional
    public Users save(Users users) {
        log.info("save | users={}", users);
        return usersRepository.save(users);
    }

    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public void validNotExistByEmail(String email) throws ExampleNisumException {
        Optional<Users> users = findByEmail(email);
        if (users.isPresent()) {
            throw new ExampleNisumException(MessageHelper.MESSAGE_EMAIL_EXISTS);
        }
    }
}
