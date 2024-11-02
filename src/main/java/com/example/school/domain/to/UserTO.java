package com.example.school.domain.to;

import com.example.school.domain.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserTO {

  @NotBlank(message = "Nome é Obrigatório")
  private String name;

  @NotBlank(message = "Email é Obrigatório")
  private String email;

  private String phone;

  @NotNull(message = "Papel do Usuário é Obrigatório")
  private Role role;

}
