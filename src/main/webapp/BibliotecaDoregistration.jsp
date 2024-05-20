<%-- index.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="Canciones.CancionesService"%>
<%@page import="Canciones.Canciones"%>
<%
    String artista = request.getParameter("artista");
    String cancion = request.getParameter("cancion");
    //Usuario de la base de datos
    String dbuser = "juan";
    //Contraseña de la base de datos
    String dbpassword = "12345678";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/users", dbuser, dbpassword);
    CancionesService auth = new CancionesService(pool.getConnection());
    Canciones canciones = auth.create(artista, cancion);
    response.sendRedirect("biblioteca.jsp");
%> 