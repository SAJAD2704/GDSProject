package com.example.dsgraphicalproject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Phase1
{
    public static void extractHereZip(String zipFile) throws IOException
    {
        File file = new File(zipFile);
        String destDirectory = file.getPath().replaceAll(file.getName(),"");

        int BUFFER_SIZE = 4096;


        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry entry = zipIn.getNextEntry();
            // iterates over entries in the zip file
            while (entry != null) {
                    String filePath = destDirectory + File.separator + entry.getName();
                    if (!entry.isDirectory())
                    {
                            // if the entry is a file, extracts it
                            extractFile(zipIn, filePath);
                    }
                    else
                    {
                            // if the entry is a directory, make the directory
                            File dir = new File(filePath);
                            dir.mkdirs();
                    }
                    zipIn.closeEntry();
                    entry = zipIn.getNextEntry();
            }
            zipIn.close();

    }
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] bytesIn = new byte[4096];
    int read = 0;
    while ((read = zipIn.read(bytesIn)) != -1) {
      bos.write(bytesIn, 0, read);
    }
    bos.close();
  }
    
    public static void folderExtract(File root) throws IOException
    {
        for(String i : root.list())
        {
            File file = new File(root + "\\" + i);
            if(file.isDirectory())
            {
                folderExtract(root,file);
                if (!file.delete())
                {
                    throw new IOException("Error in Deleting Empty Directory!");
                }
            }
        }
    }
    public static void folderExtract(File root,File folder) throws IOException
    {
        for(String i : folder.list())
        {
            File file = new File(folder + "\\" + i);
            if(file.isDirectory())
            {
                folderExtract(root,file);
                if (!file.delete())
                {
                    throw new IOException("Error in Deleting Empty Directory!");
                }
            }
            else
            {
                cut(file.getPath(),root.getPath(), file.getName());
            }
        }
    }

    private static void cut(String filePath,String to,String fileName) throws IOException
    {

        Files.copy(Path.of(filePath), Path.of(to + "\\" + fileName));
        File file = new File(filePath);
        if (!file.delete())
        {
            throw new IOException("Error in Deleting Copied File!");
        }
    }
}
