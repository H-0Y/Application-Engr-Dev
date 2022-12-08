package advisor.manage.mapper;

import advisor.manage.entity.Advised;
import advisor.manage.entity.Advisor;
import advisor.manage.entity.Student;
import advisor.manage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdviseMapper {
    @Insert("insert into student(sid, name, sex, grade) values(#{sid}, #{name}, #{sex}, #{grade})")
    int addStudent(Student student);

    @Insert("insert into advisor(aid, name, sex) values(#{aid}, #{name}, #{sex})")
    int addAdvisor(Advisor advisor);

    @Insert("insert into advised(sid, aid) value(#{sid}, #{aid})")
    int addAdvised(@Param("sid") int sid, @Param("aid") int bid);

//    @Results({
//            @Result(column = "id", property = "id", id = true),
//            @Result(column = "sid", property = "student", one = @One(select = "getStudentBySid")),
//            @Result(c
//            olumn = "bid", property = "book", one = @One(select = "getBookByBid")),
//    })

    @Select("select * from advised")
    List<Advised> getAdvisedList();
    @Select("select * from student")
    List<Student> getStudentList();

    @Select("select * from advisor")
    List<Advisor> getAdvisorList();

    @Select("select * from student where sid = #{sid}")
    Student getStudentBySid(int sid);

    @Select("select * from advisor where aid = #{aid}")
    Advisor getAdvisorByAid(int aid);

    @Select("select * from advised where id = #{id}")
    Advised getAdvisedById(int id);

    @Select("select * from users where username = #{username} and password = #{password}")
    User loginCheck(@Param("username") String userName, @Param("password") String password);

    @Delete("delete from student where sid = #{sid}")
    int deleteStudentBySid(int sid);

    @Delete("delete from advisor where aid = #{aid}")
    int deleteAdvisorByAid(int aid);

    @Delete("delete from advised where id = #{id}")
    int deleteAdvisedById(int id);

    @Insert("insert into users(username, password) values(#{userName}, #{password})")
    int addUser(User user);

    @Delete("delete from users where username = #{username}")
    int deleteUser(String username);
}
