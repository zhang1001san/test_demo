package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) throws IOException {
        // 1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 2.创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        // 3.使用工厂生产 SqlSession 对象
        SqlSession session = factory.openSession();
        // 4.使用 SqlSession 创建 dao 的代理对象
        UserMapper userDao = session.getMapper(UserMapper.class);
        // 5.使用代理对象执行方法
        List<Map<String, Object>> list =
                userDao.getList();
        System.out.println(list);
        // 6.关闭资源
        inputStream.close();
        session.close();
    }
}
