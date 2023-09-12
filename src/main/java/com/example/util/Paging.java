package com.example.util;

public class Paging {

    public static String pagingStr(int totalPost, int pageBlock, int pageSize, int pageNumber) {
        // << < 1 | 2 | 3 | 4 | 5 > >>
        String pagingStr = "";

        int totalPage = (int) Math.ceil((double) totalPost / pageSize);
        int currentStartBlock = (((pageNumber - 1) / pageBlock) * pageBlock) + 1;
//        int currentEndBlock = ((pageNumber / pageBlock) + 1) * pageBlock;
        int currentEndBlock = Math.min((currentStartBlock + pageBlock - 1), totalPage);

        // << < 조건
        if (currentStartBlock > 1) {
            pagingStr += "<a href='list.do?page=1'> ≪ </a>"
                    + "<a href='list.do?page=" + (currentStartBlock - 1) + "'> < </a>";
        }

        // 1 | 2 | 3 | 4 | 5
        for (int i = currentStartBlock; i <= currentEndBlock; i++) {
            if (pageNumber == i) {
                pagingStr += "<span>" + i + "</span>";
            } else {
                pagingStr += "<a href='list.do?page=" + i + "'>" + i + "</a>";
            }
            if (i != currentEndBlock) pagingStr += " | ";
        }

        // > >> 조건
        if (totalPage > currentEndBlock) {
            pagingStr += "<a href='list.do?page=" + (currentEndBlock + 1) + "'> > </a>"
                    + "<a href='list.do?page=" + totalPage + "'> ≫ </a>";
        }
        return pagingStr;
    }

}
