// 실제 커넥션 객체를 대행하는 역할을 수행한다.
package step25.ex04;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

// proxy를 만든 이유?
// => close()를 호출할 때 DB 연결을 끊는 대신,
//    DataSource에 커넥션을 반납하기 위해!
public class ConnectionProxy implements Connection {
    DataSource dataSource;
    Connection con;
    
    public ConnectionProxy(DataSource dataSource, Connection con) {
        this.dataSource = dataSource;
        this.con = con;
    }

    public void abort(Executor executor) throws SQLException {
        con.abort(executor);
    }

    public void clearWarnings() throws SQLException {
        con.clearWarnings();
    }

    public void close() throws SQLException {
        dataSource.returnConnection(this); // 프록시 패턴 적용 // close()를 하면 자기 자신을 반납
    }

    public void commit() throws SQLException {
        con.commit();
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return con.createArrayOf(typeName, elements);
    }

    public Blob createBlob() throws SQLException {
        return con.createBlob();
    }

    public Clob createClob() throws SQLException {
        return con.createClob();
    }

    public NClob createNClob() throws SQLException {
        return con.createNClob();
    }

    public SQLXML createSQLXML() throws SQLException {
        return con.createSQLXML();
    }

    public Statement createStatement() throws SQLException {
        return con.createStatement();
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws SQLException {
        return con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return con.createStatement(resultSetType, resultSetConcurrency);
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return con.createStruct(typeName, attributes);
    }

    public boolean getAutoCommit() throws SQLException {
        return con.getAutoCommit();
    }

    public String getCatalog() throws SQLException {
        return con.getCatalog();
    }

    public Properties getClientInfo() throws SQLException {
        return con.getClientInfo();
    }

    public String getClientInfo(String name) throws SQLException {
        return con.getClientInfo(name);
    }

    public int getHoldability() throws SQLException {
        return con.getHoldability();
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        return con.getMetaData();
    }

    public int getNetworkTimeout() throws SQLException {
        return con.getNetworkTimeout();
    }

    public String getSchema() throws SQLException {
        return con.getSchema();
    }

    public int getTransactionIsolation() throws SQLException {
        return con.getTransactionIsolation();
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return con.getTypeMap();
    }

    public SQLWarning getWarnings() throws SQLException {
        return con.getWarnings();
    }

    public boolean isClosed() throws SQLException {
        return con.isClosed();
    }

    public boolean isReadOnly() throws SQLException {
        return con.isReadOnly();
    }

    public boolean isValid(int timeout) throws SQLException {
        return con.isValid(timeout);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return con.isWrapperFor(iface);
    }

    public String nativeSQL(String sql) throws SQLException {
        return con.nativeSQL(sql);
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException {
        return con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return con.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    public CallableStatement prepareCall(String sql) throws SQLException {
        return con.prepareCall(sql);
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException {
        return con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
            throws SQLException {
        return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return con.prepareStatement(sql, autoGeneratedKeys);
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return con.prepareStatement(sql, columnIndexes);
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return con.prepareStatement(sql, columnNames);
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return con.prepareStatement(sql);
    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        con.releaseSavepoint(savepoint);
    }

    public void rollback() throws SQLException {
        con.rollback();
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        con.rollback(savepoint);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        con.setAutoCommit(autoCommit);
    }

    public void setCatalog(String catalog) throws SQLException {
        con.setCatalog(catalog);
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        con.setClientInfo(properties);
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        con.setClientInfo(name, value);
    }

    public void setHoldability(int holdability) throws SQLException {
        con.setHoldability(holdability);
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        con.setNetworkTimeout(executor, milliseconds);
    }

    public void setReadOnly(boolean readOnly) throws SQLException {
        con.setReadOnly(readOnly);
    }

    public Savepoint setSavepoint() throws SQLException {
        return con.setSavepoint();
    }

    public Savepoint setSavepoint(String name) throws SQLException {
        return con.setSavepoint(name);
    }

    public void setSchema(String schema) throws SQLException {
        con.setSchema(schema);
    }

    public void setTransactionIsolation(int level) throws SQLException {
        con.setTransactionIsolation(level);
    }

    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        con.setTypeMap(map);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return con.unwrap(iface);
    }
    
    
    
}
