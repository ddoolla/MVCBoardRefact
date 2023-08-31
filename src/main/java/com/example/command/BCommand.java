package com.example.command;

import com.example.dao.BDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
    public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
