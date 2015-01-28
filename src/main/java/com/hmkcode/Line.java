package com.hmkcode;

/**
 * Created by mike on 28.01.15.
 */
public class Line {

    String field;
    String value;

    public Line(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
