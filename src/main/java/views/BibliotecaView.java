package views;

import Canciones.Canciones;
import java.util.List;

public class BibliotecaView {
    private List<Canciones> cancionesList;

    public BibliotecaView(List<Canciones> cancionesList) {
        this.cancionesList = cancionesList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table class='table'>");
        sb.append("<thead>");
        sb.append("<tr>");
        sb.append("<th scope='col' style='color: white;'>Artista</th>");
        sb.append("<th scope='col' style='color: white;'>Canción</th>");
        sb.append("<th scope='col' style='color: white;'>Acciones</th>");
        sb.append("</tr>");
        sb.append("</thead>");
        sb.append("<tbody>");
        for (Canciones cancion : cancionesList) {
            sb.append("<tr>");
            sb.append("<td style='color: white;'>").append(cancion.getArtista()).append("</td>");
            sb.append("<td style='color: white;'>").append(cancion.getCancion()).append("</td>");
            sb.append("<td>");
            sb.append("<form action='EditarCancion.jsp' method='GET' style='display:inline;'>");
            sb.append("<input type='hidden' name='codCancion' value='").append(cancion.getCodCancion()).append("'/>");
            sb.append("<button type='submit' class='btn btn-outline-success'>Editar</button>");
            sb.append("</form>");
            sb.append(" ");
            sb.append("<form action='BorrarCancion.jsp' method='POST' style='display:inline;' onsubmit='return confirm(\"¿Estás seguro de que deseas borrar esta canción?\");'>");
            sb.append("<input type='hidden' name='codCancion' value='").append(cancion.getCodCancion()).append("'/>");
            sb.append("<button type='submit' class='btn btn-outline-danger'>Borrar</button>");
            sb.append("</form>");
            sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("</tbody>");
        sb.append("</table>");
        return sb.toString();
    }
}