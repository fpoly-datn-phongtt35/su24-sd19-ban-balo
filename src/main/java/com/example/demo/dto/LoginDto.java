package com.example.demo.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginDto {

    @Email(message = "Vui lòng nhập đúng đinh dạng email!")
    @NotBlank(message = "Vui lòng nhập email !")
    String email;

    @NotBlank(message = "Vui lòng nhập password !")
    String password;
}
