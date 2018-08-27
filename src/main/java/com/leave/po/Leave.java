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

    public Leave() {
    }

    public Leave(String leaveName, String leaveText) {
        this.leaveName = leaveName;
        this.leaveText = leaveText;
    }

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

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", leaveName='" + leaveName + '\'' +
                ", leaveText='" + leaveText + '\'' +
                '}';
    }
}
