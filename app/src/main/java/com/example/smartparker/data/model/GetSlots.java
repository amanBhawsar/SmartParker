package com.example.smartparker.data.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSlots {

    @SerializedName("slots")
    @Expose
    private List<Slot> slots = null;

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "GetSlots{" +
                "slots=" + slots +
                '}';
    }
}
