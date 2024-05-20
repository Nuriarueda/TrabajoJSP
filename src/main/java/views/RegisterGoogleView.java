package views;

public class RegisterGoogleView {

    String error = null;
    public RegisterGoogleView(){
    }

    public RegisterGoogleView(String error){
        this.error = error;
    }


    @Override
    public String toString() {
        return
        "<div class=\"container\">" +
        "<div class=\"row\">" +
        "    <div class=\"col-md-6 offset-md-3\">"+
        "        <div class=\"login-form bg-dark mt-4 p-4\">"+
        "               <div class=\"center p-3\">"+
        "                   <h4><b>Registrate con Google</b></h4>"+
        "               </div>"+
        "            <form action=\"doregistration.jsp\" method=\"POST\" class=\"row g-3\">"+
        "                <div class=\"col-12 pb-3\">"+
        "                    <label><b>Nombre</b></label>"+
        "                    <input type=\"text\" name=\"name\" class=\"form-control\" placeholder=\"Nombre\">"+
        "                </div>"+
        "                <div class=\"col-12 pb-3\">"+
        "                    <label><b>Apellidos</b></label>"+
        "                    <input type=\"text\" name=\"surname\" class=\"form-control\" placeholder=\"Apellidos\">"+
        "                </div>"+
        "                <div class=\"col-12 pb-3\">"+
        "                    <label><b>Usuario</b></label>"+
        "                    <input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"Usuario\">"+
        "                </div>"+
        "                <div class=\"col-12 pb-3\">"+
        "                    <label><b>Contraseña</b></label>"+
        "                    <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Contraseña\">"+
        "                </div>"+
        ((error!=null)?"                <h4 class=\"col-12 error\">"+error+"</h4>":"")+
        "                <div class=\"col-12\">" +
        "                    <button type=\"submit\" class=\"btn btn-success\">Registrarme</button>" +
        "                </div>"+
        "            </form>"+
        "            <hr class=\"mt-4\">"+
        "            <div class=\"col-12\">"+
        "                <p class=\"text-center mb-0\">¿Ya tienes una cuenta? <a href=\"index.jsp\" style=\"color: green;\">Inica sesión aquí</a></p>"+
        "            </div>"+
        "        </div>"+
        "    </div>"+
        "</div>";
    }
}
