# NewsApp - A Case Study

## Problem Statement

 Test the existing system which searches for news article, open the article and add an article to favourite list.

## Requirements specifications of Application Under test

- The application needs to fetch news article from the following API.
    1. https://newsapi.org/

    2. Example API:
    - https://newsapi.org/v2/everything?q=bitcoin&from=2019-01-06&sortBy=publishedAt&apiKey=b170738ea8d145159da715566679a48fea

- A frontend where the user can register/login to the application, search for article, open interested new article and add article to favourite list.
- User can add an article into favourite list and should be able to view the favourite articles for user.

## Modules

### UserService - should be able to manage user accounts.
### UI (User interface) -  should be able to
    1. Search for a news article
    2. View or open an article 
    3. Add an article to favourite list
    4. should be able to see favourite articles
    5. UI should be responsive which can run smoothly on various devices 
### FavouriteService - should be able to store all the favourite articles for a user

## Tech Stack
- Spring Boot
- Angular
- CI (Gitlab Runner)
- Docker, Docker Compose

## Flow of Modules

### Building frontend
- Building responsive views: 
    1. Register/Login
    2. Search for an article
    3. Article list - populating from external API
    4. Build a view to show favourite articles
- Using Services to populate these data in views
- Stitching these views using Routes and Guards 
- Making the UI Responsive
- Writing CI configuration file
- Dockerize the frontend

### Building the UserService
- Creating a server in Spring Boot to facilitate user registration and login using JWT token and MySQL
- Writing swagger documentation
- Write CI Configuration
- Dockerize the application
- Write docker-compose file to build both frontend and backend application

### Building the Favourite Service
- Building a server in Spring Boot to facilitate CRUD operation over favourite articles stored in MySQL
- Writing Swagger Documentation
- Write CI Configuration
- Dockerize the application
- Update the docker-compose

## Added functionality to be implemented

Create Profile Page
- Create Edit Profile / Change Password page (Email address cannot be changed)
- Upload profile image while register & displaying the same in toolbar after login

## Test the entire application 

- Unit Testing for UserService and FavoriteService 
- Web application has to be tested using Selenium-Cucumber framework
- Angular front end has to be tested using Protractor
- REST API - UserService and FavoriteService should be tested using REST Assured.
