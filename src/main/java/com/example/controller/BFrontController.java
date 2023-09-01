package com.example.controller;

import com.example.command.*;
import com.example.exception.CommandCustomException;
import com.example.exception.ControllerCustomException;

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

        String command = request.getServletPath(); // context-root 를 제외한 URI 리턴
        System.out.println("command = " + command);

        RoutingTarget target = router(command);

        try {
            target.getBCommand().execute(request, response);
            request.getRequestDispatcher(target.getJspPage()).forward(request, response);

        } catch (CommandCustomException | ControllerCustomException e) {
            request.setAttribute("error_msg", e.getMessage());
            request.getRequestDispatcher("/error/errorPage.jsp").forward(request, response);
        }

    } // -- actionDo()

    private static class RoutingTarget {

        private final BCommand BCommand;
        private final String jspPage;

        public RoutingTarget(BCommand BCommand, String jspPage) {
            this.BCommand = BCommand;
            this.jspPage = jspPage;
        }

        public BCommand getBCommand() {
            return BCommand;
        }

        public String getJspPage() {
            return jspPage;
        }
    }

    public RoutingTarget router(String command) throws ControllerCustomException {
        switch (command) {
            case "/list.do":
                return new RoutingTarget(new BListCommand(), "/view/list.jsp");
            case "/write.do":
                return new RoutingTarget(new BInsertCommand(), "/list.do");
            case "/content_view.do":
                return new RoutingTarget(new BContentCommand(), "/view/content_view.jsp");
            case "/modify.do":
                return new RoutingTarget(new BModifyCommand(), "/list.do");
            case "/delete.do":
                return new RoutingTarget(new BDeleteCommand(), "/list.do");
            case "/reply_view.do":
                return new RoutingTarget(new BReplyViewCommand(), "/view/reply_view.jsp");
            case "/reply.do":
                return new RoutingTarget(new BReplyCommand(), "/list.do");
            default:
                throw new ControllerCustomException("command 요청이 잘못되었습니다.");
        }
    } // -- router()

}
