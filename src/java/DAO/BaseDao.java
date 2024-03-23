package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class BaseDao<T>{

    /**
     * execute query sql, return single result
     *
     * @param sql SQL
     * @param params parameters
     * @return single result
     * @throws SQLException SQLException
     */
    protected <R> R executeQuery(String sql, Function<T, R> function, Object... params) throws SQLException {
        T entity = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            setParameters(preparedStatement, params);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = mapRowToObject(resultSet);
                return function.apply(entity);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
        return null;
    }

    /**
     * execute query sql, return list
     *
     * @param sql SQL
     * @param params parameters
     * @return result list
     * @throws SQLException SQLException
     */
    protected <R> List<R> executeQueryForList(String sql, Function<List<T>, List<R>> function, Object... params) throws SQLException {
        List<T> entities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            setParameters(preparedStatement, params);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(mapRowToObject(resultSet));
            }
            return function.apply(entities);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    /**
     * execute update sql
     *
     * @param sql execute sql
     * @param params parameters
     * @return update count, if success, return rows, else return 0
     * @throws SQLException SQLException
     */
    protected int executeUpdate(String sql, Object... params) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement, params);
            return preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                releaseConnection(connection);
            }
        }
    }

    /**
     * abstract method to map row to object
     *
     * @param resultSet query result
     * @return entity
     * @throws SQLException SQLException
     */
    protected abstract T mapRowToObject(ResultSet resultSet) throws SQLException;

    /**
     * set parameters
     *
     * @param preparedStatement PreparedStatement
     * @param params parameters
     * @throws SQLException SQLException
     */
    private void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            if (params[i] == null) {
                preparedStatement.setNull(i + 1, Types.NULL);
            } else {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
    }

    /**
     * get database connection
     *
     * @return database connection
     * @throws SQLException SQLException
     */
    private Connection getConnection() throws SQLException {
        return DbConnectionPool.getInstance().getConnection();
    }

    /**
     * release database connection
     *
     * @param connection database connection
     * @throws SQLException SQLException
     */
    private void releaseConnection(Connection connection) throws SQLException{
        if (connection != null) {
            DbConnectionPool.getInstance().releaseConnection(connection);
        }
    }

}
