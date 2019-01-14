package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * ES 新增请求参数
 * Created by liunanhua on 2018/12/6.
 */
public class EsInsertReq extends EsBaseReq{

    /**
     * 是否是全量
     * 全量 :true, 增量：false
     */
    private boolean isFull;

    /**
     * 导入批次号
     */
    private long batchNum;

    /**
     * mq批量消费批次号
     */
    private long mqBatch;

    /**
     * 批量数量
     */
    private int recordCount;


    /**
     * 待保存的数据
     * Map key列名，value：值
     */
    private Map<String,Object> records;


    public Map<String, Object> getRecords() {
        return records;
    }

    public void setRecords(Map<String, Object> records) {
        this.records = records;
    }


    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public long getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(long batchNum) {
        this.batchNum = batchNum;
    }

    public long getMqBatch() {
        return mqBatch;
    }

    public void setMqBatch(long mqBatch) {
        this.mqBatch = mqBatch;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    @Override
    public String toString() {
        return "EsInsertReq{" +
                "isFull=" + isFull +
                ", batchNum=" + batchNum +
                ", mqBatch=" + mqBatch +
                ", recordCount=" + recordCount +
                ", records=" + (CollectionUtils.isEmpty(records)? null: JSON.toJSONString(records)) +
                '}';
    }
}
