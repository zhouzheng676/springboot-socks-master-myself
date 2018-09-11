package com.hehe.chat;


import java.util.Date;

import com.alibaba.fastjson.JSON;

import lombok.Data;

/**
 * WebSocket 聊天消息类
 */
@Data
public class Message
{

	public static final String ENTER = "ENTER";
	public static final String SPEAK = "SPEAK";
	public static final String QUIT = "QUIT";

	private String type;// 消息类型

	private String username; // 发送人

	private String msg; // 发送消息

	private int onlineCount; // 在线用户数
	private long msgDate;

	public Message(String type2, String username2, String msg2, int onlineTotal, long msgDate2)
	{
		this.msg = msg2;
		this.onlineCount = onlineTotal;
		this.username = username2;
		this.type = type2;
		this.msgDate = msgDate2;
	}

	public long getMsgDate()
	{
		return msgDate;
	}

	public void setMsgDate(long msgDate)
	{
		this.msgDate = msgDate;
	}

	public Message()
	{

	}

	public static String jsonStr(String type, String username, String msg, int onlineTotal,long msgDate)
	{
		return JSON.toJSONString(new Message(type, username, msg, onlineTotal,msgDate));
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public int getOnlineCount()
	{
		return onlineCount;
	}

	public void setOnlineCount(int onlineCount)
	{
		this.onlineCount = onlineCount;
	}

}
