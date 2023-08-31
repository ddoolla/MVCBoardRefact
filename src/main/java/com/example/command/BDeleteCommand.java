package com.example.command;

import com.example.dao.BDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BDeleteCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BDao bDao = BDao.getInstance();
        String id = request.getParameter("id");

        int cnt = bDao.deleteBoard(id);

        if (cnt == 1) {
            System.out.println("게시글 삭제 성공");
        } else {
            System.out.println("게시글 삭제 실패");
        }
    }
}
