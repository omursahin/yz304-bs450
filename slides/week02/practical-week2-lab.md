# Week 2 Lab – JUnit 5 Fundamentals & DIF Analysis (Part 2)

This lab has two parts. Part A involves the `MathUtils.java` class and Part B involves
the `DIF2.java` class. Both are part of the Maven project that lives in the code directory
of this repository.

## Part A – JUnit 5 Warm-up

This part involves the `MathUtils.java` class. See
[`apps/src/main/java/eru/testing/MathUtils.java`](../../apps/src/main/java/eru/testing/MathUtils.java).

The class contains three methods: `factorial`, `isPrime`, and `gcd`. These methods
are bug-free.

Open `apps/src/test/java/eru/testing/MathUtilsTest.java`. This file contains 15 test
method skeletons with `fail("Test not implemented yet")` placeholders. Replace each
`fail(...)` with the appropriate assertion following the Arrange-Act-Assert (AAA) pattern.

You can run the tests with:

```bash
cd apps
mvn test -Dtest=MathUtilsTest
```

All 15 tests should pass when correctly implemented.

## Part B – Defects, Infections and Failures (Part 2)

This part involves the `DIF2.java` class. See
[`apps/src/main/java/eru/testing/DIF2.java`](../../apps/src/main/java/eru/testing/DIF2.java).

The class contains four methods: `findMin`, `countEven`, `isSorted`, and
`firstDuplicate`.

Each method has a defect. You will need to write JUnit tests for each defect
and establish a fix.

Specifically, for each method in `DIF2.java`, you will need to complete the following
tasks. The tests you write should be added to a class called `DIF2Test.java` (NB:
When naming tests, `[methodName]` should be replaced by the name of the method
you are writing the test for.)

1. (a) What and where is the defect?

   (b) Under what condition(s) do inputs to the method cause it to fail?

   (c) Write ONE JUnit test case that causes the method to fail.
   This should be called `[methodName]_failure`. (Note that the test should also
   fail - i.e., the test should have an assertion for the _correct_ behaviour of the method.)

2. (a) Is it possible for inputs to the method to _not_ execute the defect? If so, describe
   the condition(s) necessary for the inputs to the method that would cause this to happen.

   (b) If possible (as per your answer to part (a)), write a JUnit test case that
   demonstrates the scenario of part (a) of this question.
   This should be called `[methodName]_defectNotExecuted`.

3. (a) Is it possible for an input to execute the defect but _not_ infect the
   program's state? If so, describe
   the condition(s) necessary for the inputs to the method that would cause this to happen.

   (b) If possible (as per your answer to part (a)), write a JUnit test case that
   demonstrates the scenario of part (a) of this question.
   Call it `[methodName]_defectExecuted_noInfection`.

4. (a) Is it possible for an input to cause an infection but _not_ cause the
   method to fail? (Note, program statements being executed when they shouldn't
   count as an infection.) If so, describe
   the condition(s) necessary for the inputs to the method that would cause this to happen.

   (b) If possible (as per your answer to part (a)), write a JUnit test case that
   demonstrates the scenario of part (a) of this question.
   Call it `[methodName]_defectExecuted_infectionCaused_noFailure`.

5. Fix the defect and add the fixed method to a class called
   `DIF2Fixed.java`. (Ensure the test you wrote as part of Question 1
   passes when run with the fixed version of the method.)
