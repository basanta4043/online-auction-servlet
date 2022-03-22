package com.onlineauction.onlineauctionservlet.controller;

import com.onlineauction.onlineauctionservlet.model.beans.Category;
import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.User;
import com.onlineauction.onlineauctionservlet.model.service.ProductService;
import com.onlineauction.onlineauctionservlet.utility.ObjectFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@WebServlet("/addproduct")
public class AddProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddProductController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("user");
        if (userInSession == null) {
            request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
        } else {

            if (userInSession.getUserType() == 1) {
                ObjectFactory objectFactory = new ObjectFactory();
                ProductService productService = objectFactory.createProductServiceImplObj();
                List<Category> catList = productService.getCategoryList();
                request.setAttribute("categoryList", catList);
                for (Category category : catList) {
                    System.out.println(category);
                }
                request.getRequestDispatcher("/seller/addProduct.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/error/forbiddenAccessError.jsp").forward(request, response);
            }

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("user");

        if (userInSession == null) {
            request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
        } else {


            if (userInSession.getUserType() == 1) {
                String BASE_DIR = "/home/basanta/Downloads";
                String DEFAULT_FILENAME = "/website.jpg";
                boolean filePresent = false;
                String currentTime = Long.toString((int) (new Date().getTime() / 10000));
                HashMap<String, String> data = new HashMap<String, String>();

                if (ServletFileUpload.isMultipartContent(request)) {
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List<FileItem> formItems = null;
                    try {
                        formItems = upload.parseRequest(new ServletRequestContext(request));
                    } catch (FileUploadException e) {
                        e.printStackTrace();
                    }

                    if (formItems != null && formItems.size() > 0) {
                        for (FileItem item : formItems) {
                            if (!item.isFormField()) {
                                String fileName = new File(item.getName()).getName();
                                System.out.println("Filename :" + fileName);
                                fileName = fileName.replaceAll("\\s+", "");
                                fileName = currentTime + "-" + fileName;
                                String filePath = BASE_DIR + fileName;
                                File storeFile = new File(filePath);
                                try {
                                    item.write(storeFile);
                                    data.put("Image", fileName);
                                    System.out.println("File: " + fileName + " has uploaded successfully!");

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                filePresent = true;
                            } else {
                                String fieldName = item.getFieldName();
                                String fieldValue = item.getString();
                                System.out.println("" + fieldName + " : " + fieldValue);
                                data.put(fieldName, fieldValue);
                            }
                        }
                    }

                    if (!filePresent) {
                        data.put("Image", DEFAULT_FILENAME);
                    }
                }
                Product product = new Product(data.get("productName"), data.get("category"),
                        data.get("productDescription"), Double.parseDouble(data.get("actualPrice")),
                        Integer.parseInt(data.get("quantity")), data.get("Image"), userInSession.getUserid());
                System.out.println(product);
                ObjectFactory objectFactory = new ObjectFactory();
                ProductService productService = objectFactory.createProductServiceImplObj();
                int status = productService.addProducts(product);
                if (status > 0) {
                    System.out.println("Product Added");
                    response.setStatus(200);
                } else {
                    System.out.println("HTTP 501 Not Implemented: Product not added/");
                    response.setStatus(501);
                }
            } else {
                request.getRequestDispatcher("/error/forbiddenAccessError.jsp").forward(request, response);
            }
        }

    }

}