package views;

import users.LoggedUser;

public class MenuView {
    LoggedUser user = null;

    public MenuView(LoggedUser user){
        this.user = user;
    }


    @Override
    public String toString() {
        return 
        "<div class=\"menu-lateral\">"+
        "    <ul class=\"nav flex-column text-white\">"+
        "        <li class=\"nav-item\">"+
        "           <a class=\"nav-link text-white\" href=\"home.jsp\">Inicio</a>"+
        "        </li>"+
        "        <li class=\"nav-item\">"+
        "           <a class=\"nav-link text-white\" href=\"biblioteca.jsp\">Tu biblioteca</a>"+
        "        </li>"+
        "        <li class=\"nav-item\">"+
        "            <a class=\"nav-link text-white\" href=\"logout.jsp\">Cerrar sesión</a>"+
        "        </li>"+
        "    </ul>"+
        "</div>";
    }
    
}
