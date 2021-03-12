package de.melsicon.example.validation.immutables;

import static com.google.common.base.Preconditions.checkState;

import com.google.errorprone.annotations.Immutable;
import java.util.Optional;
import org.immutables.value.Value;

@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
public abstract class Person {
  /* package */ Person() {}

  public static ImmutablePerson.Builder builder() {
    return ImmutablePerson.builder();
  }

  public abstract String givenName();

  public abstract Optional<String> surname();

  @Value.Check
  /* package */ void check() {
    checkState(!givenName().isEmpty(), "Given name must not be empty");
    checkState(!(surname().isPresent() && surname().get().isEmpty()), "Surname must not be empty");
  }
}
