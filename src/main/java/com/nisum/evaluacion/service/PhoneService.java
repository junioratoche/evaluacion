package com.nisum.evaluacion.service;

import com.nisum.evaluacion.dto.RegisterDto;
import com.nisum.evaluacion.model.Phone;
import com.nisum.evaluacion.model.Users;
import com.nisum.evaluacion.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Transactional
    public Collection<Phone> saveAll(Users users, RegisterDto registerDto) {
        log.info("saveAll | users={}, registerDto={}", users, registerDto);
        return saveAll(Phone.from(users, registerDto));
    }

    @Transactional
    public Collection<Phone> saveAll(Collection<Phone> phones) {
        log.info("saveAll | phones={}",phones);
        return phoneRepository.saveAll(phones);
    }
}
