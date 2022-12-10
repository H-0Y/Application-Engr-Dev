package advisor.manage.sql;

import advisor.manage.mapper.AdviseMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.util.function.Consumer;

// create a SqlUtil Class to encapsulate the operations with SqlSession
public class SqlUtil {
    private SqlUtil(){}
    // create a SqlSessionFactory
    private static SqlSessionFactory factory;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // encapsulate the operation where sqlSession get an AdviseMapper
    public static void doSqlWork(Consumer<AdviseMapper> consumer) {
        try(SqlSession sqlSession = factory.openSession(true)){
            AdviseMapper adviseMapper = sqlSession.getMapper(AdviseMapper.class);
            consumer.accept(adviseMapper);
        }
    }
}
