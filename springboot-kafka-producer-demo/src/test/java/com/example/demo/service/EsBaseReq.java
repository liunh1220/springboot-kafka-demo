package com.example.demo.service;


/**
 * ES 请求参数
 * Created by liunanhua on 2018/12/6.
 */
public class EsBaseReq extends BaseReq {


    /**
     * 文档索引
     */
    private String docIndex;

    /**
     * 别名
     */
    private String docAlias;


    /**
     * 文档类型
     */
    private String docType;


    /**
     * 文档id
     */
    private String docId;


    public String getDocAlias() {
        return docAlias;
    }

    public void setDocAlias(String docAlias) {
        this.docAlias = docAlias;
    }

    public String getDocIndex() {
        return docIndex;
    }

    public void setDocIndex(String docIndex) {
        this.docIndex = docIndex;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }


    @Override
    public String toString() {
        return "EsBaseReq{" +
                "docIndex='" + docIndex + '\'' +
                ", docType='" + docType + '\'' +
                ", docId='" + docId + '\'' +
                '}';
    }


}
