package com.example.dto;

public class BDto {

    private String bId;
    private String bName;
    private String bTitle;
    private String bContent;
    private String bDate;
    private String bHit;
    private String bGroup;
    private String bStep;
    private String bIndent;

    public BDto() {
    }

    public BDto(String bId, String bName, String bTitle, String bContent, String bDate, String bHit, String bGroup, String bStep, String bIndent) {
        this.bId = bId;
        this.bName = bName;
        this.bTitle = bTitle;
        this.bContent = bContent;
        this.bDate = bDate;
        this.bHit = bHit;
        this.bGroup = bGroup;
        this.bStep = bStep;
        this.bIndent = bIndent;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getbHit() {
        return bHit;
    }

    public void setbHit(String bHit) {
        this.bHit = bHit;
    }

    public String getbGroup() {
        return bGroup;
    }

    public void setbGroup(String bGroup) {
        this.bGroup = bGroup;
    }

    public String getbStep() {
        return bStep;
    }

    public void setbStep(String bStep) {
        this.bStep = bStep;
    }

    public String getbIndent() {
        return bIndent;
    }

    public void setbIndent(String bIndent) {
        this.bIndent = bIndent;
    }

    @Override
    public String toString() {
        return "BDto{" +
                "bId='" + bId + '\'' +
                ", bName='" + bName + '\'' +
                ", bTitle='" + bTitle + '\'' +
                ", bContent='" + bContent + '\'' +
                ", bDate='" + bDate + '\'' +
                ", bHit='" + bHit + '\'' +
                ", bGroup='" + bGroup + '\'' +
                ", bStep='" + bStep + '\'' +
                ", bIndent='" + bIndent + '\'' +
                '}';
    }
}
