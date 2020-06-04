package com.byted.camp.todolist.beans;

import android.graphics.Color;

public enum Priority {
    LOW(0), MEDIUM(1), HIGH(2);

    public final int intValue;

    Priority(int intValue) {
        this.intValue = intValue;
    }

    public static Priority from(int intValue) {
        for (Priority priority : Priority.values()) {
            if (priority.intValue == intValue) {
                return priority;
            }
        }
        return LOW; // default
    }

    public static int toColor(Priority priority) {
        if(priority == HIGH) {
            return Color.parseColor("#ff0000");
        }
        if(priority == MEDIUM) {
            return Color.parseColor("#00ff00");
        }
        return Color.parseColor("#ffffff");
    }
}
