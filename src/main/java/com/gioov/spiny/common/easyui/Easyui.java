package com.gioov.spiny.common.easyui;

/**
 * @author godcheese
 * @date 2018/4/30 10:59
 */
public class Easyui {

    public enum State {

        /**
         * 文件夹开
         */
        OPEN("open"),

        /**
         * 文件夹关
         */
        CLOSED("closed"),;
        private String value;

        State(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
