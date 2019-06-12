import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        int i = 0;
        while (i <= 1000) {
            Long random = Double.valueOf(Math.random()*1000).longValue();
            System.out.println("Random => " + random);
            FileWriter fileWriter = null;
            try {
                File file = new File("/usr/src/app/" + random);
                file.getParentFile().mkdirs();
                fileWriter = new FileWriter(file);
                System.out.println("File written => " + random);
                fileWriter.write(random + "");
                fileWriter.close();
                i++;
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 FROM openjdk:11-jdk-slim as builder
 COPY Test.java /usr/src
 RUN javac /usr/src/Test.java
 WORKDIR /usr/src
 ENTRYPOINT exec java Test

 */