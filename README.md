# Spring Boot, Spring MVC, Thymeleaf

A Simple Web Application for current weather in a city

## Steps to Setup
**1. Clone the repository**
```bash
git clone https://github.com/hikolu/weather-web-app.git
```

**2. Get an API key for OpenWeatherMap**
- Click following link: https://openweathermap.org/
- Create an account on the website
- Click on you pofile
- Click on "My Api keys"
- Copy your API key

**3. Add your API to the app**
+ open `src/main/resources/application.properties`
+ add this line: `api.openweathermap.key=apiKey` and replace "apiKey" with the key you copied

**4. Run the application using maven**
```bash
mvn spring-boot:run
```
**OR**
Run the application using your IDE

The Application will start running on <http:/localhost:8080>

## Explore the app
+ open in your browser the following link: <http:/localhost:8080/api/current-weather?city={city}&country={country}
+ replace what is in curly brackets (including the brackets) with the city you want and the country it is in accordingly
