package com.example.school.domain.to;

import com.example.school.domain.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserTO {

  @NotBlank
  private String name;

  @NotBlank
  private String email;

  private String phone;

  @NotNull
  private Role role;

}
