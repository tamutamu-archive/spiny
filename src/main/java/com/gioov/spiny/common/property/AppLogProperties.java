package com.gioov.spiny.common.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 */
@ConfigurationProperties(prefix = "app.log")
@Component
public class AppLogProperties {

    /**
     * 应用 Logback 日志存储目录
     */
    private String dir = "../";

    /**
     * 日志文件保存的最大天数
     */
    private String maxHistory = "30";

    /**
     * 日志文件的最大大小
     */
    private String maxFileSize = "10MB";

    /**
     * 日志文件总量大小
     */
    private String totalSizeCap = "2GB";

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getMaxHistory() {
        return maxHistory;
    }

    public void setMaxHistory(String maxHistory) {
        this.maxHistory = maxHistory;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getTotalSizeCap() {
        return totalSizeCap;
    }

    public void setTotalSizeCap(String totalSizeCap) {
        this.totalSizeCap = totalSizeCap;
    }
}
