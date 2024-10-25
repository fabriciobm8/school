package com.example.school.domain.to;

import com.example.school.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTO {

  @NotNull
  private String name;

  @NotNull
  private String email;

  private String phone;

  private Role role;

}
