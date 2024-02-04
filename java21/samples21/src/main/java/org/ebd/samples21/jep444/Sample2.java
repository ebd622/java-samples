package org.ebd.samples21.jep444;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Sample2 {
    public static void fetch(int index, String path){
        try{
            System.out.println(index + " before " + Thread.currentThread());
            var numberOfLines = Files.lines(Paths.get(path)).count();
            //TODO

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String...arg){

    }
}
