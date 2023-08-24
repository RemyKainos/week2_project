package org.kainos.ea.cli;

import java.util.Date;

public class Project {
   private String name;
    private int value;
   private int lead_id;
    private Date start_date;
    private Date complete_date;

    public Project(String name, int value, int lead_id, Date start_date, Date complete_date) {
        this.name = name;
        this.value = value;
        this.lead_id = lead_id;
        this.start_date = start_date;
        this.complete_date = complete_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLead_id() {
        return lead_id;
    }

    public void setLead_id(int lead_id) {
        this.lead_id = lead_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Date complete_date) {
        this.complete_date = complete_date;
    }
}
