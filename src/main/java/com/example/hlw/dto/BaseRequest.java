package com.example.hlw.dto;

import java.io.Serializable;

/**
 * Created by hlw on 2018/1/2.
 */
public class BaseRequest implements Serializable {

    private String cmd;
    private String data;
    private String traceId;
    private String version;
    private String signData;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }



}
