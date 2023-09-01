package com.example.command;

import com.example.dao.BDao;
import com.example.exception.CommandCustomException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BDeleteCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandCustomException {
        BDao bDao = BDao.getInstance();
        String id = request.getParameter("id");

        boolean result = bDao.deleteBoard(id);

        if (!result) {
            throw new CommandCustomException("게시물 삭제 실패");
        }
    }
}
