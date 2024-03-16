package com.spring.core;

import com.spring.core.config.ApplicationConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

public class MainResources {

  public static void main(String[] args) throws IOException {
    // Environment variables
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    Environment env = applicationContext.getEnvironment();
    System.out.println("user: " + env.getProperty("user"));
    System.out.println("database: " + env.containsProperty("database"));

    // Resource file
    Resource classPathFile = applicationContext.getResource("classpath:application.properties");
    Resource webFile = applicationContext.getResource("https://filesamples.com/samples/code/json/sample1.json");
    System.out.println("------- From local file -----------");
    printLineByLineResourceFile(classPathFile);

    System.out.println("------- From WEB  -----------");
    printLineByLineResourceFile(webFile);

  }

  private static void printLineByLineResourceFile(Resource classPathFile) throws IOException {
    InputStream ioStream = classPathFile.getInputStream();

    if (ioStream == null) {
      throw new IllegalArgumentException(classPathFile.getFilename() + " is not found");
    }
    try (InputStreamReader isr = new InputStreamReader(ioStream);
        BufferedReader br = new BufferedReader(isr);)
    {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      ioStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
