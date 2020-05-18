package com.kang.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.server.SocketServer;

/**
　 * <p>Title: WebSocketController</p> 
　 * <p>Description: websocket 消息推送(个人和广播)</p> 
　 * @author CK 
　 * @date 2020年5月18日
 */
@Controller
public class WebSocketController {

//    @Autowired
//    private SocketServer socketServer;

	/**
	 *<p>Title: idnex</p> 
	 *<p>Description: 客户端页面</p> 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String idnex() {

		return "index";
	}

	/**
	 *<p>Title: admin</p> 
	 *<p>Description: 服务端页面</p> 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		int num = SocketServer.getOnlineNum();
		List<String> list = SocketServer.getOnlineUsers();

		model.addAttribute("num", num);
		model.addAttribute("users", list);
		return "admin";
	}

	/**
	 *<p>Title: sendmsg</p> 
	 *<p>Description: 个人信息推送</p> 
	 * @param msg
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "sendmsg", method = RequestMethod.GET)
	@ResponseBody
	public String sendmsg(String msg, String username) {
		// 第一个参数 :msg 发送的信息内容
		// 第二个参数为用户长连接传的用户人数
		String[] persons = username.split(",");
		SocketServer.SendMany(msg, persons);
		return "success";
	}

	/**
	 *<p>Title: sendAll</p> 
	 *<p>Description: 推送给所有在线用户</p> 
	 * @param msg
	 * @return
	 */
	@RequestMapping(value = "sendAll", method = RequestMethod.GET)
	@ResponseBody
	public String sendAll(String msg) {
		SocketServer.sendAll(msg);
		return "success";
	}
}
