<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="views.BibliotecaView"%>
<%@page import="Canciones.CancionesService"%>
<%@page import="Canciones.Canciones"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="java.util.List"%>
<%
    // Usuario de la base de datos
    String dbuser = "juan";
    // Contraseña de la base de datos
    String dbpassword = "12345678";
    // Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/users", dbuser, dbpassword);
    CancionesService auth = new CancionesService(pool.getConnection());
    List<Canciones> cancionesList = auth.requestAll(); // Obtén la lista de canciones desde el servicio
    BibliotecaView bibliotecaView = new BibliotecaView(cancionesList); // Define bibliotecaView en el ámbito del JSP
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tu Biblioteca</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
                <div class="menu-lateral">
                    <ul class="nav flex-column text-white">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="home.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="biblioteca.jsp">Tu biblioteca</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="logout.jsp">Cerrar sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-white">Tu Biblioteca</h1>
                    <h2 class="text-white">Agregar Nuevas Listas</h2>
                    <form action="BibliotecaDoregistration.jsp" method="POST">
                        <input type="hidden" name="action" value="crear">
                        <div class="form-group">
                            <label for="artista" class="text-white">Artista</label>
                            <input type="text" class="form-control" id="artista" name="artista" required>
                        </div>
                        <div class="form-group">
                            <label for="cancion" class="text-white">Canción</label>
                            <input type="text" class="form-control" id="cancion" name="cancion" required>
                        </div>
                        <button type="submit" class="btn btn-success">Agregar</button>
                    </form>
                </div>
            </div>
            <div class="row w-auto h-auto p-4">
                <h2 style="color: white;">Tu Lista</h2>
                <div class="table-responsive" style="height: calc(50vh - 100px);">
                    <%= bibliotecaView.toString() %>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JavaScript y dependencias -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>