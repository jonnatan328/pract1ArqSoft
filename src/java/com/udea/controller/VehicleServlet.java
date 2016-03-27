package com.udea.controller;

import com.udea.dao.VehicleDaoLocal;
import com.udea.model.Vehicle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet
@MultipartConfig
public class VehicleServlet extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(VehicleServlet.class.getCanonicalName());

    @EJB
    private VehicleDaoLocal vehicleDao;

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
        //Tomo el valor del campo placa del formulario
        String plate = request.getParameter("plate");
        //capturo los campos de nombre, apellido y direccion
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        //Tomo el valor del campo year del formulario
        String yearstr = request.getParameter("year");
        int year = 0;
        //Valido que el campo tenga dato
        if (yearstr != null && !yearstr.equals("")) {
            //convierto cadena de caracteres a entero
            year = Integer.parseInt(yearstr);
        }

        String image = "";
        
        final String saveDir = "vehicleIMG";
        final String path = this.getServletContext().getRealPath("") + File.separator
                + saveDir;
        final Part filePart = request.getPart("image");
        final String fileName = getFileName(filePart);
        
        File fileSaveDir = new File(path);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        OutputStream out = null;
        InputStream fileContent = null;
        final PrintWriter writer = response.getWriter();
        try {
            out = new FileOutputStream(new File(path + File.separator + fileName));
            fileContent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            LOGGER.log(Level.INFO, "File {0} being uploaded to {1}", new Object[]{fileName, path});
            image = path + File.separator + fileName;

        } catch (FileNotFoundException e) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected location");
            writer.println("<br/>Error: " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{e.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (fileContent != null) {
                fileContent.close();
            }
        }

        //llamo el constructor del POJO para crear un objeto
        Vehicle vehicle = new Vehicle(plate, brand, model, year, image);
            //creamos una lista para cargar los objetos instanciados

        List<Vehicle> lista;
        //Llamo la accion de cada boton
        if ("Add".equalsIgnoreCase(action)) {
            vehicleDao.addVehicle(vehicle);
        } else if ("Edit".equalsIgnoreCase(action)) {
            vehicleDao.editVehicle(vehicle);

        } else if ("Delete".equalsIgnoreCase(action)) {
            vehicleDao.deleteVehicle(plate);
        } else if ("Search".equalsIgnoreCase(action)) {
            String platesearch=request.getParameter("document");
            vehicle = vehicleDao.getVehicle(platesearch);
//            request.setAttribute("message", vehicle.getPlate());
//            request.setAttribute("message1", vehicle.getBrand());
//            request.setAttribute("message2", vehicle.getModel());
//            request.setAttribute("message3", vehicle.getYear());
            request.setAttribute("vehicle", vehicle);
            request.getRequestDispatcher("/vehicleInformation.jsp").forward(request, response);
        } else if ("SearchAll".equalsIgnoreCase(action)) {
            lista = vehicleDao.getAllVehicle();
        }
        //Definicion de atributos para la carga de datos
        
        //llamo todos los objetos retornados para la tabla html
        request.setAttribute("allVehicles", vehicleDao.getAllVehicle());
        //Direcciono a index.jsp
        request.getRequestDispatcher("/vehicleInformation.jsp").forward(request, response);

    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 1).replace("\"", "");
            }
        }
        return null;
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
