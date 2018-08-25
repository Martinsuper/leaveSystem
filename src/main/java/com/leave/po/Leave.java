package com.leave.po;

/**
 * @ClassName Leave
 * @Description
 * @Author martind
 * @Date 2018/8/25 16:45
 **/
public class Leave {
    private Long id;
    private String leaveName;
    private String leaveText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public String getLeaveText() {
        return leaveText;
    }

    public void setLeaveText(String leaveText) {
        this.leaveText = leaveText;
    }
}
