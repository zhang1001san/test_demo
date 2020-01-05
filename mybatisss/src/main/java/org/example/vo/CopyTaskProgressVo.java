package org.example.vo;

import org.example.enums.ProgressStatusEnum;

public class CopyTaskProgressVo {
    String taskId;
    String dcName;
    double progress;
    ProgressStatusEnum progressStatus;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public ProgressStatusEnum getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProgressStatusEnum progressStatus) {
        this.progressStatus = progressStatus;
    }
}
