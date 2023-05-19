<%@ page import="java.util.ArrayList" %>
<%@ page import="com.learning.weatherapp.data.CitiesData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Weather App</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <style type="text/css">

  </style>
</head>
<body class="container bg-secondary-subtle" style="padding: 30px">
<h1>Compare With Average Temperature</h1>
<br>
<div class="container">
  <div class="row text-right">
    <div class="col">
      <div class="card bg-warning-subtle" style="min-height: 15rem;">
        <div class="card-body">
          <h5 class="card-title">Average Temperature</h5>
          <br>
          <h6 class="card-subtitle mb-2 text-body-secondary">Check average temperature of a city</h6>
          <p class="card-text" style="font-style: italic;">Submit 'City Name', 'Time of the day' & 'Temperature' to findout how differ its from the average temperature </p>
          <br>

          <form class="row g-3" action="/check-temp">
            <div class="mb-3">
              <label for="city_list" class="form-label">Select City</label>
              <select class="form-select" id="city_list" name="city" required aria-label="Default select example">
                <% ArrayList<String> cities = new ArrayList<>(new CitiesData().getCities().keySet());
                  for (String city: cities) {
                %>
                <option value=<%= city.replace(" ", "_").toLowerCase() %> > <%= city.substring(0,1).toUpperCase() + city.substring(1) %> </option>
                <%
                  }
                %>
              </select>

              <br>

              <label for="daytime_list" class="form-label">Select Daytime</label>
              <select class="form-select" id="daytime_list" required name="daytime" aria-label="Default select example">
                <option value="morning">Morning</option>
                <option value="evening">Evening</option>
              </select>

              <br>

              <label for="temperature_reading" class="form-label">Temperature (in degree)</label>
              <input type="number" class="form-control" name="temperature" id="temperature_reading" placeholder="Enter temperature value in degree celcius" required>
            </div>

            <div class="col-12">
              <button type="submit" class="btn btn-success">Find Results</button>
              <a href="index.jsp" class="btn btn-primary">Back Home</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
