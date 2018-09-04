import com.leave.dao.leaveMapper;
import com.leave.po.Leave;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class leaveTest {

    @Test
    public void testMapper() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);

        try{
            Leave leave = new Leave("Martin","snow day is today!");

            leaveMapper mapper = openSession.getMapper(leaveMapper.class);
            mapper.addLeave(leave);
//            openSession.commit();
            List<Leave> leave1 = mapper.queryAll();
            System.out.println(leave1);

        }finally {
            openSession.close();
        }
    }
}
