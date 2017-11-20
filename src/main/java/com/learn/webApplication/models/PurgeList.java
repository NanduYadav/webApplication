package com.learn.webApplication.models;

import java.sql.Timestamp;

/**
 * Created by z002v2f on 17/11/17.
 */
public class PurgeList {

    private Long mdmSequenceId;
    private Long guestId;
    private Timestamp created;
    private String status;

    public PurgeList() {}

    public PurgeList(Long mdmSequenceId, Long guestId, Timestamp created, String status) {
        this.mdmSequenceId = mdmSequenceId;
        this.guestId = guestId;
        this.created = created;
        this.status = status;
    }

    public Long getMdmSequenceId() {
        return mdmSequenceId;
    }

    public void setMdmSequenceId(Long mdmSequenceId) {
        this.mdmSequenceId = mdmSequenceId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
