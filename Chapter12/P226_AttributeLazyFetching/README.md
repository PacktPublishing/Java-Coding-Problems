# Attribute lazy fetching
We own a bookstore. The profiles of the authors (containing attributes as **name**, **surname**, **avatar** (as picture), etc) are stored in a database via an entity named **Author**. When an author wants to edit his profile, we load his details except the **avatar**. The **avatar** should be lazy loaded on demand. Write a program that shapes this behavior.
