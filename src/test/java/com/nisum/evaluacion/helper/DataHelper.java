package com.nisum.evaluacion.helper;

import com.nisum.evaluacion.dto.PhoneDto;
import com.nisum.evaluacion.dto.RegisterDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class DataHelper {

    public RegisterDto getRegisterDefaultEmpty() {
        return  new RegisterDto();
    }

    public RegisterDto getRegisterDefault() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setName("Jhon Doe");
        registerDto.setEmail("jhon.doe@example.cl");
        registerDto.setPassword("aB12");
        registerDto.setPhoneDtos(getPhonesDefault());
        return registerDto;
    }

    public Collection<PhoneDto> getPhonesDefault() {
        Collection<PhoneDto> phoneDtos = new ArrayList<>();
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setNumber("1234567890");
        phoneDto.setCitycode("1");
        phoneDto.setContrycode("56");
        phoneDtos.add(phoneDto);
        return phoneDtos;
    }

}

