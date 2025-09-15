package com.meganbodley;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    @Test
    void testCollectExampleInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> result = summarizer.collect(input);

        List<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        assertEquals(expected, new ArrayList<>(result));
    }

    @Test
    void testCollectEmptyInput() {
        assertTrue(summarizer.collect("").isEmpty());
    }

    @Test
    void testCollectNullInput() {
        assertTrue(summarizer.collect(null).isEmpty());
    }

    @Test
    void testCollectUnsortedInput() {
        String input = "5,1,3,2";
        Collection<Integer> result = summarizer.collect(input);

        List<Integer> expected = Arrays.asList(1, 2, 3, 5);
        assertEquals(expected, new ArrayList<>(result));
    }

    @Test
    void testSummarizeExampleInput() {
        List<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test
    void testSummarizeSingleNumber() {
        List<Integer> input = Collections.singletonList(42);
        String result = summarizer.summarizeCollection(input);

        assertEquals("42", result);
    }

    @Test
    void testSummarizeEmptyInput() {
        String result = summarizer.summarizeCollection(Collections.emptyList());
        assertEquals("", result);
    }

    @Test
    void testSummarizeUnsortedInput() {
        List<Integer> input = Arrays.asList(5, 3, 4, 1, 2);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1-5", result);
    }

    @Test
    void testSummarizeWithDuplicates() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3, 3, 4);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1-4", result);
    }

    @Test
    void testExampleFlow() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collectResult = summarizer.collect(input);
        String summarizerResult = summarizer.summarizeCollection(collectResult);

        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summarizerResult);
    }
}
