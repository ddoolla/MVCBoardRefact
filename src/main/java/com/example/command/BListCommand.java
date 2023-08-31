package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class BListCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BDao bDao = BDao.getInstance();

        // 게시물 리스트
        ArrayList<BDto> bDtos = bDao.boardAll();

        // 게시물 전체 개수
        int totalCnt = bDao.countAll();

        request.setAttribute("totalCnt", totalCnt);
        request.setAttribute("bDtos", bDtos);
    }
}
