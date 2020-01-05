package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlUtil {
    private static SqlSessionFactory factory;
    static {
        // 1.读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
    }

    public static SqlSession getSqlSession(){
        return factory.openSession();
    }
}
