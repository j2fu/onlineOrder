package com.laioffer.onlineOrder;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.json.JSONObject;

import org.apache.commons.io.IOUtils;
import com.laioffer.onlineOrder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;




@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");


        // Hello
//        JSONObject customer = new JSONObject();
//        customer.put("email", "j2fu777@gmail.com");
//        customer.put("first_name", "Jarvin");
//        customer.put("last_name", "Fu");
//        customer.put("age", 21);
//        response.getWriter().print(customer);
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer= new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));


    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // Read customer information from request body
//        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
//        String email = jsonRequest.getString("email");
//        String firstName = jsonRequest.getString("first_name");
//        String lastName = jsonRequest.getString("last_name");
//        int age = jsonRequest.getInt("age");
//        // Print customer information to IDE console
//        System.out.println("Email is: " + email);
//        System.out.println("First name is: " + firstName);
//        System.out.println("Last name is: " + lastName);
//        System.out.println("Age is: " + age);
//        // Return status = ok as response body to the client
//        response.setContentType("application/json");
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("status", "ok");
//        response.getWriter().print(jsonResponse);
//    }
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException
{
    ObjectMapper mapper = new ObjectMapper();
    Customer customer = mapper.readValue(IOUtils.toString(req.getReader()), Customer.class);
    System.out.println(customer.getEmail());
    System.out.println(customer.getFirstName());
    System.out.println(customer.getLastName());

    JSONObject jsonResponse = new JSONObject();
    jsonResponse.put("status", "ok");
    resp.getWriter().print(jsonResponse);
}


    public void destroy() {
    }
}