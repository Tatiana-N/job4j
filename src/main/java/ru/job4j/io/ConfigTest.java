package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

  @Test
  public void whenPairWithoutComment() {
    String path = "./data/pair_without_comment.properties";
    Config config = new Config(path);
    config.load();
    assertThat(
      config.value("name"),
      is("Tatiana Nikolaeva")
    );
  }

  @Test
  public void whenFile() {
    String path = "C:/Tanusha/BOOKS/java/task/app.properties";
    Config config = new Config(path);
    config.load();
    assertThat(
      config.value(" #hibernate.connection2.username"),
      is("postgres")
    );
  }
}