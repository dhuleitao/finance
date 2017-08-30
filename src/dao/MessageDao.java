package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Message;
import db.DBAccess;

/**
 * 和message表相关的数据库操�?
 */
public class MessageDao {
	
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(parameter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 根据查询条件查询消息列表的条�?
	 */
	public int count(Message message) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage() {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.query();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	public Message queryone(int id) {
		DBAccess dbAccess = new DBAccess();
	Message message = new Message();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			message= imessage.queryone(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return message;
	}
	/**
	 * 单条删除
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			
			sqlSession.delete("dao.IMessage.deleteOne", id);
			System.out.print("deleteone111111");
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
	 * 单条删除
	 */
	public void updatem(Map<String,Object> pp) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.update("dao.IMessage.updatem", pp);
		
			System.out.print("deleteone111111");
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
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.delete("Message.deleteBatch", ids);
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
	
	public void addMess(Message mm) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage mes = sqlSession.getMapper(IMessage.class);
			mes.insert(mm);
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
	 * 根据查询条件查询消息列表
	 */
//	public List<Message> queryMessageList(String command,String description) {
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","root");
//			StringBuilder sql = new StringBuilder("select ID a,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
//			List<String> paramList = new ArrayList<String>();
//			if(command != null && !"".equals(command.trim())) {
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if(description != null && !"".equals(description.trim())) {
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			for(int i = 0; i < paramList.size(); i++) {
//				statement.setString(i + 1, paramList.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			
//			while(rs.next()) {
//				Message message = new Message();
//				messageList.add(message);
//				message.setId(rs.getString("a"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
