package advisor.manage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    String userName;
    String password;
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
