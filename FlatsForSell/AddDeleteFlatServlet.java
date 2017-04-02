package ru.bk.rom4ik2103;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "AddDeleteFlatServlet", urlPatterns = "/estateAgencyAddDeleteFlat")
public class AddDeleteFlatServlet extends HttpServlet {
    private EstateAgency estateAgency = EstateAgency.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String discription = req.getParameter("discription");
        estateAgency.deleteFlatFromList(discription);
        resp.sendRedirect("EctateAgency.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException, NullPointerException {
        String discription = req.getParameter("discription");
        int roomAmount = Integer.parseInt(req.getParameter("roomAmount"));
        String adress = req.getParameter("adress");
        int floor = Integer.parseInt(req.getParameter("floor"));
        double price = Double.parseDouble(req.getParameter("price"));
        if(!(discription==null && roomAmount==0 && adress==null&&floor==0 && price==0)){
            estateAgency.addFlat(new Flat(discription,roomAmount,adress,floor,price));
            resp.sendRedirect("EctateAgency.html");
        }
    }
}
