package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BReplyViewCommand implements BCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        BDao bDao = BDao.getInstance();
        BDto bDto = bDao.selectOne(id);

        request.setAttribute("bDto", bDto);
    }
}
