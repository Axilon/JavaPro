package ru.bk.rom4ik2103;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet(name = "anketa", urlPatterns = "/anketa")
public class AnketaServlet extends  HttpServlet{
    static final String TEMPLATE = "<html>"+
            "<head><title>Anketa</title></head>"+
            "<body>%s</body></html>";
    private static ArrayList<SomeOne> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String answer ="";
       String request = req.getParameter("a");
       if(request.equals("newOne")){
           resp.sendRedirect("Anketa.html");
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        int age = Integer.parseInt(req.getParameter("age"));
        String answer1 = req.getParameter("answer1");
        String answer2 = req.getParameter("answer2");

        SomeOne someone = new SomeOne(name,surName,age,answer1,answer2);
        list.add(someone);
        String answer = "";
        answer+=formateAnswers();
        answer+= "For new answers press <a href='/anketa?a=newOne'>link</a>";
        resp.getWriter().println(String.format(TEMPLATE, answer));
    }
        private String formateAnswers(){
        String answer = "<table border='3' bgcolor=lightblue bordercolor='#808080' ><caption>Answer results</caption><tr align=center><th>Name</th><th>Second Name</th><th>Age</th><th>Sex</th><th>Do you like Java?</th></tr>";
        String countAnswer="<table border='2' bgcolor=lightblue bordercolor='#808080'><tr align=center><th>Males</th><th>Females</th><th>Likes Java</th><th>Dislikes Java</th></tr>";
        int countMales = 0;
        int countFemales = 0;
        int countLikes = 0;
        int countDislikes = 0;

        for (SomeOne user: list) {
                answer+= "<tr align=center><td>"+user.getName()+"</td><td>"+user.getSurName()+"</td><td>"+user.getAge()+"</td><td>"+user.getAnswer1()+"</td><td>"+user.getAnswer2()+"</td></tr>";
                if (user.getAnswer1().equals("Male")){
                    countMales++;
                }else if(user.getAnswer1().equals("Female")){
                    countFemales++;
                }
                if(user.getAnswer2().equals("Yes")){
                    countLikes++;
                }else if(user.getAnswer2().equals("No")){
                    countDislikes++;
                }
            }
            answer+="</table>"+ countAnswer;
            answer+="<tr align=center><td>"+countMales+"</td><td>"+countFemales+"</td><td>"+countLikes+"</td><td>"+countDislikes+"</td></tr></table><hr>";
        return answer;
        }


}
