package de.melsicon.example.validation.self_validating.inheritance;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.example.validation.self_validating.Person;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;

@SuppressWarnings({
  "MissingOverride",
  "MultiVariableDeclaration",
  "UnnecessarilyFullyQualified",
  "Var",
  "allcheckers:type.anno.before.modifier",
})
@Immutable
@Value
@EqualsAndHashCode(callSuper = true)
public class SoldMovieTicket extends MovieTicket {
  @NotNull Person owner;

  public SoldMovieTicket(String movieName, long serial, Person owner) {
    super(movieName, serial);
    this.owner = owner;

    this.validateSelf();
  }
}
