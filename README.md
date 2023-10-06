
**﻿Rewards point calculator based on customer transactions**

**Problem:**

A retailer offers a rewards program to its customers awarding points based on each recorded.
purchase as follows:
For every dollar spent over $50 on the transaction, the customer receives one point.
In addition, for every dollar spent over $100, the customer receives another point.
Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points

**The Rest API to get rewards based on customerId**

The package structured as com.retail.rewards

GroupId is "com.charter"

ArtifactId is "retail"

**Code Explanation:**

Validates the input customerId, checking if it's empty or null. If so, it returns a BAD_REQUEST response with an error message.

Attempts to retrieve customer information based on the customerId using a customerRepository. If the customer is not found, it returns an OK response with an error message.

Calculates customer rewards using a rewardsService if the customer is found.

Handles exceptions, logging any errors that occur, and returning an INTERNAL_SERVER_ERROR response with an error message.

This code assumes that there are specific error codes and constants (e.g., RetailConstants.missingId, RetailConstants.customerNotFound, RetailConstants.internalServerError) used for error handling.

calculateCustomerRewards(String customerId)
This method calculates the total rewards for a customer over the last three months based on their transactions.

It retrieves transaction data for the last three months and calculates rewards for each month.

The total rewards earned are returned in a RetailRewards object.
Error handling is included for potential exceptions during transaction retrieval.

calculateRewardsPerMonth(List<RetailTransaction> transactions)
This private method calculates the total rewards earned for a list of retail transactions within a single month.

It utilizes the calculateRewards method for individual transaction reward calculation.

calculateRewards(RetailTransaction t)
This private method calculates rewards for an individual retail transaction based on predefined reward limits.
The reward calculation considers the amount spent in a transaction and adjusts it based on the limits.

Rewards are returned as double datatype value.

getTimestampMinusDays(int days)
This private method calculates a timestamp representing a date and time by subtracting a specified number of days from the current date and time.
It uses the Java LocalDateTime class for this calculation.

**Steps to Run a Maven Project in STS**

1. Import Your Maven Project
    1. Launch STS.
    2. Go to the File menu and select Import.
    3. In the Import dialog, expand the Maven folder, and select Existing Maven Projects.
    4. Click Next.
    5. Browse to the root directory of your Maven project, which should contain the pom.xml file.
    6. Select the project directory and click Finish. STS will now import your Maven project.
2. Build the Project
    1. Once your project is imported, STS will automatically start building it. You can monitor the progress in the Console view at the bottom of the IDE.
3. Run Your Maven Project
    1. After the build is successful, you can run your Maven project.
    2. In Project Explorer, right-click on your project and select Run As > Maven Build.
    3. In the "Goals" field, you can specify the Maven goals you want to execute, such as clean install to clean and build the project. Click Run. If you want to skip the test cases, you can select skip tests box.
    4. STS will execute the specified Maven goals, and you can view the progress and output in the Console view.
    5. Project is a web application, you can deploy it to a server (e.g., Tomcat) by right-clicking on your project, selecting Run As > Run on Server, and configuring your server.
4. Access Your Application
    1. Once your application is successfully deployed, you can access it through a web browser. <br />
    2. Typically, the URL would be something like http://localhost:8082/retailCustomers/getRewards/{customerId}

**Steps to Set Up and Populate the H2 In-Memory Database**

1. Locate Database Configuration: <br />
• Navigate to the /retail/src/main/resources directory in your project.
2. Edit Database Configuration: <br />
• Open the database configuration file (e.g., application.properties) in the mentioned directory.
3. Update Database Settings: <br />
• Modify the database settings in the configuration file to ensure they point to your locally installed H2 database instance. Update properties such as URL, username, and password if necessary.
4. Run SpringBoot project to kick start the H2 Database Locally: <br />
• Start the H2 database locally on your machine. You can typically run it as a springboot Java application.
5. Access H2 Console: <br />
• Open a web browser and navigate to the H2 database console. The URL may be http://localhost:8082/h2-console/login.jsp . Log in if required by providing password.
![image](https://github.com/azizabdul0317/RetailRewardsProgram/assets/147212983/59ae2ac1-fb6a-4aab-9573-3c75def017dd)
6. Connect to the Database: <br />
• Use the database connection settings specified in your application property configuration file to connect to the H2 database from the web console.
7. Run RetailDB.sql Script: <br />
• Execute the RetailDB.sql script on the H2 in-memory database. This script will create the necessary tables and populate them with test data.
![image](https://github.com/azizabdul0317/RetailRewardsProgram/assets/147212983/2edc16d3-55d7-4384-8cf3-bfb663d0a246)
7. Verify Data: <br />
• You can now verify that the Customer and Transaction data has been successfully inserted into the H2 in-memory database by running SQL queries within the H2 console.
![image](https://github.com/azizabdul0317/RetailRewardsProgram/assets/147212983/167c2324-c17d-4289-8652-d8894256d697)
9. Integration with the Project: <br />
• With the H2 database set up and populated, your project should now be able to interact with the data as configured in your application code.

**Access Your Application from Postman**

Url: http://localhost:8082/retailCustomers/getRewards/

Input: Type P2800 as shown below

http://localhost:8082/retailCustomers/getRewards/P2800

click send to get response!

**Expected Output:**
![image](https://github.com/azizabdul0317/RetailRewardsProgram/assets/147212983/8991a717-0a53-4aec-85be-8306edb124a8)

**Steps to Check Application Health**
1. Open Postman: <br />
• Launch the Postman application on your computer.
2. Select a Request Type: <br />
• In Postman, choose the HTTP request type. For this health check, select the GET request type.
3. Enter the URL: <br />
• In the URL input field, type the following URL: http://localhost:8082/actuator/health.
4. Send the Request: <br />
• Click the "Send" button to execute the GET request to the specified URL.
5. View Health Status: <br />
• Postman will display the response received from the URL. This response will contain information about the health status of your application.

**Expected Output:**
![image](https://github.com/azizabdul0317/RetailRewardsProgram/assets/147212983/10c4b2c5-4bfa-4a21-bc10-1e87f0a26d33)


