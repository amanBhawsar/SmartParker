package com.example.smartparker.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slot {

    @SerializedName("slotid")
    @Expose
    private Integer slotid;

    @Override
    public String toString() {
        return "Slot{" +
                "slotid=" + slotid +
                ", status=" + status +
                '}';
    }

    @SerializedName("status")
    @Expose
    private Integer status;

    public Integer getSlotid() {
        return slotid;
    }

    public void setSlotid(Integer slotid) {
        this.slotid = slotid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}