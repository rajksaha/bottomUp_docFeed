package com.bottomUp.myBatis;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by raj on 12/12/2020.
 */
public class MyBatisConfig {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("resources/myBatis/mybatis-jdbc-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }


    /*<property name="driverClassName" value="com.mysql.jdbc.Driver"/>
<property name="url" value="jdbc:mysql://bottomupdbserver.cicctmjt3s9o.us-east-2.rds.amazonaws.com:3306/doctor_feed?useUnicode=yes&amp;characterEncoding=UTF-8&amp;autoReconnect=true&amp;pinGlobalTxToPhysicalConnection=true"/>
<property name="username" value="rajksaha"/>
<property name="password" value="5tgb$rfv"/>
<property name="maxActive" value="30"/>
<property name="maxIdle" value="10"/>
<property name="maxWait" value="50000"/>
<property name="validationQuery" value="SELECT 1"/>*/
}
