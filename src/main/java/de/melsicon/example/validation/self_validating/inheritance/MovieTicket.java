package de.melsicon.example.validation.self_validating.inheritance;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.example.validation.self_validating.SelfValidating;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.NonFinal;

@SuppressWarnings({
  "MultiVariableDeclaration",
  "UnnecessarilyFullyQualified",
  "Var",
  "keyfor:type.anno.before.modifier",
  "nullness:type.anno.before.modifier",
})
@Immutable
@NonFinal
@Value
@EqualsAndHashCode(callSuper = false)
public class MovieTicket extends SelfValidating<Object> {
  @NotNull String movieName;

  @Min(1L)
  long serial;

  @SuppressWarnings("nullness:method.invocation.invalid") // Don't try this at home
  public MovieTicket(String movieName, long serial) {
    this.movieName = movieName;
    this.serial = serial;

    validateSelf();
  }
}
