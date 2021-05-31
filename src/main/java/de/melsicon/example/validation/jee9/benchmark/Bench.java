package de.melsicon.example.validation.jee9.benchmark;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.openjdk.jmh.annotations.Mode.AverageTime;

import de.melsicon.example.validation.jee9.validated.PersonFactory;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Fork(1)
@Warmup(iterations = 6, time = 3)
@Measurement(iterations = 5, time = 5)
public class Bench {
  @Benchmark
  public de.melsicon.example.validation.jee9.self_validating.Person selfValidating() {
    return new de.melsicon.example.validation.jee9.self_validating.Person("Kartini", null);
  }

  @Benchmark
  @RequiresNonNull({"#1.factory"})
  public de.melsicon.example.validation.jee9.validated.Person validated(MyState myState) {
    return myState.factory.create("Kartini", null);
  }

  @Benchmark
  public de.melsicon.example.validation.immutables.Person immutables() {
    return de.melsicon.example.validation.immutables.Person.builder().givenName("Kartini").build();
  }

  @Benchmark
  public de.melsicon.example.validation.pojo.Person pojo() {
    return new de.melsicon.example.validation.pojo.Person("Kartini", null);
  }

  @State(Scope.Benchmark)
  public static class MyState {
    public @MonotonicNonNull PersonFactory factory;
    private @MonotonicNonNull ValidatorFactory validatorFactory;

    @EnsuresNonNull({"validatorFactory", "factory"})
    @Setup
    public void setUp() {
      validatorFactory = Validation.buildDefaultValidatorFactory();
      factory = new PersonFactory(validatorFactory.getValidator());
    }

    @TearDown(Level.Trial)
    @RequiresNonNull({"validatorFactory"})
    public void tearDown() {
      validatorFactory.close();
    }
  }
}
