package ru.bk.rom4ik2103;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "EstateAgencyServlet", urlPatterns = "/estateAgency" )
public class EstateAgencyServlet extends HttpServlet {
    private EstateAgency estateAgency = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request = req.getParameter("a");
        if(request.equals("create")){
            estateAgency = EstateAgency.getInstance();
            resp.sendRedirect("EctateAgency.html");
        }
        else if(request.equals("main")){
            resp.sendRedirect("EctateAgency.html");
        }
        else if(request.equals("baseOfFlats")){
            req.setAttribute("list", estateAgency);
            RequestDispatcher rDisp = getServletContext().getRequestDispatcher("/tableBase.jsp");
            rDisp.forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String loadFromXml = req.getParameter("loadFromlXml");
            if(!(loadFromXml==null||"".equals(loadFromXml))){
                estateAgency = JAXBWorker.loadFromXMLFile(new File(loadFromXml));
            }


    }

}
