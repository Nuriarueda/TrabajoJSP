<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="Canciones.CancionesService"%>
<%
    String codCancion = request.getParameter("codCancion");
    String dbuser = "juan";
    String dbpassword = "12345678";
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/users", dbuser, dbpassword);
    CancionesService auth = new CancionesService(pool.getConnection());
    auth.delete(Long.parseLong(codCancion));
    response.sendRedirect("biblioteca.jsp");
%>