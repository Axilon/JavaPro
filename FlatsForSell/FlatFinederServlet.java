package ru.bk.rom4ik2103;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "FlatFinderServlet", urlPatterns = "/finding")
public class FlatFinederServlet extends HttpServlet {
    private EstateAgency estateAgency = EstateAgency.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request = req.getParameter("saveToXml");
        if(request==null || "".equals(request)){
            resp.sendRedirect("EctateAgency.html");
        }else{
            JAXBWorker.saveToXMLFile(estateAgency,new File(request));
            resp.sendRedirect("EctateAgency.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String discription = req.getParameter("discription");
        if(discription!=null){
            Flat flat = estateAgency.findFlatByDiscription(discription);
            String text = "<html>"+
                    "<head><title>Flat</title></head>"+
                    "<body>%s</body></html>";
            String answer = flat.toString();
            answer+="<p><strong> <a href=\"/estateAgency?a=create\">Click</a> to create new\n" +
                    "        base of flats.</strong></p>";
            resp.getWriter().println(String.format(text, answer));

        }


        String fromPrice = req.getParameter("fromPrice");
        String toPrice = req.getParameter("toPrice");


        String fromRoom = req.getParameter("fromRoom");
        String toRoom = req.getParameter("toRoom");
        findingOptions(fromPrice,toPrice,fromRoom,toRoom,req,resp);

    }

    private void findingOptions(String fromPrice,String toPrice,String fromRoom,String toRoom, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Flat>list = null;
        if(fromPrice!=null && toPrice!=null){
            list = estateAgency.flatsFromToPrice(Double.parseDouble(fromPrice),Double.parseDouble(toPrice));
        }else if(fromPrice!=null && toPrice==null){
            list = estateAgency.flatsMoreThanPrice(Double.parseDouble(fromPrice));
        }else if(fromPrice==null && toPrice!=null){
            list = estateAgency.flatsLessThanPrice(Double.parseDouble(toPrice));
        }
        if(fromRoom!=null&&toRoom!=null){
            list = estateAgency.flatsFromToAmountOfRooms(Integer.parseInt(fromRoom),Integer.parseInt(toRoom));
        }else if(fromRoom!=null&&toRoom==null){
            list = estateAgency.flatsFromAmountOfRooms(Integer.parseInt(fromRoom));
        }else if(fromRoom==null&&toRoom!=null){
            list = estateAgency.flatsToAmountOfRooms(Integer.parseInt(toRoom));
        }
        if(list!=null) {
            req.setAttribute("listResult", list);
            RequestDispatcher rDisp = getServletContext().getRequestDispatcher("/tableBaseFinding.jsp");
            rDisp.forward(req, resp);
        }else{
            resp.sendRedirect("EctateAgency.html");
        }


    }
}
