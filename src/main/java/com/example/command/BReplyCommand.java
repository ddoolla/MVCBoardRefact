package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;
import com.example.exception.CommandCustomException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BReplyCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BDao bDao = BDao.getInstance();
        BDto bDto = new BDto();

        bDto.setbName(request.getParameter("bName"));
        bDto.setbTitle(request.getParameter("bTitle"));
        bDto.setbContent(request.getParameter("bContent"));
        bDto.setbGroup(request.getParameter("bGroup"));
        bDto.setbStep(request.getParameter("bStep"));
        bDto.setbIndent(request.getParameter("bIndent"));

        boolean result = bDao.insertReply(bDto);

        if (!result) {
            throw new CommandCustomException("답변을 등록할 수 없습니다.");
        }


    }
}
