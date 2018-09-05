package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liulanhua on 2018/9/4.
 */
public class Message implements Serializable{

    private String id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }


}
