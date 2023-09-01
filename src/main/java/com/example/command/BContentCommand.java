package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;
import com.example.exception.CommandCustomException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BContentCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandCustomException {
        String id = request.getParameter("id");
        BDao bDao = BDao.getInstance();

        boolean result = bDao.hitUpdate(id);

        // 클릭마다 히트 수 증가 성공 시 게시물 상세보기 접근 가능
        if (result) {
            BDto bDto = bDao.selectOne(id);
            request.setAttribute("bDto", bDto);
        } else {
            throw new CommandCustomException("게시물 상세보기 불가");
        }
    }
}
