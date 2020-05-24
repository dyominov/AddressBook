package com.softserve.itacademy.servlet;

import com.softserve.itacademy.model.AddressBook;
import com.softserve.itacademy.model.SortOrder;
import com.softserve.itacademy.service.AddressBookService;
import com.softserve.itacademy.service.AddressBookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddressBookServlet extends HttpServlet {
    private final static String index = "/WEB-INF/view/index.jsp";
    private final static String addressForm = "/WEB-INF/view/addressform.jsp";
    private final static String home = "/WEB-INF/view/home.jsp";
    private final static String read = "/WEB-INF/view/read.jsp";

    private AddressBookService addressBooks;

    @Override
    public void init() {
        addressBooks = new AddressBookServiceImpl();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/create":
                showNewForm(request, response);
                break;
            case "/new":
                create(request, response);
                break;
            case "/read":
                read(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                edit(request, response);
            case "/list":
                allAddressBooks(request, response);
            case "/sortAsc":
                sortAsc(request, response);
                break;
            case "/sortDesc":
                sortDesc(request, response);
                break;
            default:
                home(request, response);
                break;
        }
    }

    private void sortAsc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addressBooks.sortedBy(SortOrder.ASC);
        response.sendRedirect("list");
    }

    private void sortDesc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addressBooks.sortedBy(SortOrder.DESC);
        response.sendRedirect("list");
    }


    private void home(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(home);
        dispatcher.forward(request, response);
    }


    private void allAddressBooks(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("addressBooks", addressBooks);
        request.getRequestDispatcher(index).forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(addressForm);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        AddressBook addressBook = addressBooks.read(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(addressForm);
        request.setAttribute("addressBook", addressBook);
        dispatcher.forward(request, response);

    }

    private void read(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String id = request.getParameter("id");
        AddressBook addressBook = addressBooks.read(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(read);
        request.setAttribute("addressBook", addressBook);
        dispatcher.forward(request, response);
    }


    private void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        if (addressBooks.create(name, lastName, address))
            response.sendRedirect("list");
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(addressForm);
            request.setAttribute("exist", true);
            dispatcher.forward(request, response);
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        addressBooks.update(name, lastName, address);
        allAddressBooks(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        addressBooks.delete(id);
        response.sendRedirect("list");

    }

}
