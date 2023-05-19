<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>City Temperature Result</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<style type="text/css">
  .row{
    padding: 20px;
    border: 1px solid black;
    color: white;
    background-color: black;
    font-size: 1.5rem;
  }
</style>
<body class="container bg-secondary-subtle" style="padding: 30px">
<%!
  public String toFirstLetterCapCase(String s){
    return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
  }
%>
<%
  String city = toFirstLetterCapCase(request.getAttribute("city").toString());
  int avg_temp_morning = Integer.parseInt(request.getAttribute("avg_temp_morning").toString());
  int avg_temp_evening = Integer.parseInt(request.getAttribute("avg_temp_evening").toString());
  String result = request.getAttribute("result").toString();
%>

<div>
  <h1>Temperature in <%= city%></h1>
</div>
<br>
<br>
<div style="display: flex;">

  <div class="container text-center">
    <div class="row">
      <div class="col">
        Mean Morning Temperature
      </div>
      <div class="col">
        Mean Evening Temperature
      </div>
      <div class="col">
        Temperature Difference
      </div>

    </div>

    <div class="row">
      <div class="col">
        <%= avg_temp_morning%>°C
      </div>
      <div class="col">
        <%= avg_temp_evening%>°C
      </div>
      <div class="col">
        <%= result%>
      </div>

    </div>
  </div>
</div>

<div style="padding-top: 30px;">
  <a href="check_avg_temp.jsp" class="btn btn-success">Go Back</a>
  <a href="index.jsp" class="btn btn-primary">Go Home</a>
</div>
</body>
</html>
