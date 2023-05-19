<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<h1>Welcome to the Weather Application</h1>
<br>
<br>

<div class="container">
    <div class="row text-right">
        <div class="col">
            <div class="card bg-primary-subtle" style="min-height: 15rem;">
                <div class="card-body">
                    <h5 class="card-title">Country's Season</h5>
                    <br>
                    <h6 class="card-subtitle mb-2 text-body-secondary">Check Season of a year</h6>
                    <p class="card-text" style="font-style: italic;">Find season of the year by providing country name and the month</p>
                    <br>
                    <a href="check_season.jsp" class="card-link">Find Season</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card" style="min-height: 15rem;">
                <div class="card-body bg-warning-subtle">
                    <h5 class="card-title">Average temperature</h5>
                    <br>
                    <h6 class="card-subtitle mb-2 text-body-secondary">Check average temperature of a city</h6>
                    <p class="card-text" style="font-style: italic;">Find whether temperate is above or below the average temperature</p>
                    <br>
                    <a href="check_avg_temp.jsp" class="card-link">Find Temperature</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>