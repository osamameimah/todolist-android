package com.example.os;

public class task {

    private Boolean cheack;

    private String name;

    public task() {
    }

    public String getTaskName() {
        return name;
    }

    public task(String taskName, Boolean isChecked) {
        this.name = taskName;
        this.cheack = isChecked;
    }


    public void setTaskName(String taskName) {
        this.name = taskName;
    }

    public void setIsChecked(Boolean checked) {
        cheack = checked;
    }

    public Boolean getIsChecked() {
        return cheack;
    }


}
