package org.example;
import com.jcraft.jsch.*;

public class SFTP_Get_Put {

        public static void main(String args[]) {

        AppConfig config = new AppConfig();

        //DOWNLOAD --> File from SFTP server to Local
        String sftpPath  =  config.getSftpPath();
        String fileName  =  config.getFileName();
        String localPath =  config.getLocalPath();


        //UPLOAD --> File from Local to SFTP server
        String localPath1 =  config.getLocalPath1();
        String fileName1  =  config.getFileName1();
        String sftpPath1  =  config.getSftpPath1();

        String localPath2 =  config.getLocalPath2();
        String fileName2  =  config.getFileName2();
        String sftpPath2  =  config.getSftpPath2();




        String sftpHost =  config.getSftpHost();
        String sftpPort = config.getSftpPort();
        String sftpUser = config.getSftpUser();
        String sftpPassword = config.getSftpPassword();

        try{
            /**
             * Open session to sftp server
             */
            JSch jsch = new JSch();

            Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftpPassword);
            System.out.println("Connecting------");
            session.connect();
            System.out.println("Established Session");

            Channel channel = session.openChannel("sftp");
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.connect();

            System.out.println("Opened sftp Channel");




            System.out.println("Download file from the server");
            sftpChannel.get(sftpPath+"/"+fileName, localPath);
            System.out.println("Copied file to Local");

            // Text file processing
            ReadData c = new ReadData();
            c.read();

            // Uploading Failure file
            System.out.println("Uploading file to server");
            sftpChannel.put(localPath1+"/"+fileName1, sftpPath1);
            System.out.println("Copied file from Local to SFTP");

            // Uploading Success file
            System.out.println("Uploading file to server");
            sftpChannel.put(localPath2+"/"+fileName2, sftpPath2);
            System.out.println("Copied file from Local to SFTP");


            sftpChannel.disconnect();
            session.disconnect();

            System.out.println("Disconnected from sftp");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    }

