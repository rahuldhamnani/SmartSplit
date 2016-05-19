# SmartSplit
Full Stack Project

## Summary of the project
SmartSplit is a website that allows the user to split bills with roommates, friends and family. It provides an interactive graphical interface to keep track of the expenditure. It will also allow the user to update/delete the bill as well as to modify his/her information. User can view the details at the high level of his friends as well as at the granular level of individual transaction. Every user is required to create an account with full name, email ID and a password. When the user logs in with a valid email ID and password, a session is maintained until he logs out.

## Steps to Run the Project
1. Download modules SmartSplitDao, SmartSplitCore and SmartSplitWeb.
2. Create jar of SmartSplitDao and inport it into SmartSplitCore.
3. Create SmartSplitCore and import it into SmartSplitWeb module.
3. Make sure that all maven dependencies and the additional jars are in the build path.
4. Run the SQL scripts form the file SS.sql.
5. Change the path of database connection url in the Hibernate.cfg.xml file if required.
10. Deploy the dynamic web project on Web Application Server Apache Tomcat 8.0. 
11. Welcome page will be found on ```SmartSplitWeb/mainPage```

## Technology used
We used IntelliJ for developing and packaging SmartSplitDao and SmartSplitCore. The java version is 1.7 and above. For developing SmartSplitWeb we used Eclipse Mars. To deploy the web application we used Apache Tomcat 8.0

## List of functionalities:
1. Login and register - All the new users need to register and then login with correct credentials. Registered users can login directly.
2. Add Transactions - A user can add a transaction with another user who has been registered beforehand.
3. View Friends' balance - After login the first screen appearing is the dashboard showing all friends and there balance.
4. View transactions with one friend - User can look at all the transactions with a single friend after clicking on one friend on the dashboard.
5. View a single transaction.
6. Update a transaction.
7. Update user information.
8. Settle up. 
9. Delete a transaction.