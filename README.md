# increment-number

## Task

### The task is to consistently increment a number in a database when parallel threads are racing to increment the number.

1. Create a table Number in MySQL database with one integer type field.

2. Create a RESTful API using Spring MVC architecture that increments this number.

3. Use Jmeter (Do not use postman because it does not send parallel requests) to call this API with 5000 users so that a lot of parallel requests are sent to server to increment the number.

4. Now set the initial value of Number to 0.

5. After the execution of Jmeter, the value of the number in the database shall be 5000. (Try the same with a bigger number 100000)

6. The API should be scalable i.e. if deployed on multiple machines with same database, the result should be consistent.


## Instructions

1. Checkout the git repository in your local machine.
2. Open your favorite IDE, import a new maven project from file system. Choose the checkout location of the project.
3. Run maven update / clean.
4. Change the mysql database username and password with your mysql database username and password.
5. Create the schema and table as provided in the database-instructions file.
6. Run the project as Springboot application.
7. Open JMeter and import the test script included in the repository.
8. Run the test suite.
9. Run the Jmeter test script.
10. Check the count in the database with the select query in the database-instructions file.
"# number-increment" 
