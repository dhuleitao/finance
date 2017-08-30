package dao;

import java.util.List;
import java.util.Map;

import bean.CommandContent;
import bean.Message;

/**
 * 与Message配置文件相对应的接口
 */
public interface IMessage {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter);
	
	/**
	 * 根据查询条件查询消息列表的条�?
	 */
	public void deleteOne(int id);
	public int count(Message message);
	public void insert(Message message);
	
	/**
	 * 鎵归噺鏂板
	 */

	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter);

	public List<Message> query();



	public Message queryone(int id);
}
