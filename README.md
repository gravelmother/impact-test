# Number Range Summarizer Implementation
## Submission for Impact.com 
## by Megan Bodley (meggiebod@gmail.com)


A Java Maven project that implements the `NumberRangeSummarizer` interface.  
It collects a comma-delimited list of numbers, removes duplicates and invalid inputs, and summarizes sequential numbers into ranges.

---

## Example

**Input:**
"1,3,6,7,8,12,13,14,15,21,22,23,24,31"

**Output:**
"1, 3, 6-8, 12-15, 21-24, 31"

---

## Assumptions
- Duplicate values are removed.
- Input may contain invalid (non-integer) values → these are ignored.
- Input may be unsorted.
- Negative numbers are supported.
- Empty or null input returns an empty collection or empty string.

---

## Requirements
- Java 8+ (minimum required: Java 8)
- Maven

---

## Build & Run

1. Clone the repo:
   ```bash
   git clone https://github.com/gravelmotherimpact-test.git
   cd impact-test/impact-test

2. Build the project:
    ```bash
    mvn clean install

3. Run the tests:
    ```bash
    mvn test
