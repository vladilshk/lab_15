<%@ page import="com.example.lab_15_last_lat.Products" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 align="center">Market place</h1>

<%
    String link;
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("login") != null)
        link = "<a href=\"LogoutServlet\">Logout</a>\n" +
                "<a href=\"AddProduct.jsp\">AddProduct</a>"
                ;
    else{
        link = "<a href=\"loginPage.html\">Login</a>\n";
    }
%>

<%=link%>

<%
   /* HttpSession session1 = request.getSession();
    String message = "";
    if (session1.getAttribute("login") != null){
        message = "I works!!!";
    }
    else {
        message = "sosi bibu((((";
    }*/

    Products products = new Products();

    String data = products.getBooksForPrint();

%>

<%= data%>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>