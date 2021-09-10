package com.nisum.evaluacion.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nisum.evaluacion.helper.MessageHelper;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneDto {

    @NotNull(message = MessageHelper.MESSAGE_NOT_NULL)
    private String number;

    @NotNull(message = MessageHelper.MESSAGE_NOT_NULL)
    private String citycode;

    @NotNull(message = MessageHelper.MESSAGE_NOT_NULL)
    private String contrycode;
}