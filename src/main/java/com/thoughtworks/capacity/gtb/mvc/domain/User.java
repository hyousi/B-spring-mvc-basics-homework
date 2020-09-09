package com.thoughtworks.capacity.gtb.mvc.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Generated
    private Integer id;

    @NotNull(message = "用户名不为空")
    @Size(min = 3, max = 10, message = "用户名不合法")
    @Pattern(regexp = "^[a-zA-z0-9_]*$", message = "用户名不合法")
    private String username;

    @NotNull(message = "密码不为空")
    @Size(min = 5, max = 15, message = "密码不合法")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
