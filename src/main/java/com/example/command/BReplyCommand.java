package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class BReplyCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("UTF-8");
            BDao bDao = BDao.getInstance();
            BDto bDto = new BDto();

            bDto.setbName(request.getParameter("bName"));
            bDto.setbTitle(request.getParameter("bTitle"));
            bDto.setbContent(request.getParameter("bContent"));
            bDto.setbGroup(request.getParameter("bGroup"));
            bDto.setbStep(request.getParameter("bStep"));
            bDto.setbIndent(request.getParameter("bIndent"));

            System.out.println("bDto = " + bDto);

            int cnt = bDao.insertReply(bDto);

            if (cnt == 1) {
                System.out.println("답변 등록 성공");
            } else {
                System.out.println("답변 등록 실패");
            }

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
