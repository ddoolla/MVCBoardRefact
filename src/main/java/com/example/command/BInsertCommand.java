package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;
import com.example.exception.CommandCustomException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BInsertCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandCustomException {
        BDao bDao = BDao.getInstance();
        BDto bDto = new BDto();

        bDto.setbName(request.getParameter("bName"));
        bDto.setbTitle(request.getParameter("bTitle"));
        bDto.setbContent(request.getParameter("bContent"));

        boolean result = bDao.insertBoard(bDto);

        if (!result) {
            throw new CommandCustomException("게시물 등록 실패");
        }
    }

}
