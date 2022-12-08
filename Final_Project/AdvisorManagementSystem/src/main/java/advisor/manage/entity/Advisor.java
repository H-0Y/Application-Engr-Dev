package advisor.manage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Advisor {
    int aid;
    String name;
    String sex;


    public Advisor(int aid, String name, String sex) {
        this.aid = aid;
        this.name = name;
        this.sex = sex;

    }
}
