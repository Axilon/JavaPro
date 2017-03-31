package ru.bk.rom4ik2103;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet{
    static final String TEMPLATE = "<html>"+
            "<head><title>Anketa</title></head>"+
            "<body>%s</body></html>";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String answer = "";
        String action = req.getParameter("action");
        try{
            int firstNumber = Integer.parseInt(req.getParameter("firstNumber"));
            int secondNumber = Integer.parseInt(req.getParameter("secondNumber"));

            if (action.equals("division")) {
                answer += division( firstNumber,  secondNumber,  action);
            } else {

                answer += additionDeductionMultiplication(firstNumber, secondNumber, action);


            }
            answer+="<strong> Result = ";
                    answer += "<strong><br><br>";
            answer += "<hr>For new calculations press <a href='/calculator?a=newOne'>link</a>";
            resp.getWriter().println(String.format(TEMPLATE, answer));
        }catch(NullPointerException|NumberFormatException e){
            answer+=" <h1>" +e.getMessage()+ "</h1><br>";
            answer+="<hr>For new calculations press <a href='/calculator?a=newOne'>link</a>";
            resp.getWriter().println(String.format(TEMPLATE, answer));
        }

        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request = req.getParameter("a");
        if(request.equals("newOne")){
            resp.sendRedirect("CalculatorVersionOne.html");
        }
    }

    private final String division(int firstNumber, int secondNumber, String action) {

        if(secondNumber==0){
            return "Can not be division by 0 - zero";
        }
        double divide = firstNumber/secondNumber;
        String result = Double.toString(divide);

        return result;
    }
    private final String additionDeductionMultiplication(int firstNumber, int secondNumber, String action) {
        String result = "";
        if(action.equals("addition")){
            int addit = firstNumber+secondNumber;
            result = Integer.toString(addit);
        } else if(action.equals("deduction")){
            int deduct = firstNumber-secondNumber;
            result = Integer.toString(deduct);
        }else if(action.equals("multiplication")){
            int mult = firstNumber*secondNumber;
            result = Integer.toString(mult);
        }

        return result;
    }
}
