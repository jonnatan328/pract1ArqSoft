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
    private final String SAVEDIR = "vehicleIMG";

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

        //Tomo el valor del campo action del formulario
        String action = request.getParameter("action");
        //defino la variable vehicle
        Vehicle vehicle;

        //Verifico el tipo de accion a ejecutar.
        if (action.equalsIgnoreCase("registrar") || action.equalsIgnoreCase("editar")) {
            //Tomo el valor del campo plate del formulario
            String plate = request.getParameter("plate");

            //valido que el vehiculo no exista en la base de datos
            vehicle = vehicleDao.getVehicle(plate);
            if (vehicle != null && !action.equalsIgnoreCase("editar")) {
                request.setAttribute("ERROR", "El vehiculo ya está registrado.");
                request.setAttribute("vehicle", vehicle);
                request.getRequestDispatcher("vehicleInformation.jsp").forward(request, response);
                return;
            }

            //Tomo el valor del campo brand del formulario
            String brand = request.getParameter("brand");
            //Tomo el valor del campo model del formulario
            String model = request.getParameter("model");
            //Tomo el valor del campo year del formulario
            String yearstr = request.getParameter("year");
            //Tomo el valor del campo color del formulario
            String color = request.getParameter("color");
            //Tomo el valor del campo fuel del formulario
            String fuel = request.getParameter("fuel");
            //Tomo el valor del campo transmission del formulario
            String transmission = request.getParameter("transmission");
            //Tomo el valor del campo doors del formulario
            String doorssrt = request.getParameter("doors");
            //Tomo el valor del campo price del formulario
            String pricestr = request.getParameter("price");

            //Defino las variables de tipo int
            int year = 0;
            int doors = 0;
            long price = 0;
            
            //Valido que los campos tengan datos y convierto a int
            if (yearstr != null && !yearstr.equals("")) {
                year = Integer.parseInt(yearstr);
            }
            if (doorssrt != null && !doorssrt.equals("")) {
                doors = Integer.parseInt(doorssrt);
            }
            if (pricestr != null && !pricestr.equals("")) {
                price = Long.parseLong(pricestr);
            }

            //Declaro la variable de la ruta de la imagen.
            String image = "";
            final Part filePart = request.getPart("image");
            
            //Verifico si se ingresó algun archivo, si no es el caso la ruta de la imagen es vacia.
            if (filePart.getSize()>0) {

                //Defino la ruta donde se va a guardar la imagen.
                final String path = this.getServletContext().getRealPath("") + File.separator
                        + SAVEDIR;
                //Obtengo el nombre del archivo.
                final String fileName = getFileName(filePart);

                //Verifico que el archivo tenga el formato de imagen (jpg,png,jpeg)
                if (!fileName.contains(".jpg") && !fileName.contains(".png") && !fileName.contains(".jpeg")) {
                    request.setAttribute("ERROR", "La imagen seleccionada debe tener el formato .jpg o .png.");
                    vehicle = new Vehicle(plate, brand, model, year, color, fuel, transmission, doors, price, "");
                    request.setAttribute("vehicle", vehicle);
                    request.getRequestDispatcher("vehicleInformation.jsp").forward(request, response);
                    return;
                }

                //Se crea el directorio donde se almacenaran las imagenes.
                File fileSaveDir = new File(path);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                
                //Proceso las partes de las imagenes y se guarda en el disco.
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
            }
            //llamo el constructor del POJO para crear un objeto
            vehicle = new Vehicle(plate, brand, model, year, color, fuel, transmission, doors, price, image);
           //Verifico si se desea registrar o editar un registro.
            if (action.equalsIgnoreCase("registrar")) {
                //Registro el vehiculo en la base de datos.
                vehicleDao.addVehicle(vehicle);
                request.setAttribute("SUCCESS", "Vehiculo ingresado exitosamente.");
                request.getRequestDispatcher("vehicleInformation.jsp").forward(request, response);
                return;

            }
            //Edito el registro de la base de datos.
            vehicleDao.editVehicle(vehicle);
            request.setAttribute("SUCCESS", "Vehiculo editado exitosamente.");
            request.getRequestDispatcher("vehicleInformation.jsp").forward(request, response);
            return;

        } else if (action.equalsIgnoreCase("borrar")) {
            //Busco el registro que se desea eliminar.
            String plate = request.getParameter("plate");
            vehicle = vehicleDao.getVehicle(plate);
            //Verifico que el registro exista.
            if (vehicle == null) {
                request.setAttribute("ERROR", "El vehiculo que desea eliminar no existe.");
                request.getRequestDispatcher("vehicleInformation.jsp").forward(request, response);
                return;
            }
            //Borro el registro de la base de datos.
            vehicleDao.deleteVehicle(plate);
            request.setAttribute("SUCCESS", "El vehiculo se ha eliminado correctamente.");
            request.getRequestDispatcher("vehicleInformation.jsp").forward(request, response);
            return;

        } else if (action.equalsIgnoreCase("buscar")) {
            //Busco el registro solicitado.
            String platesearch = request.getParameter("plate");
            vehicle = vehicleDao.getVehicle(platesearch);
            //Verifico que el registro exista.
            if (vehicle == null) {
                request.setAttribute("ERROR", "La placa del vehiculo ingresado no existe.");
                request.getRequestDispatcher("/vehicleSearch.jsp").forward(request, response);
                return;
            }
            //Verifico si el vehiculo tiene una ruta de imagen.
            if(vehicle.getImage().equalsIgnoreCase("")){
                //Envio una imagen por defecto cuando no existe ruta.
                request.setAttribute("img","img/nocar.jpg");
            }
            else{
                //Obtengo la ruta de la imagen y la envio a la vista.
                File file = new File(vehicle.getImage());
                request.setAttribute("img", SAVEDIR + "/" + file.getName());
            }
            //Envio el vehiculo buscado.
            request.setAttribute("searchAll", false);
            request.setAttribute("vehicle", vehicle);
            request.getRequestDispatcher("/vehicleSearch.jsp").forward(request, response);
            return;
        } else if (action.equalsIgnoreCase("mostrar todos")) {
            //Obtengo todos los registros de vehiculos y los envio a la vista.
            List<Vehicle> list = vehicleDao.getAllVehicle();
            request.setAttribute("searchAll", true);
            request.setAttribute("allVehicles", list);
            request.getRequestDispatcher("/vehicleSearch.jsp").forward(request, response);
            return;
        }
    }

    //Funcion para obtener el nombre de un archivo subido
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
