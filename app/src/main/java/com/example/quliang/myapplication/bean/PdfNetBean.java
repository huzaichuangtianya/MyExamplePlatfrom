package com.example.quliang.myapplication.bean;

/**
 * Created by quliang on 2017/9/19.
 */

public class PdfNetBean {

    /**
     * filePath : http://127.0.0.1:8080/InnerService/file/1.PDF
     * fileName : 1.pdf
     */

    private String  filePath;
    private String  fileName;
    private boolean isLoad;
    private int index;

    public PdfNetBean(String filePath, String fileName, boolean isLoad,int index) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.isLoad = isLoad;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isLoad() {
        return isLoad;
    }

    public void setLoad(boolean load) {
        isLoad = load;
    }
}
