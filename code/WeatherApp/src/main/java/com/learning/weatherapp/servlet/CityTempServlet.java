package com.learning.weatherapp.servlet;

import com.learning.weatherapp.data.CitiesData;
import com.learning.weatherapp.service.Temperature;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "cityServlet", value = "/check-temp")
public class CityTempServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city").strip().replace("_"," ");
        String day_time = req.getParameter("daytime");
        int temperature = Integer.parseInt(req.getParameter("temperature"));

        // CALL TEMPERATURE SERVICE TO PERFORM THE NECESSARY ACTION
        Temperature tempService = new Temperature();
        String result = tempService.find_temperature(city,day_time,temperature);
        req.setAttribute("city", city);
        req.setAttribute("avg_temp_morning", tempService.findCityTempAt(req.getParameter("city"),"morning"));
        req.setAttribute("avg_temp_evening", tempService.findCityTempAt(req.getParameter("city"),"evening"));
        req.setAttribute("result",result);
        req.getRequestDispatcher("temperature_result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
