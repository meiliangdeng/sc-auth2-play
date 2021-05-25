package me.coast.auth.server.domain.entity;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
}
