package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BContentCommand implements BCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");

        BDao bDao = BDao.getInstance();

        // 클릭마다 히트 수 증가
        int cnt = bDao.hitUpdate(id);

        if (cnt == 1) {
            System.out.println("히트 증가 성공");
        } else {
            System.out.println("히트 증가 실패");
        }

        // 게시물 1개 조회
        BDto bDto = bDao.selectOne(id);

        request.setAttribute("bDto", bDto);
    }
}
