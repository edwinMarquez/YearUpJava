package com.yearup.week4.code.recursion;

import java.io.File;

public class DU {

    public static long diskUsage(File root){
        long total = root.length();
        if(root.isDirectory()){
            for(String childName: root.list()){
                File child = new File(root, childName);
                total+=diskUsage(child);
            }
        }
        System.out.println(total+"\t"+root);
        return total;
    }

    public static void main(String[] args) {
        DU.diskUsage(new File("C:\\Users\\rishi\\OneDrive\\Documents\\algos"));
    }
}
