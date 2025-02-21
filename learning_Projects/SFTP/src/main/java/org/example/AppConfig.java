package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public Properties properties;

    public AppConfig() {
        properties = new Properties();
        try (InputStream is = getClass().getResourceAsStream("/application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String  sftpHost ;
    public String  sftpPort;
    public String  sftpUser;
    public String  sftpPassword;

    public String getSftpHost() {
        return properties.getProperty("sftpHost");
    }

    public String getSftpPort() {
        return properties.getProperty("sftpPort");
    }

    public String getSftpUser() {
        return properties.getProperty("sftpUser");
    }

    public String getSftpPassword() {
        return properties.getProperty("sftpPassword");
    }

    public String getSftpPath() {
        return properties.getProperty("sftpPath");
    }


    public String getFileName() {
        return properties.getProperty("fileName");
    }

    public String getLocalPath() {
        return properties.getProperty("localPath");
    }

    public String getLocalPath1() {
        return properties.getProperty("localPath1");
    }

    public String getFileName1() {
        return properties.getProperty("fileName1");
    }

    public String getSftpPath1() {
        return properties.getProperty("sftpPath1");
    }

    public String getLocalPath2() {
        return properties.getProperty("localPath2");
    }

    public String getFileName2() {
        return properties.getProperty("fileName2");
    }

    public String getSftpPath2() {
        return properties.getProperty("sftpPath2");
    }

    /* public static void main(String[] args) {
        AppConfig config = new AppConfig();
         System.out.println("  : " + config.getSftpHost());
         System.out.println("  : " + config.getSftpPort());
         System.out.println("  : " + config.getSftpUser());
         System.out.println("  : " + config.getSftpPassword());
         System.out.println("  : " + config.getLocalPath()+'\n');

        System.out.println("  : " + config.getSftpPath());
        System.out.println("  : " + config.getFileName());
        System.out.println("  : " + config.getLocalPath()+'\n');

        System.out.println("  : " + config.getLocalPath1());
        System.out.println("  : " + config.getFileName1());
        System.out.println("  : " + config.getSftpPath1()+'\n');

        System.out.println("  : " + config.getLocalPath2());
        System.out.println("  : " + config.getFileName2());
        System.out.println("  : " + config.getSftpPath2()+'\n');
    }*/
}
