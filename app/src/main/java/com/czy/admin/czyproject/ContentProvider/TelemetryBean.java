package com.czy.admin.czyproject.ContentProvider;

/**
 * Created by czy on 2017/6/5.
 */

public class TelemetryBean {

    /**
     * 事件名称
     * app,gamepad1,gamepad2,dongle
     */
    private String name;

    /**
     * 事件状态
     * Opening the fota app;
     Installation of new firmware in gamepad1;
     Installation of new firmware in gamepad2;
     Installation of new firmware in dongle.
     */
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TelemetryBean(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
