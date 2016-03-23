
package com.udea.controller;

import com.udea.dao.ClientDaoLocal;
import com.udea.model.Client;
import java.io.IOException;
import java.io.PrintWriter;
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
            /* TODO output your page here. You may use following sample code. */
            String action=request.getParameter("action");
            //Tomo el valor del campo nrodocument del formulario
            String clientIdstr=request.getParameter("nrodocument");
            int nrodocument=0;
            //Valido que el campo tenga algun dato
            if(clientIdstr!=null && !clientIdstr.equals(""))
            //convierto cadena de caracteres a entero
                nrodocument=Integer.parseInt(clientIdstr);
            //capturo los campos de nombre, apellido y direccion
            String name=request.getParameter("name");
            String lastname=request.getParameter("lastname");
            String adress=request.getParameter("adress");
            //Tomo el valor del campo telephone del formulario
            String telephonestr=request.getParameter("telephone");
            int telephone=0;
            //Valido que el campo tenga dato
            if(telephonestr!=null && !telephonestr.equals(""))
                //convierto cadena de caracteres a entero
                telephone=Integer.parseInt(telephonestr);
            //Tomo el valor del campo cellphone del formulario
            String cellphonestr=request.getParameter("cellphone");
            int cellphone=0;
            //Valido que el campo tenga dato
            if(cellphonestr!=null && !cellphonestr.equals(""))
                //convierto cadena de caracteres a entero
                cellphone=Integer.parseInt(cellphonestr);
            //llamo el constructor del POJO para crear un objeto
            Client client=new Client (nrodocument, name, lastname, telephone, adress, cellphone);
            //creamos una lista para cargar los objetos instanciados
            
            List<Client> lista;
            //Llamo la accion de cada boton
            if("Add".equalsIgnoreCase(action)){
                clientDao.addClient(client);
            }else if("Edit".equalsIgnoreCase(action)){
                clientDao.editClient(client);
            
            }else if("Delete".equalsIgnoreCase(action)){
                clientDao.deleteClient(nrodocument);
            }else if("Search".equalsIgnoreCase(action)){                
                client = clientDao.getClient(nrodocument);
                request.setAttribute("message", client.getNrodocument());
                request.setAttribute("message1", client.getName());
                request.setAttribute("message2", client.getLastname());
                request.setAttribute("message3", client.getTelephone());
                request.setAttribute("message4", client.getAdress());
                request.setAttribute("message5", client.getCellphone());
                
                request.getRequestDispatcher("/clientInformation.jsp").forward(request, response);
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else if("SearchAll".equalsIgnoreCase(action)){
                lista=clientDao.getAllClient();
            }
                
                
                //Definicion de atributos para la carga de datos
                request.setAttribute("client", client);
                //llamo todos los objetos retornados para la tabla html
                request.setAttribute("allClients", clientDao.getAllClient());
                //Direcciono a index.jsp
                
                request.getRequestDispatcher("/clientInformation.jsp").forward(request, response);
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
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
