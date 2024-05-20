package Canciones;

public class Canciones {
    long codCancion;
    String artista;
    String cancion;


    public Canciones(long codCancion, String artista, String cancion){
        this.codCancion = codCancion;
        this.artista = artista;
        this.cancion = cancion;
    }

    public long getCodCancion(){
        return codCancion;
    }

    public void setCodCancion(long codCancion) {
        this.codCancion = codCancion;
    }
    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Artista: %s, Cancion: %s",this.codCancion, this.artista, this.cancion);
    }

}
