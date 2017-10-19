package com.dellemc.jdbc.controller;

import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.dellemc.jdbc.command.*;
import com.dellemc.jdbc.util.Constant;

@Controller
public class BoardController {
	
	BCommand command;
	
	public JdbcTemplate template;
 
	@Autowired
	public void setTemplete(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list..()");
		
		BCommand command = new BListCommand();
		command.execute(model);
		
		//list.jsp
		return "list";
	}
	
	@RequestMapping("/writeView")
	public String write_view(Model model){
		System.out.println("writeVew()");
		
		return "write_view";
	}
		
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("writing()");
			
		model.addAttribute("request", request);
		BCommand  command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}	
	
	@RequestMapping("/contentView")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("contentView()");
			
		model.addAttribute("request", request);
		BCommand command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
		
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modifyView()");
					
		model.addAttribute("request", request);
		BCommand  command = new BModifyCommand();
		command.execute(model);
				
		return "redirect:list";
			
	}
	
	@RequestMapping("/replyView")
	public String reply_view(HttpServletRequest request, Model model){
		System.out.println("replyView()");
			
		model.addAttribute("request", request);
		BCommand  command = new BReplyViewCommand();
		command.execute(model);
		System.out.println("replyViewing()");
		return "reply_view";
	}		
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply()");
			
		model.addAttribute("request", request);
		BCommand  command = new BReplyCommand();
		command.execute(model);
		System.out.println("replyViewed()");
		return "redirect:list";
	}	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete()");
			
		model.addAttribute("request", request);
		BCommand  command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}	
}
