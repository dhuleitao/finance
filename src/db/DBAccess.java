package db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库类
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接信�?
		Reader reader = Resources.getResourceAsReader("Configuration.xml");
		// 通过配置信息构建�?��SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过sqlSessionFactory打开�?��数据库会�?
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
