package org.kingxrp.external;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBase
{
    private final Connection connection;

    public DataBase
        (
        final String host,
        final int port,
        final String database,
        final String username,
        final String password
        )
    {

        try
        {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            connection = DriverManager.getConnection(url, username, password);
        }
        
        catch (SQLException error)
        {
            throw new RuntimeException("Error al establecer la conexión a la base de datos", error);
        }

    }

    public void disconnect()
    {
        try
        {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
            }
        }
        
        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    public Integer executeUpdate(final String sql)
    {
        try (final Statement statement = connection.createStatement())
        {
            return statement.executeUpdate(sql);
        }

        catch (SQLException error) 
        {
            System.err.println("Error al ejecutar la consulta: " + error.getMessage());
            return null;
        }

    }

    public ResultSet executeQuery(final String sql) 
    {
        try (final Statement statement = connection.createStatement())
        {
            return statement.executeQuery(sql);
        }

        catch (SQLException error)
        {
            System.err.println("Error al ejecutar la consulta: " + error.getMessage());
            return null;
        }
    }
}
