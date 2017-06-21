package com.dellemc.jdbc.command;

import java.util.*;

import org.springframework.ui.*;

import com.dellemc.jdbc.dao.*;
import com.dellemc.jdbc.dto.*;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// DB���� �޾ƿ� �����͸� jsp page�� DTO ��ü�� �Ѱ� ȭ�鿡 �ѷ��ְ���
		BDao dao = new BDao();
		ArrayList<BDto> dto = dao.list();
		
		model.addAttribute("list", dto);
		
	}

}
