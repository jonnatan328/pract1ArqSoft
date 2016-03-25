
package com.udea.controller;

import com.udea.dao.VehicleDaoLocal;
import com.udea.model.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



@WebServlet(name = "VehicleServlet", urlPatterns = {"/Vehicle"})
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class VehicleServlet extends HttpServlet {
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

           String action=request.getParameter("action");
            //Tomo el valor del campo placa del formulario
            String plate=request.getParameter("plate");
            //capturo los campos de nombre, apellido y direccion
            String brand=request.getParameter("brand");
            String model=request.getParameter("model");
            //Tomo el valor del campo year del formulario
            String yearstr=request.getParameter("year");
            int year=0;
            //Valido que el campo tenga dato
            if(yearstr!=null && !yearstr.equals(""))
                //convierto cadena de caracteres a entero
                year=Integer.parseInt(yearstr);
            
            
            String image="ggd";
             // Check that we have a file upload request
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
             if (isMultipart) {
	        	// Create a factory for disk-based file items
	        	FileItemFactory factory = new DiskFileItemFactory();

	        	// Create a new file upload handler
	        	ServletFileUpload upload = new ServletFileUpload(factory);
                        request.getInputStream();
	            try {
	            	// Parse the request
	            	List<FileItem> items = upload.parseRequest(request);
                        if (items != null && items.size() > 0) {
                            Iterator iterator = items.iterator();
                            while (iterator.hasNext()) {
                                FileItem item = (FileItem) iterator.next();
                                if (!item.isFormField()) {
                                    String fileName = item.getName();	 
                                    String root = getServletContext().getRealPath("/");
                                    File path = new File(root + "/images");
                                    
                                    if (!path.exists()) {
                                        boolean status = path.mkdirs();
                                    }

                                    File uploadedFile = new File(path + "/" + fileName);
                                    //System.out.println(uploadedFile.getAbsolutePath());
                                    PrintWriter out = response.getWriter();
                                    image=uploadedFile.getAbsolutePath();
                                    item.write(uploadedFile);
                                }
                            }
                        }
	            } catch (FileUploadException e) {
	                e.printStackTrace();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
            
   
            //llamo el constructor del POJO para crear un objeto
            Vehicle vehicle=new Vehicle (plate, brand, model, year, image);
            //creamos una lista para cargar los objetos instanciados
            
            List<Vehicle> lista;
            //Llamo la accion de cada boton
            if("Add".equalsIgnoreCase(action)){
                vehicleDao.addVehicle(vehicle);
            }else if("Edit".equalsIgnoreCase(action)){
                vehicleDao.editVehicle(vehicle);
            
            }else if("Delete".equalsIgnoreCase(action)){
                vehicleDao.deleteVehicle(plate);
            }else if("Search".equalsIgnoreCase(action)){                
                vehicle = vehicleDao.getVehicle(plate);
                request.setAttribute("message", vehicle.getPlate());
                request.setAttribute("message1", vehicle.getBrand());
                request.setAttribute("message2", vehicle.getModel());
                request.setAttribute("message3", vehicle.getYear());
               
                request.getRequestDispatcher("/vehicleInformation.jsp").forward(request, response);
            }
            else if("SearchAll".equalsIgnoreCase(action)){
                lista=vehicleDao.getAllVehicle();
            }
                //Definicion de atributos para la carga de datos
                request.setAttribute("vehicle", vehicle);
                //llamo todos los objetos retornados para la tabla html
                request.setAttribute("allVehicles", vehicleDao.getAllVehicle());
                //Direcciono a index.jsp
              
                request.getRequestDispatcher("/vehicleInformation.jsp").forward(request, response);
        
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
