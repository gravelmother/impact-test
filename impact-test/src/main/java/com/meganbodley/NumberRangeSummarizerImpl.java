package com.meganbodley;

import java.util.*;
import java.util.stream.Collectors;

// ASSUMPTIONS:
//  - duplicate values are removed
//  - input might contain invalid items (i.e. non-integer values)

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        // check for null or empty input
        if (input == null || input.trim().isEmpty()) return Collections.EMPTY_LIST;

        // use Collection Streams
        return Arrays.stream(input.split(",")) // split comma delimited string
                .map(String::trim) // remove any whitespace
                .filter(s -> s.matches("-?\\d+")) // only keep Integer values
                .map(s -> Integer.parseInt(s))// Lambda to convert String to Integer
                .sorted() // ensure values are sorted (ascending)
                .collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        // check for null or empty input
        if (input == null || input.isEmpty()) return "";

        // remove duplicate values
        List<Integer> values = input.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());


        // ensure values are sorted (ascending)
        Collections.sort(values);

        // use StringBuilder to concatenate the output string
        StringBuilder result = new StringBuilder();

        // keep track of first and prev values (to track ranges)
        int first = values.get(0);
        int prev = first;

        // already have the first value so start at i = 1
        for (int i = 1; i < values.size(); i++) {

            // value at pos i
            int cur = values.get(i);

            // check if cur is part of the current range
            if (cur == prev + 1) {
                // cur is part of current range
                // don't have to append cur to the result individually (it will fall under a
                // range)
                prev = cur;
            }
            else {
                appendValue(result, first, prev);
                result.append(", ");

                // reset first and prev values (start a new range)
                first = cur;
                prev = cur;
            }
        }

        // append last remaining value/range
        appendValue(result, first, prev);

        return result.toString();
    }

    private void appendValue(StringBuilder result, int first, int last) {
        if (first == last) {
            // not part of a range, just append individual value
            result.append(first);
        } else {
            // end of the current range
            // create the range string
            result.append(first).append("-").append(last);
        }
    }
}
