package dev.rishabh.userservice.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.rishabh.userservice.models.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@JsonDeserialize(as = CustomSpringGrantedAuthority.class)
@NoArgsConstructor
@AllArgsConstructor
public class CustomSpringGrantedAuthority implements GrantedAuthority {
    private Role role;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return role.getRole();
    }
}
