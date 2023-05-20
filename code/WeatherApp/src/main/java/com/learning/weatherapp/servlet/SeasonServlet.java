package com.learning.weatherapp.servlet;

import com.learning.weatherapp.MONTHS;
import com.learning.weatherapp.data.SeasonData;
import com.learning.weatherapp.dto.SeasonDuration;
import com.learning.weatherapp.service.Season;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "seasonServlet", value = "/check-season")
public class SeasonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TAKE USER INPUTS
        String country = req.getParameter("country").replace("_", " ");
        int month = Integer.parseInt(req.getParameter("month"));

        // CALL SEASON SERVICE TO PERFORM THE NECESSARY ACTION
        Season seasonService = new Season();
        String season = seasonService.find_season(country,month);
        req.setAttribute("country", country);
        req.setAttribute("month", MONTHS.values()[month-1]);
        req.setAttribute("season", season);
        req.getRequestDispatcher("season_result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
