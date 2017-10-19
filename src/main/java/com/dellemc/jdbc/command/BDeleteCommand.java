 package com.dellemc.jdbc.command;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.ui.*;

import com.dellemc.jdbc.dao.*;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		BDao dao = new BDao();
		dao.delete(bId);
		
	}

}
