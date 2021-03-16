package de.melsicon.example.validation.self_validating;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;
import static org.junit.Assert.assertThrows;

import javax.validation.ConstraintViolationException;
import org.junit.Test;

public final class PersonTest {
  @Test
  public void canBuild() {
    var person = new Person("Kartini", null);

    assertThat(person.givenName()).isEqualTo("Kartini");
    assertThat(person.surname()).isEmpty();
  }

  @Test
  @SuppressWarnings({"NullAway", "nullness:argument.type.incompatible"})
  public void givenNameRequired() {
    assertThrows(ConstraintViolationException.class, () -> new Person(null, null));
  }

  @Test
  public void nonEmptyGivenName() {
    assertThrows(ConstraintViolationException.class, () -> new Person("", null));
  }

  @Test
  public void nonEmptySurname() {
    assertThrows(ConstraintViolationException.class, () -> new Person("Kartini", ""));
  }
}
