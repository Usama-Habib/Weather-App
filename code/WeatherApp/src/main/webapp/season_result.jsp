<%@ page import="java.nio.file.Path" %>
<%@ page import="java.security.spec.RSAOtherPrimeInfo" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Season Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body class="container bg-secondary-subtle" style="padding: 30px">
<div>
    <%!
        public String toFirstLetterCapCase(String s){
            return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
        }
    %>

    <%
        String season = toFirstLetterCapCase(request.getAttribute("season").toString());
        String country = toFirstLetterCapCase(request.getAttribute("country").toString());
        String month = toFirstLetterCapCase(request.getAttribute("month").toString());
        String image_url = request.getContextPath() + "/images/" + season.toLowerCase().concat(".png");
    %>
    <h1>Season in <%= country%> in Month of <%= month%></h1>
</div>
<br>
<br>
<div style="display: flex;">


    <div class="card" style="width: 20rem; padding: 10px; margin-right: 30px;">
        <img src=<%= image_url %>  class="card-img-top" alt=<%= season %>>
        <div class="card-body">
            <h5 class="card-title"><%= month %></h5>
            <p class="card-text"><%= season %></p>
        </div>
    </div>

</div>
<div style="padding-top: 30px;">
    <a href="check_season.jsp" class="btn btn-success">Go Back</a>
    <a href="index.jsp" class="btn btn-primary">Go Home</a>
</div>
</body>
</html>