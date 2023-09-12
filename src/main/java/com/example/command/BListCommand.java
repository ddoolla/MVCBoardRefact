package com.example.command;

import com.example.dao.BDao;
import com.example.dto.BDto;
import com.example.util.Paging;
import com.example.util.PagingEx;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class BListCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BDao bDao = BDao.getInstance();
        int allPost = bDao.countAll();

        int pageNum = 1;
        if (request.getParameter("page") != null) {
            pageNum = Integer.parseInt(request.getParameter("page"));
        }
        int pageSize = 10;
        int blockSize = 5;
        int start =  (pageNum - 1) * pageSize;

        // Paging
//        String pagingStr = Paging.pagingStr(bDao.countAll(), pageBlock, pageSize, pageNumber);
//        request.setAttribute("pagingStr", pagingStr);

        // PagingEx
        PagingEx pagingEx = new PagingEx(allPost, pageNum, pageSize, blockSize);
        request.setAttribute("pagingEx", pagingEx);
        System.out.println("pagingEx = " + pagingEx);

        request.setAttribute("bDtos", bDao.boardAll(start, pageSize));
        request.setAttribute("totalCnt", (allPost - start));
    }
}
