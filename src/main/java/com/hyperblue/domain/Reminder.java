package com.hyperblue.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kbala on 2016-06-10.
 */
@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String type;
    private String description;
    private String priority;
    private String status;
    private String Date;
    private String label;
    private String sequence;

    protected Reminder() {}

    public Reminder(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Reminder[id=%d, type='%s', description='%s']",
                id, type, description);
    }
}
