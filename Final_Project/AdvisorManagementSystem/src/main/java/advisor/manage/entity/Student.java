package advisor.manage.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    int sid;
    String name;
    String sex;
    int grade;

    public Student(int sid, String name, String sex, int grade) {
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.sid = sid;
    }
}
