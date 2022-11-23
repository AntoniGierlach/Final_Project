package pl.coderslab.finalproject.model.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.finalproject.model.Role;
import pl.coderslab.finalproject.model.User;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;

@Data
@NoArgsConstructor
public class RegisterDto {

    @NotNull
    private String name;
    @NotNull
    private String username;
    @Size(min = 6)
    private String password;
    @Size(min = 6)
    private String confirm_password;

    public User map(Role role) {
        if (!this.password.equals(this.confirm_password)) {
            return null;
        }
        User user = new User();
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEnabled(1);
        user.setRoles(new HashSet<>(List.of(role)));
        return user;
    }
}