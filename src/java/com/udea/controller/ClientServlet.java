package com.udea.controller;

import com.udea.dao.ClientDaoLocal;
import com.udea.model.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientServlet extends HttpServlet {

    @EJB
    private ClientDaoLocal clientDao;

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
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            Client client;

            if (action.equalsIgnoreCase("Registrar") || action.equalsIgnoreCase("editar")) {
                //Tomo el valor del campo nrodocument del formulario
                String clientIdstr = request.getParameter("nrodocument");
                long nrodocument = 0;
                //Valido que el campo tenga algun dato
                if (clientIdstr != null && !clientIdstr.equals("")) {
                    //convierto cadena de caracteres a entero
                    nrodocument = Long.parseLong(clientIdstr);
                } else {
                    request.setAttribute("ERROR", "Ingrese un numero de documento valido.");
                    request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                    return;
                }
                //capturo los campos de nombre, apellido y direccion
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String address = request.getParameter("address");
                //Tomo el valor del campo telephone del formulario
                String phone = request.getParameter("phone");
                //Tomo el valor del campo cellphone del formulario
                String cellphone = request.getParameter("cellphone");
                //Tomo los valores de la fecha de nacimiento del formulario
                String yearstr = request.getParameter("year");
                String monthstr = request.getParameter("month");
                String daystr = request.getParameter("day");
                
                //creo las variables de tipo int de la fecha de nacimiento
                int year = 0;
                int month = 0;
                int day = 0;
                
                //convierto las cadenas de string de la fecha de nacimiento a int
                if(yearstr != null && !yearstr.equalsIgnoreCase("")){
                    year = Integer.parseInt(yearstr);
                }
                if(monthstr != null && !monthstr.equalsIgnoreCase("")){
                    month = Integer.parseInt(monthstr);
                }
                if(daystr != null && !daystr.equalsIgnoreCase("")){
                    day = Integer.parseInt(daystr);
                }

                //Verifico si el cliente ya existe y se esta añadiendo.
                client = clientDao.getClient(nrodocument);
                if (client != null && !action.equalsIgnoreCase("editar")) {
                    request.setAttribute("ERROR", "El cliente ingresado ya existe.");
                    client = new Client(nrodocument, name, lastname, phone, address, cellphone, new Date(year-1900,month-1,day));
                    request.setAttribute("client", client);
                    request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                    return;
                }

                //Creo la instancia del cliente que se desea añadir o editar.
                client = new Client(nrodocument, name, lastname, phone, address, cellphone, new Date(year-1900,month-1,day));
                //Verifico si se desea añadir y o editar
                if (action.equalsIgnoreCase("registrar")) {
                    //Añado el cliente a la base de datos.
                    request.setAttribute("SUCCESS", "Cliente registrado con exito.");
                    clientDao.addClient(client);
                } else {
                    //Edito el cliente de la base de datos.
                    request.setAttribute("SUCCESS", "Cliente editado con exito.");
                    clientDao.editClient(client);
                }
                request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                return;

            } else if (action.equalsIgnoreCase("borrar")) {
                //Obtengo la identificacion del cliente que se desea borrar.
                String clientIdstr = request.getParameter("nrodocument");
                long nrodocument = 0;
                //Verifico que la identificacion ingresada exista.
                if (clientIdstr != null && !clientIdstr.equals("")) {
                    //Transformo el valor de la identificacioon a long.
                    nrodocument = Long.parseLong(clientIdstr);
                } else {
                    request.setAttribute("ERROR", "Ingrese un numero de documento valido.");
                    request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                    return;
                }

                //Verifico que el cliente exista.
                client = clientDao.getClient(nrodocument);
                if (client == null) {
                    request.setAttribute("ERROR", "El cliente que desea borrar no existe.");
                    request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                    return;
                }
                //Borro el cliente de la base de datos.
                clientDao.deleteClient(nrodocument);
                request.setAttribute("SUCCESS", "El cliente ha sido eliminado con exito.");
                request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                return;
            } else if (action.equalsIgnoreCase("buscar")) {
                //Obtengo la identificacion del cliente que se desea buscar.
                String clientIdstr = request.getParameter("nrodocument");
                long nrodocument = 0;
                //Verifico que la identificacion ingresada exista.
                if (clientIdstr != null && !clientIdstr.equals("")) {
                    nrodocument = Long.parseLong(clientIdstr);
                } else {
                    request.setAttribute("ERROR", "Ingrese un numero de documento valido.");
                    request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                    return;
                }
                //Verifico que el cliente exista
                client = clientDao.getClient(nrodocument);
                if (client == null) {
                    request.setAttribute("ERROR", "El cliente no existe.");
                    request.getRequestDispatcher("clientInformation.jsp").forward(request, response);
                    return;
                }
                //Definicion de atributos para la carga de datos
                request.setAttribute("client", client);
                request.setAttribute("searchall", false);
                request.getRequestDispatcher("/clientInformation.jsp").forward(request, response);
                return;
            } else if (action.equalsIgnoreCase("mostrar todos")) {
                //Obtengo todos los registros de clientes de la base de datos.
                List<Client> lista = clientDao.getAllClient();
                //Definicion de atributos para la carga de datos
                request.setAttribute("allClients", lista);
                request.setAttribute("searchall", true);
                request.getRequestDispatcher("/clientInformation.jsp").forward(request, response);
                return;
            }
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
