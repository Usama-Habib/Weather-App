<%@ page import="java.util.ArrayList" %>
<%@ page import="com.learning.weatherapp.data.SeasonData" %>
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
<h1>Check Season</h1>
<br>
<div class="container">
    <div class="row text-right">
        <div class="col">
            <div class="card bg-primary-subtle" style="min-height: 15rem;">
                <div class="card-body">
                    <h5 class="card-title">Country's Season</h5>
                    <br>
                    <h6 class="card-subtitle mb-2 text-body-secondary">Check Season of a year</h6>
                    <p class="card-text" style="font-style: italic;">Select Country Name and Month from the drop down</p>
                    <br>

                    <form class="row g-3" action="/check-season">
                        <div class="mb-3">
                            <label for="country_list" class="form-label">Select Country</label>
                            <select class="form-select" name="country" id="country_list" required aria-label="Default select example">
                                <% ArrayList<String> countries = new ArrayList<>(new SeasonData().getSeasons().keySet());
                                    for (String country: countries) {
                                %>
                                <option value=<%= country.replace(" ", "_").toLowerCase() %> > <%= country.substring(0,1).toUpperCase() + country.substring(1) %> </option>
                                <%
                                    }
                                %>
                            </select>

                            <br>

                            <label for="months_list" class="form-label">Select Month</label>
                            <select class="form-select" name="month" id="months_list" required aria-label="Default select example">
                                <option value="1">January</option>
                                <option value="2">Feburary</option>
                                <option value="3">March</option>
                                <option value="4">April</option>
                                <option value="5">May</option>
                                <option value="6">June</option>
                                <option value="7">July</option>
                                <option value="8">August</option>
                                <option value="9">September</option>
                                <option value="10">October</option>
                                <option value="11">November</option>
                                <option value="12">December</option>
                            </select>

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
</body>
</html>