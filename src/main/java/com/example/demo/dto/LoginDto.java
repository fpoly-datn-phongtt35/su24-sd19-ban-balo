package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
