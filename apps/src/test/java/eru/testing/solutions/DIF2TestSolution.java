package eru.testing.solutions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static eru.testing.DIF2Fixed.*;

/**
 * DIF2 Test Solutions - Defects, Infections and Failures (Part 2)
 *
 * NOTE: These tests run against DIF2Fixed (corrected methods).
 * Tests marked with [BUG DETECTED] will FAIL if run against DIF2 (buggy version).
 */
public class DIF2TestSolution {

    // ==================== findMin ====================
    // Defect: min is initialized to 0 instead of x[0]

    @Test
    public void findMin_failure() {
        // [BUG DETECTED] All positive elements -> min=0 is wrong, returns 0 instead of 3
        int[] arr = {3, 5, 7};
        assertThat(findMin(arr), equalTo(3));
    }

    @Test
    public void findMin_defectNotExecuted() {
        // Null array causes NullPointerException before the defect (min=0) is reached
        assertThrows(NullPointerException.class, () -> {
            findMin(null);
        });
    }

    @Test
    public void findMin_defectExecuted_noInfection() {
        // When x[0] == 0, initializing min to 0 is the same as min = x[0]
        // No infection: state is identical to correct program
        int[] arr = {0, 3, -1};
        assertThat(findMin(arr), equalTo(-1));
    }

    @Test
    public void findMin_defectExecuted_infectionCaused_noFailure() {
        // min starts at 0 (infected: should be x[0]=5), but the array contains
        // a negative value that is smaller than 0, so the final result is correct
        int[] arr = {5, -2, 3};
        assertThat(findMin(arr), equalTo(-2));
    }

    // ==================== countEven ====================
    // Defect: uses (x[i] % 2 != 1) instead of (x[i] % 2 == 0)
    // In Java, -3 % 2 = -1 (not 1), so -3 % 2 != 1 is TRUE -> counts -3 as even

    @Test
    public void countEven_failure() {
        // [BUG DETECTED] -3 is odd, but -3 % 2 = -1, and -1 != 1, so it's counted as even
        int[] arr = {-3};
        assertThat(countEven(arr), equalTo(0));
    }

    @Test
    public void countEven_defectNotExecuted() {
        // Empty array: loop body never executed
        int[] arr = {};
        assertThat(countEven(arr), equalTo(0));
    }

    @Test
    public void countEven_defectExecuted_noInfection() {
        // Positive odd number: 3 % 2 = 1, so (3 % 2 != 1) is false
        // Same result as (3 % 2 == 0) which is also false -> no infection
        int[] arr = {3};
        assertThat(countEven(arr), equalTo(0));
    }

    // countEven: infection without failure is NOT possible.
    // Once count is incremented wrongly (for a negative odd number),
    // the incorrect count always propagates to the output.

    // ==================== isSorted ====================
    // Defect: uses >= instead of > in comparison (x[i] >= x[i+1])
    // This treats equal adjacent elements as "unsorted"

    @Test
    public void isSorted_failure() {
        // [BUG DETECTED] {1, 1, 2} is sorted (non-decreasing), but buggy version
        // sees 1 >= 1 as true and returns false
        int[] arr = {1, 1, 2};
        assertTrue(isSorted(arr));
    }

    @Test
    public void isSorted_defectNotExecuted() {
        // Array with 0 or 1 elements: loop body never executes
        int[] arr = {42};
        assertTrue(isSorted(arr));
    }

    @Test
    public void isSorted_defectExecuted_noInfection() {
        // Strictly ascending array: x[i] >= x[i+1] and x[i] > x[i+1] both evaluate
        // to false for all i. No infection since the condition result is the same.
        int[] arr = {1, 2, 3};
        assertTrue(isSorted(arr));
    }

    @Test
    public void isSorted_defectExecuted_infectionCaused_noFailure() {
        // {2, 2, 1}: buggy version returns false at i=0 (2 >= 2 is true -> return false)
        // Correct version skips i=0 (2 > 2 is false) but returns false at i=1 (2 > 1)
        // Both return false, but for different reasons. Infection (wrong early return)
        // does not cause failure (result is still correct).
        int[] arr = {2, 2, 1};
        assertFalse(isSorted(arr));
    }

    // ==================== firstDuplicate ====================
    // Defect: inner loop starts at j=i instead of j=i+1
    // Every element matches itself (x[i] == x[j] when j==i)

    @Test
    public void firstDuplicate_failure() {
        // [BUG DETECTED] No duplicates in array, should return -1
        // But buggy version: j starts at i, so x[0]==x[0] is always true, returns 5
        int[] arr = {5, 3, 7};
        assertThat(firstDuplicate(arr), equalTo(-1));
    }

    @Test
    public void firstDuplicate_defectNotExecuted() {
        // Empty array: outer loop never executes, inner loop never entered
        int[] arr = {};
        assertThat(firstDuplicate(arr), equalTo(-1));
    }

    @Test
    public void firstDuplicate_defectExecuted_noInfection() {
        // First element is a real duplicate: {3, 3, 5}
        // Buggy: j=0, x[0]==x[0] -> returns x[0]=3
        // Correct: j=1, x[0]==x[1] -> returns x[0]=3
        // Same result, no infection in terms of output
        int[] arr = {3, 3, 5};
        assertThat(firstDuplicate(arr), equalTo(3));
    }

    // firstDuplicate: infection without failure is NOT possible in general.
    // The self-match immediately returns x[i], which is always the first element.
    // If x[0] is not actually a duplicate, the returned value is wrong -> failure.
    // If x[0] IS a duplicate, see above (no infection case).
}
