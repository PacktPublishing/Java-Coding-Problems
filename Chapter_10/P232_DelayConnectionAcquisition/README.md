# Delay connection acquisition
Write a program that executes a transactional method (annotated with **@Transactional**) containing a time-consuming task that doesn't need a database connection and a task that requires a database connection. Delay the database connection acquisition until it is needed.
