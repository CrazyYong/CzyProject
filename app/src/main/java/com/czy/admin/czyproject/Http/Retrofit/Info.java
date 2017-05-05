package com.czy.admin.czyproject.Http.Retrofit;

import java.util.List;

/**
 * Created by czy on 2017/5/5.
 */

public class Info {

    @Override
    public String toString() {
        return "Info{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "data=" + data +
                    '}';
        }

        private List<DataBean> data;

        public static class DataBean {
            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            @Override
            public String toString() {
                return "DataBean{" +
                        "content='" + content + '\'' +
                        ", hashId='" + hashId + '\'' +
                        ", unixtime=" + unixtime +
                        ", updatetime='" + updatetime + '\'' +
                        '}';
            }
        }
    }
}