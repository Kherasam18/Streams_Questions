This repository contains a collection of interview-style questions designed to test understanding of Java's functional programming features, primarily the Stream API, lambda expressions, and method references, introduced in Java 8.

❓ Question 1: E-commerce Product Filtering Scenario: Imagine you're working on an e-commerce platform. You have a list of Product objects. You need to implement a feature to find all electronic products that are currently in stock and cost more than $1000. The result should be a list of the names of these products, sorted alphabetically.

Task: Given a List, write a method that returns a List containing the names of the qualifying products.

Provided Code:

class Product { private String name; private String category; private double price; private int stock;

// Constructors, Getters
}

What to look for:

Streams API: The candidate should use the .stream() method on the list.

Filtering: Correct use of filter() multiple times or with a combined predicate.

Mapping: Use of map() to transform a Stream into a Stream.

Sorting: Use of sorted() for alphabetical ordering.

Terminal Operation: Correct use of collect(Collectors.toList()) to get the final list.

❓ Question 2: Employee Data Aggregation Scenario: You're working on an HR application. You have a List. Your task is to calculate the average salary for all employees in the "Engineering" department who are older than 30.

Task: Given a List, write a method that returns a Double representing the calculated average salary.

Provided Code:

class Employee { private String name; private String department; private int age; private double salary;

// Constructors, Getters
}

What to look for:

Numeric Streams: The ideal solution uses mapToDouble() to work with a DoubleStream, which has a built-in average() method.

Optional Handling: The average() method returns an OptionalDouble. The candidate should correctly handle the case where no employees match the criteria (e.g., using orElse(0.0)).

Lambda Expressions: Clear and concise lambda expressions for the filter and map operations.

❓ Question 3: Custom Functional Interface for Validation Scenario: You are building a user registration system and need to implement a flexible validation mechanism. Some validation rules are simple (e.g., "password must be longer than 8 characters"), while others are complex.

Task:

Define a functional interface called ValidationRule with a single abstract method boolean test(T value).

Implement this interface using lambda expressions to create at least two different validation rules for a String (e.g., checking for non-emptiness, containing a special character).

Write a method that takes a value and a list of validation rules and returns true only if the value passes all the rules.

What to look for:

Functional Interface Definition: Correctly annotating the interface with @FunctionalInterface.

Lambda Implementation: Demonstrates creating different validation logic using lambdas.

Stream Logic: Using stream().allMatch() to efficiently check if the input passes all validation rules.

❓ Question 4: Refactoring to Method References Scenario: A junior developer has written the following code to get a list of all department names from a list of employees. The code works, but it could be more concise.

Task: Refactor the following code snippet to use a method reference instead of a lambda expression. Explain why a method reference is suitable here.

Original Code:

// Given a List employees; List departmentNames = employees.stream() .map(employee -> employee.getDepartment()) .distinct() .collect(Collectors.toList());

What to look for:

Correct Syntax: The candidate should replace employee -> employee.getDepartment() with Employee::getDepartment.

Explanation: They should explain that a method reference is a shorthand for a lambda that simply calls an existing method. In this case, it's a reference to an instance method (getDepartment) of an arbitrary object of a particular type (Employee).

❓ Question 5: Grouping Transactions by Currency Scenario: You are working for a fintech company. You have a stream of financial Transaction objects from various sources. You need to process these transactions and group them by their currency.

Task: Given a List, write a method that returns a Map<Currency, List>, where each key is a currency and the value is a list of all transactions made in that currency.

Provided Code:

class Transaction { private int id; private Currency currency; private double amount;

// Constructors, Getters
}

What to look for:

Collectors.groupingBy: The core of the solution is the groupingBy collector.

Classifier Function: The candidate should provide a function to classify the elements, which in this case is Transaction::getCurrency.

❓ Question 6: Order Flattening Scenario: In an e-commerce backend, a Customer object has a list of Order objects, and each Order has a list of Product objects. You need to find all unique products that a customer has ever ordered.

Task: Given a List, write a method that returns a Set containing all unique products from all orders.

Provided Code:

class Order { private List products; // Getters }

What to look for:

flatMap: This is the key operation. The candidate needs to understand how to use flatMap to convert a Stream<List> into a Stream.

Collecting to a Set: Using collect(Collectors.toSet()) to automatically handle uniqueness.

❓ Question 7: Word Frequency Counter Scenario: You are building a text analysis tool. A common task is to count the frequency of each word in a given block of text.

Task: Write a method that takes a String of text and returns a Map<String, Long> where the key is a word and the value is its frequency. The comparison should be case-insensitive, and you should ignore punctuation.

What to look for:

String Manipulation: Using toLowerCase() and split() with a regex to get an array of words.

Stream Creation: Using Arrays.stream() to create a stream from the array.

Grouping and Counting: The most efficient solution is Collectors.groupingBy(Function.identity(), Collectors.counting()).

❓ Question 8: Composing Predicates Scenario: You are implementing a search filter for a car dealership website. Users should be able to combine filters. For example, they might want to find all cars that are "blue" AND "have more than 4 doors" OR are "electric".

Task:

Create three separate Predicate objects for different criteria (e.g., by color, by number of doors, by engine type).

Write a method that takes a List and demonstrates how to combine these predicates using .and() and .or() to perform a complex search.

What to look for:

Predicate Interface: Understanding and using the java.util.function.Predicate interface.

Predicate Composition: Correctly using the and(), or(), and negate() default methods on the Predicate interface to build a complex logical condition.

Readability: The candidate should be able to explain how composing predicates makes the code more readable and modular than a single, large if-statement.

❓ Question 9: Reducer for Financial Summaries Scenario: You're analyzing a list of daily stock price changes for a particular stock. You want to calculate the total gain and total loss over a period.

Task: Given a List where each value represents the price change for a day (positive for a gain, negative for a loss), use the reduce operation to calculate a final Map<String, Double> containing the keys "TOTAL_GAIN" and "TOTAL_LOSS".

What to look for:

reduce Operation: This is a test of their understanding of the more complex three-argument reduce() method.

Accumulator Logic: The logic within the accumulator function should correctly update the map with gains and losses.

Combiner Function: They must correctly implement the combiner function, which is used when the stream is processed in parallel. It should know how to merge two intermediate maps.
