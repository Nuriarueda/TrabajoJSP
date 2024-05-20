<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="Canciones.CancionesService"%>
<%@page import="Canciones.Canciones"%>
<%@page import="java.sql.SQLException"%>
<%
    // Obtener parámetros y credenciales
    String codCancion = request.getParameter("codCancion");
    String dbuser = "juan";
    String dbpassword = "12345678";
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/users", dbuser, dbpassword);
    CancionesService auth = new CancionesService(pool.getConnection());

    // Declarar variables para el formulario
    String artista = "";
    String cancion = "";

    // Si el método de la solicitud es POST, actualizar la canción
    if (request.getMethod().equalsIgnoreCase("POST")) {
        artista = request.getParameter("artista");
        cancion = request.getParameter("cancion");
        Canciones newLista = new Canciones(Long.parseLong(codCancion), artista, cancion);

        if (auth.update(newLista) == 1) {
            session.setAttribute("cancion", newLista);
            response.sendRedirect("biblioteca.jsp");
            return;
        } else {
            response.sendRedirect("biblioteca.jsp?error=No ha sido posible cambiar la información");
            return;
        }
    } else { // Si el método de la solicitud es GET, mostrar el formulario con los datos actuales
        Canciones cancionObj = auth.requestById(Long.parseLong(codCancion));
        artista = cancionObj.getArtista();
        cancion = cancionObj.getCancion();
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Canción</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="text-white">Editar Canción</h1>
        <form action="EditarCancion.jsp" method="POST">
            <input type="hidden" name="codCancion" value="<%= codCancion %>">
            <div class="form-group">
                <label for="artista" class="text-white">Artista</label>
                <input type="text" class="form-control" id="artista" name="artista" value="<%= artista %>" required>
            </div>
            <div class="form-group">
                <label for="cancion" class="text-white">Canción</label>
                <input type="text" class="form-control" id="cancion" name="cancion" value="<%= cancion %>" required>
            </div>
            <button type="submit" class="btn btn-outline-light">Guardar Cambios</button>
        </form>
    </div>

    <!-- Bootstrap JavaScript y dependencias -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>