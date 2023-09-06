package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;
import com.example.exception.CommandCustomException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BModifyCommand implements BCommand {
    private BDto requestToBDto(HttpServletRequest request) {
        BDto bDto = new BDto();
        bDto.setbId(request.getParameter("bId"));
        bDto.setbName(request.getParameter("bName"));
        bDto.setbTitle(request.getParameter("bTitle"));
        bDto.setbContent(request.getParameter("bContent"));
        return bDto;
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandCustomException {
        BDto requestDto = requestToBDto(request);
        
        BDao dao = BDao.getInstance();
        boolean exists = dao.existsById(requestDto.getId());
        if (exists == false) throw new CommandCustomException("게시물이 존재하지 않습니다.");
            
        boolean result = dao.modifyContent(requestToBDto(request));
        if (result == false) throw new CommandCustomException("게시물 수정 실패");
    }
}
