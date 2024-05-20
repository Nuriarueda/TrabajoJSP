package Canciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import crud.CRUD;

public class CancionesService implements CRUD<Canciones> {
    private Connection conn;

    public CancionesService(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<Canciones> requestAll() throws SQLException {
        Statement statement = null;
        ArrayList<Canciones> result = new ArrayList<>();
        statement = this.conn.createStatement();
        String sql = "SELECT codCancion, artista, cancion FROM canciones_users";
        ResultSet querySet = statement.executeQuery(sql);
        while(querySet.next()) {
            long codCancion = querySet.getLong("codCancion");
            String artista = querySet.getString("artista");
            String cancion = querySet.getString("cancion");

            result.add(new Canciones(codCancion, artista, cancion));
        }
        statement.close();
        return result;
    }

    @Override
    public Canciones requestById(long codCancion) throws SQLException { // Implementación completa del método requestById
        Statement statement = null;
        Canciones result = null;
        statement = this.conn.createStatement();
        String sql = String.format("SELECT codCancion, artista, cancion FROM canciones_users WHERE codCancion=%d", codCancion);
        ResultSet querySet = statement.executeQuery(sql);
        if(querySet.next()) {
            String artista = querySet.getString("artista");
            String cancion = querySet.getString("cancion");

            result = new Canciones(codCancion, artista, cancion);
        }
        statement.close();
        return result;
    }

    @Override
    public Canciones create(Canciones model) throws SQLException {
        return create(model.getArtista(), model.getCancion());
    }

    public Canciones create(String artista, String cancion) throws SQLException {
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = String.format("INSERT INTO canciones_users (artista, cancion) VALUES ('%s', '%s')", artista, cancion);
        int affectedRows = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        if (affectedRows == 0) {
            throw new SQLException("Creating song failed, no rows affected.");
        }
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long codCancion = generatedKeys.getLong(1);
                Canciones newCancion = new Canciones(codCancion, artista, cancion);
                statement.close();
                return newCancion;
            } else {
                statement.close();
                throw new SQLException("Creating song failed, no ID obtained.");
            }
        }
    }

    @Override
    public int update(Canciones object) throws SQLException {
        long codCancion = object.getCodCancion();
        String artista = object.getArtista();
        String cancion = object.getCancion();
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = String.format("UPDATE canciones_users SET artista = '%s', cancion = '%s' WHERE codCancion=%d", artista, cancion, codCancion);
        int affectedRows = statement.executeUpdate(sql);
        statement.close();
        if (affectedRows == 0) {
            throw new SQLException("Updating song failed, no rows affected.");
        } else {
            return affectedRows;
        }
    }

    
    @Override
    public boolean delete(long codCancion) throws SQLException {
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = String.format("DELETE FROM canciones_users WHERE codCancion=%d", codCancion);
        int result = statement.executeUpdate(sql);
        statement.close();
        return result == 1;
    }

    @Override
    public ArrayList<Canciones> query(String column, String value) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Canciones> query(String column, long value) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Canciones> requestAll(String sortedBy) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'requestAll'");
    }
}