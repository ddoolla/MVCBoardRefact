package com.example.util;

public class PagingEx {

    private int totalPage; // 전체 페이지 수
    private int allPost; // 전체 게시글 수
    private int pageNum; // 현재 페이지 번호
    private int pageSize; // 한 페이지 게시글 수
    private int blockSize; // 한 블록당 페이지 개수
    private int blockStartNum; // 현재 페이지 블록의 시작 번호
    private int blockEndNum; // 현재 페이지 블록의 끝 번호
    private boolean firstPage; // 첫 페이지로 가는 조건
    private boolean preBlock; // 이전 블록으로 가는 조건
    private boolean nextBlock; // 다음블록으로 가는 조건
    private boolean lastPage; // 맨끝 페이지로 가는 조건

    public PagingEx(int allPost, int pageNum, int pageSize, int blockSize) {
        this.allPost = allPost;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.blockSize = blockSize;

        this.totalPage = (int) Math.ceil((double) allPost / pageSize);
        this.blockStartNum = ((pageNum - 1) / blockSize) * blockSize + 1;
        this.blockEndNum = Math.min((blockStartNum + blockSize - 1), totalPage);

        if (blockStartNum > 1) {
            this.firstPage = true;
            this.preBlock = true;
        }

        if (totalPage > blockEndNum) {
            this.nextBlock = true;
            this.lastPage = true;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getAllPost() {
        return allPost;
    }

    public void setAllPost(int allPost) {
        this.allPost = allPost;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getBlockStartNum() {
        return blockStartNum;
    }

    public void setBlockStartNum(int blockStartNum) {
        this.blockStartNum = blockStartNum;
    }

    public int getBlockEndNum() {
        return blockEndNum;
    }

    public void setBlockEndNum(int blockEndNum) {
        this.blockEndNum = blockEndNum;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isPreBlock() {
        return preBlock;
    }

    public void setPreBlock(boolean preBlock) {
        this.preBlock = preBlock;
    }

    public boolean isNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(boolean nextBlock) {
        this.nextBlock = nextBlock;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PagingEx{" +
                "totalPage=" + totalPage +
                ", allPost=" + allPost +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", blockSize=" + blockSize +
                ", blockStartNum=" + blockStartNum +
                ", blockEndNum=" + blockEndNum +
                ", firstPage=" + firstPage +
                ", preBlock=" + preBlock +
                ", nextBlock=" + nextBlock +
                ", lastPage=" + lastPage +
                '}';
    }
}
