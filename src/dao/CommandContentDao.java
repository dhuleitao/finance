package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.CommandContent;
import db.DBAccess;

/**
 * 和command_content表相关的数据库操�?
 */
public class CommandContentDao {
	
	/**
	 * 通过JDBC方式批量新增
	 */
	public void insertBatchByJdbc(List<CommandContent> contentList) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","root");
			String insertSql = "insert into COMMAND_CONTENT(CONTENT,COMMAND_ID) values(?,?)";
			PreparedStatement statement = conn.prepareStatement(insertSql);
			for(CommandContent content : contentList) {
				statement.setString(1, content.getContent());
				statement.setString(2, content.getCommandId());
				statement.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量新增
	 */
	public void insertBatch(List<CommandContent> contentList) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			ICommandContent commandContent = sqlSession.getMapper(ICommandContent.class);
			commandContent.insertBatch(contentList);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	/**
	 * 批量新增
	 */
	public void insertOne(CommandContent contentList) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			ICommandContent commandContent = sqlSession.getMapper(ICommandContent.class);
			commandContent.insertOne(contentList);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}