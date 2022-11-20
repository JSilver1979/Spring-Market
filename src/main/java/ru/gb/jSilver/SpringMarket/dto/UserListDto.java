package ru.gb.jSilver.SpringMarket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.jSilver.SpringMarket.data.User;

@Data
@NoArgsConstructor
public class UserListDto {
    private String login;
    private String password;

    public UserListDto(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
    }
}
