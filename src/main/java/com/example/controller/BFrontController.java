package com.example.controller;

import com.example.command.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class BFrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        actionDo(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        actionDo(request, response);
    }

    public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        String command = uri.substring(contextPath.length());
        System.out.println("command = " + command);

        String jspPage = "";
        BCommand bCommand = null;

        switch (command) {
            case "/list.do":
                bCommand = new BListCommand();
                jspPage = "/list.jsp";
                break;
            case "/write.do":
                bCommand = new BInsertCommand();
                jspPage = "/list.do";
                break;
            case "/content_view.do":
                bCommand = new BContentCommand();
                jspPage = "/content_view.jsp";
                break;
            case "/modify.do":
                bCommand = new BModifyCommand();
                jspPage = "/list.do";
                break;
            case "/delete.do":
                bCommand = new BDeleteCommand();
                jspPage = "/list.do";
                break;
            case "/reply_view.do":
                bCommand = new BReplyViewCommand();
                jspPage = "/reply_view.jsp";
                break;
            case "/reply.do":
                bCommand = new BReplyCommand();
                jspPage = "/list.do";
        }
        bCommand.execute(request, response);

//        if (command.equals("/list.do")) {
//            BCommand bCommand = new BListCommand();
//            bCommand.execute(request, response);
//            jspPage = "/list.jsp";
//
//        } else if (command.equals("/write.do")) {
//            BCommand bCommand = new BInsertCommand();
//            bCommand.execute(request, response);
//            jspPage = "/list.do";
//
//        } else if (command.equals("/content_view.do")) {
//            BCommand bCommand = new BContentCommand();
//            bCommand.execute(request, response);
//            jspPage = "/content_view.jsp";
//
//        } else if (command.equals("/modify.do")) {
//            BCommand bCommand = new BModifyCommand();
//            bCommand.execute(request, response);
//            jspPage = "/list.do";
//
//        } else if (command.equals("/delete.do")) {
//            BCommand bCommand = new BDeleteCommand();
//            bCommand.execute(request, response);
//            jspPage = "/list.do";
//
//        } else if (command.equals("/reply_view.do")) {
//            BCommand bCommand = new BReplyViewCommand();
//            bCommand.execute(request, response);
//            jspPage = "/reply_view.jsp";
//        } else if (command.equals("/reply.do")) {
////            BCommand bCommand = new BReplyCommand();
////            bCommand.execute(request, response);
////            jspPage = "/list.do";
////        }

        request.getRequestDispatcher(jspPage).forward(request, response);
    }
}
