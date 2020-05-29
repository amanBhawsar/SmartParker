package com.example.smartparker.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class indislot {

    @SerializedName("slotid")
    @Expose
    private String slotid;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getSlotid() {
        return slotid;
    }

    public void setSlotid(String slotid) {
        this.slotid = slotid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "indislot{" +
                "slotid='" + slotid + '\'' +
                ", status=" + status +
                '}';
    }
}