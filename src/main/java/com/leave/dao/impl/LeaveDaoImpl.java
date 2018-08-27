package com.leave.dao.impl;

import com.leave.dao.LeaveDao;
import com.leave.dao.leaveMapper;
import com.leave.po.Leave;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName LeaveDaoImpl
 * @Description
 * @Author martind
 * @Date 2018/8/25 16:57
 **/
@Repository
public class LeaveDaoImpl implements LeaveDao {

    @Override
    public void addLeave(Leave leave) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);

        try{
            leaveMapper mapper = openSession.getMapper(leaveMapper.class);
            mapper.insertLeave(leave);
//            openSession.commit();
            List<Leave> leave1 = mapper.queryAll();
            System.out.println(leave1);

        }finally {
            openSession.close();
        }
    }
}
