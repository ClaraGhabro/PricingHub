package com.pricinghub.recrutement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RecrutementApplication {

    public static void main(String[] args) {
        if (args.length != 0) {
            String filePath = System.getProperty("user.dir") + "/" + args[0];
            System.out.println("file path: " + filePath);
            //readCSVfile(filePath);
        }

        SpringApplication.run(RecrutementApplication.class, args);
    }

}
