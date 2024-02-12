package aron.backend.done;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Bakery 8 to 10
    Checkout 10 to 12
    Dairy 14 to 19
 */
public class Shifts_Test {
    private static final String NO_SHIFT_RECOMMENDATION = "No shift recommendation.";

    @Test
    public void planShift_shouldNotContainAnyRecommendation_whenShiftRecordsIsNull() {
        final Set <String> planned = Shifts.planShift(null);

        assertFalse(planned.contains("Bakery"));
        assertFalse(planned.contains("Checkout"));
        assertFalse(planned.contains("Dairy"));
        assertTrue(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldNotContainAnyRecommendation_whenShiftRecordsIsEmpty() {
        final Set <String> planned = Shifts.planShift(new ArrayList <>(0));

        assertFalse(planned.contains("Bakery"));
        assertFalse(planned.contains("Checkout"));
        assertFalse(planned.contains("Dairy"));
        assertTrue(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldNotContainAnyRecommendation_whenNotInRange() {
        final List <ShiftRecord> list = new LinkedList <>();
        list.add(new ShiftRecord(6, 7));

        final Set <String> planned = Shifts.planShift(list);
        System.out.println(planned.size());

        assertFalse(planned.contains("Bakery"));
        assertFalse(planned.contains("Checkout"));
        assertFalse(planned.contains("Dairy"));
        assertTrue(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldContainBakeryAndCheckout_when_6to11() {
        final List <ShiftRecord> list = new LinkedList <>();
        list.add(new ShiftRecord(6, 11));

        final Set <String> planned = Shifts.planShift(list);

        assertTrue(planned.contains("Bakery"));
        assertTrue(planned.contains("Checkout"));
        assertFalse(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldContainBakeryOnly_when_8to10() {
        final List <ShiftRecord> list = new LinkedList <>();
        list.add(new ShiftRecord(8, 10));

        final Set <String> planned = Shifts.planShift(list);

        assertTrue(planned.contains("Bakery"));
        assertFalse(planned.contains("Checkout"));
        assertFalse(planned.contains("Dairy"));
        assertFalse(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldContainBakeryAndCheckout_when_8to11() {
        final List <ShiftRecord> list = new LinkedList <>();
        list.add(new ShiftRecord(8, 11));

        final Set <String> planned = Shifts.planShift(list);

        assertTrue(planned.contains("Bakery"));
        assertTrue(planned.contains("Checkout"));
        assertFalse(planned.contains("Dairy"));
        assertFalse(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldContainBakeryAndCheckout_when_9to12() {
        final List <ShiftRecord> list = new LinkedList <>();
        list.add(new ShiftRecord(9, 12));

        final Set <String> planned = Shifts.planShift(list);

        assertTrue(planned.contains("Bakery"));
        assertTrue(planned.contains("Checkout"));
        assertFalse(planned.contains("Dairy"));
        assertFalse(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldContainOnlyDairy_when_15to16() {
        final List <ShiftRecord> list = new LinkedList <>();
        list.add(new ShiftRecord(15, 16));

        final Set <String> planned = Shifts.planShift(list);

        assertFalse(planned.contains("Bakery"));
        assertFalse(planned.contains("Checkout"));
        assertTrue(planned.contains("Dairy"));
        assertFalse(planned.contains(NO_SHIFT_RECOMMENDATION));
    }

    @Test
    public void planShift_shouldNotContainAnyRecommendation_whenNotInRange_20to21() {
        final List <ShiftRecord> list = new LinkedList <>();
        list.add(new ShiftRecord(20, 21));

        final Set <String> planned = Shifts.planShift(list);

        assertFalse(planned.contains("Bakery"));
        assertFalse(planned.contains("Checkout"));
        assertFalse(planned.contains("Dairy"));
        assertTrue(planned.contains(NO_SHIFT_RECOMMENDATION));
    }
}
