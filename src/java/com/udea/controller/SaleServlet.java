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
        response.setContentType("text/plain");
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("registrar")) {

            //Defino y obtengo los datos del formulario.
            String clientIdstr = request.getParameter("nrodocument");
            String vehicleID = request.getParameter("plate");
            String yearstr = request.getParameter("year");
            String monthstr = request.getParameter("month");
            String daystr = request.getParameter("day");
            String installmentsstr = request.getParameter("installments");
            String installmentAmountstr = request.getParameter("installmentAmount");

            //Defino los datos que serán int.
            long clientId = 0;
            int year = 0;
            int month = 0;
            int day = 0;
            int installments = 0;
            long installmentAmount = 0;

            //Verifico que los datos existan y no sean vacios.
            if (clientIdstr != null && !clientIdstr.equals("")) {
                //convierto cadena de caracteres a int
                clientId = Long.parseLong(clientIdstr);
            } else {
                request.setAttribute("ERROR", "Identificacion invalida.");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }
            if (yearstr != null && !yearstr.equals("")) {
                //convierto cadena de caracteres a int
                year = Integer.parseInt(yearstr);
            } else {
                request.setAttribute("ERROR", "Año invalido.");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }
            if (monthstr != null && !monthstr.equals("")) {
                //convierto cadena de caracteres a int
                month = Integer.parseInt(monthstr);
            } else {
                request.setAttribute("ERROR", "Mes invalido.");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }
            if (daystr != null && !daystr.equals("")) {
                //convierto cadena de caracteres a int
                day = Integer.parseInt(daystr);
            } else {
                request.setAttribute("ERROR", "Dia invalido.");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }
            if (installmentsstr != null && !installmentsstr.equals("")) {
                //convierto cadena de caracteres a int
                installments = Integer.parseInt(installmentsstr);
            } else {
                request.setAttribute("ERROR", "Cantidad de cuotas invalidas.");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }
            if (installmentAmountstr != null && !installmentAmountstr.equals("")) {
                //convierto cadena de caracteres a int
                installmentAmount = Long.parseLong(installmentAmountstr);
            } else {
                request.setAttribute("ERROR", "Valor de cuota invalido.");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }

            //Defino variables de busqueda
            Client client;
            Vehicle vehicle;

            //Verifico que el cliente exista.
            client = clientDao.getClient(clientId);
            if (client == null) {
                request.setAttribute("ERROR", "Error, el cliente no existe");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }

            //Verifico que el auto exista.
            vehicle = vehicleDao.getVehicle(vehicleID);
            if (vehicle == null) {
                request.setAttribute("ERROR", "Error, el vehiculo ingreaso no existe");
                request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
                return;
            }

            //Creo el registro y lo guardo en la base de datos.
            Sale sale = new Sale(0, client, vehicle, new Date(year-1900, month-1, day), installments, installmentAmount);
            saleDao.addSale(sale);
            request.setAttribute("SUCCESS", "Venta ingresada con exito.");
            request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
            return;

        } else if (action.equalsIgnoreCase("mostrar todos")) {
            //Busco todos los registros de ventas y los envio a la vista.
            List<Sale> sales = saleDao.getAllSales();
            request.setAttribute("allsales", sales);
            request.getRequestDispatcher("saleInformation.jsp").forward(request, response);
        }
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
