# VSHARE-APP

The repository contains following:
UML Diagrams: USE CASE, Class, Sequence, Activity Diagram
Frontend of REST API: VshareFrontAngular(Angular)
Backend of REST API: VShare(Spring,Maven)
Database: MySQL

The project project implements a stock broking app called 'VShare'.

*LOGIN
login of user is implemented by OAuth2 where PrincipalExtractor is used to fetch user details from googleservice and send detail to database and authorize user.
*Web Scrapping
Real time stock prices, market data and patterns and newsfeed are extracted from a website(eg Nation Stock Exchange website) with the help of JSoup and the JSON data is then send to angular and displayed with the help of a table.
*Charges Calulation
The user's total number of stocks multiplied by the stock price plus the brokerage charge is the total charge generated for the user to buy stocks.
*UserDetails
User can view the current amount of stocks they own.
