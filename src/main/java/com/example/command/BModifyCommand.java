package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BModifyCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BDao bDao = BDao.getInstance();
        BDto bDto = new BDto();

        bDto.setbId(request.getParameter("bId"));
        bDto.setbName(request.getParameter("bName"));
        bDto.setbTitle(request.getParameter("bTitle"));
        bDto.setbContent(request.getParameter("bContent"));
//        System.out.println("bDto = " + bDto);

        int cnt = bDao.modifyContent(bDto);

        if (cnt == 1) {
            System.out.println("게시글 수정 성공");
        } else {
            System.out.println("게시글 수정 실패");
        }

    }
}
