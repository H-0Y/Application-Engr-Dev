package advisor.manage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Advised {
    int id;
    int sid;
    int aid;

    public Advised(int sid, int aid) {
        this.sid = sid;
        this.aid = aid;

    }
}
