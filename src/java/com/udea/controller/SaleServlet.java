package com.udea.controller;

import com.udea.dao.ClientDaoLocal;
import com.udea.dao.SaleDaoLocal;
import com.udea.dao.VehicleDaoLocal;
import com.udea.model.Client;
import com.udea.model.Sale;
import com.udea.model.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaleServlet extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(VehicleServlet.class.getCanonicalName());

    @EJB
    private VehicleDaoLocal vehicleDao;
    @EJB
    private ClientDaoLocal clientDao;
    @EJB
    private SaleDaoLocal saleDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("add")) {
            String clientId = request.getParameter("nrodocument");
            String vehicleID = request.getParameter("plate");
            int year = Integer.parseInt(request.getParameter("year"));
            int month = Integer.parseInt(request.getParameter("month"));
            int day = Integer.parseInt(request.getParameter("day"));

            Client client;
            Vehicle vehicle;

            client = clientDao.getClient(Integer.parseInt(clientId));
            if (client == null) {
                return;
            }
            vehicle = vehicleDao.getVehicle(vehicleID);
            if (vehicle == null) {
                return;
            }
            Sale sale = new Sale(0, client, vehicle, new Date(year, month, day));

            saleDao.addSale(sale);
            request.getRequestDispatcher("saleInformation.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("remove")) {
            request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("searchall")) {
            List<Sale> sales = saleDao.getAllSales();
            request.setAttribute("allsales", sales);
            request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
        }

        request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
