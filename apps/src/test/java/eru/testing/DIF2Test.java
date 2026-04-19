package eru.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * DIF2 Test Class - Defects, Infections and Failures (Part 2)
 *
 * For each method in DIF2.java, implement the test cases following the
 * naming convention described in the practical document.
 *
 * Remember: Tests for _failure should assert the CORRECT expected behavior,
 * which means they will FAIL when run against DIF2 (buggy version),
 * but PASS when run against DIF2Fixed (corrected version).
 */
public class DIF2Test {

    // ==================== findMin ====================

    @Test
    public void findMin_failure() {
        // TODO: Write a test that causes findMin to fail.
        // Hint: Think about what happens when all elements are positive.
        // The bug is related to how the minimum value is initialized.
    }

    @Test
    public void findMin_defectNotExecuted() {
        // TODO: Write a test where the defect is not executed.
        // Hint: Under what conditions is the buggy initialization never reached
        // or does the method exit before using it?
    }

    @Test
    public void findMin_defectExecuted_noInfection() {
        // TODO: Write a test where the defect is executed but no infection occurs.
        // Hint: When would initializing min to 0 produce the same state as
        // initializing it to x[0]?
    }

    @Test
    public void findMin_defectExecuted_infectionCaused_noFailure() {
        // TODO: Write a test where infection occurs but the method still
        // returns the correct result.
        // Hint: Think about when min=0 is wrong state but a later element
        // corrects it.
    }

    // ==================== countEven ====================

    @Test
    public void countEven_failure() {
        // TODO: Write a test that causes countEven to fail.
        // Hint: The bug is related to how the modulo operator works with
        // negative numbers in Java. Try a negative odd number.
    }

    @Test
    public void countEven_defectNotExecuted() {
        // TODO: Write a test where the defect is not executed.
        // Hint: When is the loop body never executed?
    }

    @Test
    public void countEven_defectExecuted_noInfection() {
        // TODO: Write a test where the defect is executed but no infection occurs.
        // Hint: For which values does (x[i] % 2 != 1) give the same result
        // as (x[i] % 2 == 0)?
    }

    @Test
    public void countEven_defectExecuted_infectionCaused_noFailure() {
        // TODO: Is this scenario possible for countEven?
        // Think carefully: if count takes a wrong value, can the final result
        // still be correct?
        // If NOT possible, explain why as a comment here.
    }

    // ==================== isSorted ====================

    @Test
    public void isSorted_failure() {
        // TODO: Write a test that causes isSorted to fail.
        // Hint: The bug uses >= instead of > in the comparison.
        // Think about an array with equal adjacent elements.
    }

    @Test
    public void isSorted_defectNotExecuted() {
        // TODO: Write a test where the defect is not executed.
        // Hint: When is the loop body never executed?
    }

    @Test
    public void isSorted_defectExecuted_noInfection() {
        // TODO: Write a test where the defect is executed but no infection occurs.
        // Hint: When does (x[i] >= x[i+1]) give the same result as (x[i] > x[i+1])?
    }

    @Test
    public void isSorted_defectExecuted_infectionCaused_noFailure() {
        // TODO: Write a test where infection occurs but the method still
        // returns the correct result.
        // Hint: Think about an array that is NOT sorted AND has equal adjacent
        // elements. The method might return false for the wrong reason
        // but still give the correct answer.
    }

    // ==================== firstDuplicate ====================

    @Test
    public void firstDuplicate_failure() {
        // TODO: Write a test that causes firstDuplicate to fail.
        // Hint: The bug is in the inner loop start index.
        // Every element "matches" itself.
    }

    @Test
    public void firstDuplicate_defectNotExecuted() {
        // TODO: Write a test where the defect is not executed.
        // Hint: When is the inner loop never entered?
    }

    @Test
    public void firstDuplicate_defectExecuted_noInfection() {
        // TODO: Write a test where the defect is executed but no infection occurs.
        // Hint: Think about an array where the first element actually IS a
        // duplicate. The self-match returns the same value as a real match would.
    }

    @Test
    public void firstDuplicate_defectExecuted_infectionCaused_noFailure() {
        // TODO: Is this scenario possible?
        // Think: if the self-match wrongly identifies a duplicate, can the
        // returned value still be correct?
        // If NOT possible, explain why as a comment here.
    }
}
