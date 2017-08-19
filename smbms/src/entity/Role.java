package entity;

import java.util.Date;

public class Role {
    private Long rid;

    private String rolecode;

    private String rolename;

    private Long rcreatedby;

    private Date rcreationdate;

    private Long rmodifyby;

    private Date rmodifydate;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Long getRcreatedby() {
        return rcreatedby;
    }

    public void setRcreatedby(Long rcreatedby) {
        this.rcreatedby = rcreatedby;
    }

    public Date getRcreationdate() {
        return rcreationdate;
    }

    public void setRcreationdate(Date rcreationdate) {
        this.rcreationdate = rcreationdate;
    }

    public Long getRmodifyby() {
        return rmodifyby;
    }

    public void setRmodifyby(Long rmodifyby) {
        this.rmodifyby = rmodifyby;
    }

    public Date getRmodifydate() {
        return rmodifydate;
    }

    public void setRmodifydate(Date rmodifydate) {
        this.rmodifydate = rmodifydate;
    }
}