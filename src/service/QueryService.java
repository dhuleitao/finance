package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import dao.CommandDao;
import dao.MessageDao;
import util.Iconst;

/**
 * 查询相关的业务功�?
 */
public class QueryService {
	public List<Message> queryMessageList(String command,String description) {
		// 组织消息对象
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		MessageDao messageDao = new MessageDao();
		// 根据条件查询条数
		int totalNumber = messageDao.count(message);
		// 组织分页查询参数
	
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("message", message);
		// 分页查询并返回结�?
		return messageDao.queryMessageList(parameter);
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage() {
	
		MessageDao messageDao = new MessageDao();
		// 分页查询并返回结�?
		return messageDao.queryMessageListByPage();
	}
	
	
	/**
	 * 通过指令查询自动回复的内�?
	 * @param command 指令
	 * @return 自动回复的内�?
	
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	} */
	public String queryByCommand(String command) {
		MessageDao messageDao = new MessageDao();
		List<Message> commandList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = messageDao.queryMessageList(null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getCommand() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		Map<String,Object> parameter = new HashMap<String, Object>();
		Message message=new Message();
		message.setCommand(command);
		parameter.put("message", message);
		commandList = messageDao.queryMessageList(parameter);
		if(commandList.size() > 0) {
			
			int i = new Random().nextInt(commandList.size());
			return commandList.get(i).getContent();
		}
		
		return Iconst.NO_MATCHING_CONTENT;
		
	}
}


