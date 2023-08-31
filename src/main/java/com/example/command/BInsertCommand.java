package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class BInsertCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BDao bDao = BDao.getInstance();
        BDto bDto = new BDto();

        try {
            request.setCharacterEncoding("UTF-8");
            bDto.setbName(request.getParameter("bName"));
            bDto.setbTitle(request.getParameter("bTitle"));
            bDto.setbContent(request.getParameter("bContent"));

            int cnt = bDao.insertBoard(bDto);

            if (cnt == 1) {
                System.out.println("insertBoard() 성공");
            } else {
                System.out.println("insertBoard() 실패");
            }

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
