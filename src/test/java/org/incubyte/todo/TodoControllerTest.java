package org.incubyte.todo;

import static org.assertj.core.api.Assertions.*;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class TodoControllerTest {

  @Inject
  @Client("/")
  HttpClient httpClient;

  @Test
  void should_save_todo() {

    //Arrange
    Todo todo = new Todo();
    todo.setDescription("Remember the Chicken");

    //Acted
    Todo savedTodo = httpClient.toBlocking()
        .retrieve(HttpRequest.POST("todos/", todo), Argument.of(Todo.class));

    //Assert
    assertThat(savedTodo.getDescription()).isEqualTo(todo.getDescription());
    assertThat(savedTodo.isDone()).isFalse();
    assertThat(savedTodo.getId()).isPositive();

    //Arrange

    //Acted
    Todo retrievedTodo = httpClient.toBlocking()
        .retrieve((HttpRequest.GET("todos/" + savedTodo.getId())), Argument.of(Todo.class));

    //assert
    assertThat(retrievedTodo.getId()).isEqualTo(savedTodo.getId());
    assertThat(retrievedTodo.getDescription()).isEqualTo(savedTodo.getDescription());
    assertThat(retrievedTodo.isDone()).isEqualTo(savedTodo.isDone());
  }

}
