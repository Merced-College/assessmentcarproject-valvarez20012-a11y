[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23073262)

# Project Update Summary — Car Data Analyzer

## Overview

During development of the Car Data Analyzer project, several structural, syntax, and logic issues were identified and corrected to ensure the program compiles, runs correctly, and meets assignment requirements. The following summarizes all changes made.

---

## File Structure Corrections

* Renamed `main.java` to `Main.java` to match Java’s requirement that public class names and file names are identical and case-sensitive.
* Renamed `stats.java` to `Stats.java` and `CountByFuleType.java` to `CountByFuelType.java` to correct naming consistency and spelling errors.
* Ensured each public class is placed in its own file:

  * `Main.java`
  * `Car.java`
  * `Stats.java`

---

## Class Structure Fixes

* Wrapped all standalone methods inside proper class definitions to resolve “compact source file” errors.
* Ensured each class uses standard Java structure:

  ```java
  public class ClassName {
      // fields, methods, etc.
  }
  ```
* Added a valid `public static void main(String[] args)` method in `Main.java`.

---

## Import Statements

* Added required imports to resolve type errors:

  ```java
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.Scanner;
  import java.io.File;
  import java.io.FileNotFoundException;
  ```

---

## Method and Logic Corrections

### Mileage Calculation

* Replaced incorrect method calls:

  * `getMileage()` → `getMileageKmpl()`
* Updated data type:

  * Changed `int total` to `double total` to preserve decimal accuracy.

---

### Fuel Type Counting

* Fixed invalid syntax in conditionals:

  * Removed incorrect `object:` formatting.
  * Replaced with proper string comparisons:

    ```java
    fuel.equals("petrol")
    ```
* Standardized fuel type comparisons using:

  ```java
  fuel = fuel.toLowerCase();
  ```

---

### Statistics Implementation

* Implemented:

  * Average mileage calculation
  * Fuel type counts (petrol, diesel, electric, hybrid, other)
* Ensured calculations use the working list of 2000 cars.

---

### Sorting

* Implemented **selection sort** manually as required.
* Sorted cars by **brand (case-insensitive)** using:

  ```java
  compareToIgnoreCase()
  ```
* Printed the first 10 results after sorting.

---

### Searching

* Implemented **binary search** (non-recursive) using:

  * `low`, `high`, `mid`
* Ensured the list is sorted before searching.
* Added logic to return all matching cars with the same brand.

---

## CSV Loading Fixes

* Skipped header row correctly.
* Added validation to skip malformed rows using try/catch.
* Trimmed whitespace from all parsed values.
* Confirmed all fields are parsed into correct data types.

---

## Menu System

* Implemented console menu with options:

  * Sort by Brand
  * Search by Brand
  * Show Statistics
  * Exit
* Added input handling using `Scanner`.

---

## General Improvements

* Ensured all code is inside proper classes.
* Fixed case sensitivity issues across file names and method calls.
* Maintained clean and readable output formatting.
* Verified program runs without compilation errors in standard Java environments.

---

## Final Result

The program now:

* Loads and stores car data correctly
* Sorts using a required manual algorithm
* Searches efficiently using binary search
* Computes accurate statistics
* Runs through a functional console menu

All assignment requirements are satisfied.
