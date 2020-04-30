package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {
    @Test
    public void test(){
        //dynamicaly getting your project path
        //System.out.println(System.getProperty("user.dir"));
        //System.out.println(System.getProperty("testfile.txt"));

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\resources\\testfile.txt";

        //C:\Users\letme\IdeaProjects\EU2TestNGProject\src\test\resources\testfile.txt

        System.out.println("projectPath = " + projectPath);
        System.out.println("relativePath = " + relativePath);

        String filePath = projectPath + "\\" + relativePath;

        System.out.println("filePath = " + filePath);

    }
}
