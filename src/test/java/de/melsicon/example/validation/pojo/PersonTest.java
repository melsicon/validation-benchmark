package de.melsicon.example.validation.pojo;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.common.truth.Truth8;
import org.junit.Test;

public final class PersonTest {
  @Test
  public void canBuild() {
    var person = new Person("Kartini", null);

    assertThat(person.givenName()).isEqualTo("Kartini");
    Truth8.assertThat(person.surname()).isEmpty();
  }

  @Test
  @SuppressWarnings({"NullAway", "nullness:argument.type.incompatible"})
  public void givenNameRequired() {
    assertThrows(NullPointerException.class, () -> new Person(null, null));
  }

  @Test
  public void nonEmptyGivenName() {
    assertThrows(IllegalStateException.class, () -> new Person("", null));
  }

  @Test
  public void nonEmptySurname() {
    assertThrows(IllegalStateException.class, () -> new Person("Kartini", ""));
  }
}
