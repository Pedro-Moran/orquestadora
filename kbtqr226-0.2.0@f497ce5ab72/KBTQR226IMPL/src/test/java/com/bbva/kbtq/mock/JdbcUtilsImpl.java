package com.bbva.kbtq.mock;

import com.bbva.elara.domain.jdbc.CommonJdbcTemplate;
import com.bbva.elara.domain.transaction.ParameterTable;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.support.jdbc.manager.JdbcManager;
import com.bbva.elara.utility.jdbc.connector.JdbcUtils;
import com.bbva.elara.utility.jdbc.connector.impl.QueryExecutorLogger;
import com.bbva.elara.utils.control.UtilsControl;
import org.apache.commons.io.FileUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class JdbcUtilsImpl implements JdbcUtils, UtilsControl {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.bbva.elara.utility.jdbc.connector.impl.JdbcUtilsImpl.class);
    private static final String DEFAULT_CHARSET = "UTF-8";
    private int maxRows;
    private String warningCodeMoreRows;
    private JdbcManager jdbcManager;
    private String uuaa;
    private BundleContext bundleContext;
    private Map<String, String> sqls;

    public JdbcUtilsImpl() {
    }

    public JdbcUtilsImpl(BundleContext bundleContext, String warningCodeMoreRows, int maxRows, JdbcManager jdbcManager) throws IOException {
        this.sqls = new ConcurrentHashMap();
        this.maxRows = maxRows;
        this.warningCodeMoreRows = warningCodeMoreRows;
        this.bundleContext = bundleContext;
        this.jdbcManager = jdbcManager;
        this.uuaa = bundleContext.getBundle().getSymbolicName().substring(0, 4).toLowerCase();
        this.getSqFromFile();
        LOGGER.info("JdbcConnector created for uuaa: " + this.uuaa);
    }

    public int[] batchUpdate(String queryCode, List<Object[]> batchArgs) {
        LOGGER.info("batch Update with query code: " + queryCode);
        String sql = this.parseQuery(queryCode);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).batchUpdate(sql, batchArgs);
    }

    public int[] batchUpdate(String queryCode, List<Object[]> batchArgs, int[] argTypes) {
        LOGGER.info("batch Update with query code: " + queryCode);
        String sql = this.parseQuery(queryCode);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).batchUpdate(sql, batchArgs, argTypes);
    }

    public int queryForInt(String queryCode, Map<String, ?> args) {
        LOGGER.info("Query for int with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForInt(sql, args);
    }

    public int queryForInt(String queryCode, Object... args) {
        LOGGER.info("Query for int with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        CommonJdbcTemplate template = this.getCommonJdbcTemplateFromQueryCode(queryCode);
        Integer res = template.queryForInt(sql, args);
        return res;
    }

    public List<Map<String, Object>> queryForList(String queryCode, Object... args) {
        LOGGER.info("Query for list with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        List<Map<String, Object>> result = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, args);
        if (this.checkIfMoreElements(result, queryCode)) {
            result = result.subList(0, this.maxRows);
        }

        return result;
    }

    public List<Map<String, Object>> pagingQueryForList(String queryCode, int firstRow, int pageSize, Object... args) {
        LOGGER.info("Paging query for list with query code: " + queryCode + " ,first row: " + firstRow + " and page size: " + pageSize);
        Object[] argsTemp = this.addPaginationArray(args, firstRow, pageSize);
        String sql = this.parseQueryWithPagination(queryCode, argsTemp, false);
        List<Map<String, Object>> result = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, argsTemp);
        if (this.checkIfMoreElements(result, queryCode)) {
            result = result.subList(0, pageSize);
        }

        return result;
    }

    public List<Map<String, Object>> queryForList(String queryCode) {
        LOGGER.info("Query for list with query code: " + queryCode);
        String sql = this.parseQuery(queryCode);
        List<Map<String, Object>> result = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, new Object[0]);
        if (this.checkIfMoreElements(result, queryCode)) {
            result = result.subList(0, this.maxRows);
        }

        return result;
    }

    public List<Map<String, Object>> pagingQueryForList(String queryCode, int firstRow, int pageSize) {
        LOGGER.info("Paging query for list with query code: " + queryCode + " ,first row: " + firstRow + " and page size: " + pageSize);
        Map<String, Object> argsTemp = this.addPaginationMap(new HashMap(), firstRow, pageSize);
        String sql = this.parseQueryWithPagination(queryCode, argsTemp, true);
        List<Map<String, Object>> result = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, argsTemp);
        if (this.checkIfMoreElements(result, queryCode)) {
            result = result.subList(0, pageSize);
        }

        return result;
    }

    public List<Map<String, Object>> queryForList(String queryCode, Map<String, ?> args) {
        LOGGER.info("Query for list with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        List<Map<String, Object>> result = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, args);
        if (this.checkIfMoreElements(result, queryCode)) {
            result = result.subList(0, this.maxRows);
        }

        return result;
    }

    public List<Map<String, Object>> pagingQueryForList(String queryCode, int firstRow, int pageSize, Map<String, ?> args) {
        LOGGER.info("Paging query for list with query code: " + queryCode + " ,first row: " + firstRow + " and page size: " + pageSize);
        Map<String, Object> argsTemp = this.addPaginationMap(args, firstRow, pageSize);
        String sql = this.parseQueryWithPagination(queryCode, argsTemp, true);
        List<Map<String, Object>> result = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, argsTemp);
        if (this.checkIfMoreElements(result, queryCode)) {
            result = result.subList(0, pageSize);
        }

        return result;
    }

    public ParameterTable queryForTable(String queryCode, Map<String, ?> args) {
        LOGGER.info("Query for table with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        List<Map<String, Object>> list = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, args);
        return this.assingDataTable(list, queryCode, this.maxRows);
    }

    public ParameterTable pagingQueryForTable(String queryCode, int firstRow, int pageSize, Map<String, ?> args) {
        LOGGER.info("Paging query for table with query code: " + queryCode + " ,first row: " + firstRow + " and page size: " + pageSize);
        Map<String, Object> argsTemp = this.addPaginationMap(args, firstRow, pageSize);
        String sql = this.parseQueryWithPagination(queryCode, argsTemp, true);
        List<Map<String, Object>> list = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, argsTemp);
        return this.assingDataTable(list, queryCode, pageSize);
    }

    public ParameterTable queryForTable(String queryCode, Object... args) {
        LOGGER.info("Query for table with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        List<Map<String, Object>> list = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, args);
        return this.assingDataTable(list, queryCode, this.maxRows);
    }

    public ParameterTable pagingQueryForTable(String queryCode, int firstRow, int pageSize, Object... args) {
        LOGGER.info("Paging query for table with query code: " + queryCode + " ,first row: " + firstRow + " and page size: " + pageSize);
        Object[] argsTemp = this.addPaginationArray(args, firstRow, pageSize);
        String sql = this.parseQueryWithPagination(queryCode, argsTemp, false);
        List<Map<String, Object>> list = this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForList(sql, argsTemp);
        return this.assingDataTable(list, queryCode, pageSize);
    }

    public String queryForString(String queryCode, Map<String, ?> args) {
        LOGGER.info("Query for string with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return (String) this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForObject(sql, String.class, args);
    }

    public String queryForString(String queryCode, Object... args) {
        LOGGER.info("Query for string with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return (String) this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForObject(sql, String.class, args);
    }

    public long queryForLong(String queryCode, Map<String, ?> args) {
        LOGGER.info("Query for long with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForLong(sql, args);
    }

    public long queryForLong(String queryCode, Object... args) {
        LOGGER.info("Query for long with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForLong(sql, args);
    }

    public Map<String, Object> queryForMap(String queryCode, Map<String, ?> args) {
        LOGGER.info("Query for map with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForMap(sql, args);
    }

    public Map<String, Object> pagingQueryForMap(String queryCode, int firstRow, int pageSize, Map<String, ?> args) {
        LOGGER.info("Paging query for map with query code: " + queryCode + " ,first row: " + firstRow + " and page size: " + pageSize);
        Map<String, Object> argsTemp = this.addPaginationMap(args, firstRow, pageSize);
        String sql = this.parseQueryWithPagination(queryCode, argsTemp, true);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForMap(sql, argsTemp);
    }

    public Map<String, Object> queryForMap(String queryCode, Object... args) {
        LOGGER.info("Query for map with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForMap(sql, args);
    }

    public Map<String, Object> pagingQueryForMap(String queryCode, int firstRow, int pageSize, Object... args) {
        LOGGER.info("Paging query for map with query code: " + queryCode + " ,first row: " + firstRow + " and page size: " + pageSize);
        Object[] argsTemp = this.addPaginationArray(args, firstRow, pageSize);
        String sql = this.parseQueryWithPagination(queryCode, argsTemp, false);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).queryForMap(sql, argsTemp);
    }

    private boolean checkIfMoreElements(List<?> result, String queryCode) {
        Boolean bRetorno = Boolean.FALSE;
        if (result.size() > this.maxRows) {
            LOGGER.warn(this.warningCodeMoreRows, queryCode);
            bRetorno = Boolean.TRUE;
        }

        return bRetorno;
    }

    public int[] batchUpdate(String queryCode, Map<String, ?>[] batchValues) {
        LOGGER.info("batch Update with query code: " + queryCode);
        String sql = this.parseQuery(queryCode);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).batchUpdate(sql, batchValues);
    }

    public int update(String queryCode, Map<String, ?> args) {
        LOGGER.info("Updating DB with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).update(sql, args);
    }

    public int update(String queryCode, Object... args) {
        LOGGER.info("Updating DB with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        return this.getCommonJdbcTemplateFromQueryCode(queryCode).update(sql, args);
    }

    private String parseQuery(String code) {
        LOGGER.info("Getting query: " + code);
        String sql = null;
        String queryLine = this.getSqlLine(code);
        String[] queryLineProperties = queryLine.split(";");
        sql = queryLineProperties[1];
        sql = paginationOverride(sql);
        QueryExecutorLogger.traceQuerySQL(code, sql);

        LOGGER.info("Getted query: " + code + " ,with SQL: " + sql);
        return sql;
    }

    private String transformQuery(String originalQuery) {
        // Extract the part of the WHERE clause
        String whereClause = originalQuery.substring(originalQuery.indexOf("WHERE"));

        // Create the subquery with COUNT(*)
        String subquery = "(SELECT COUNT(*) " + whereClause + ") as TOTAL";

        // Replace SELECT COUNT(1) OVER() as TOTAL with the subquery
        return originalQuery.replace("SELECT COUNT(1) OVER() as TOTAL", "SELECT " + subquery);
    }

    private String paginationOverride(String sql) {
        sql = transformQuery(sql);
        if (sql.contains("OFFSET :firstRow ROWS FETCH NEXT :pageSize ROWS ONLY")) {
            sql = sql.replace("OFFSET :firstRow ROWS FETCH NEXT :pageSize ROWS ONLY", ")A where ROWNUM >= :desde and ROWNUM < :hasta");
            sql = "select A.* from (" + sql;
        } else if (sql.contains("FETCH FIRST :ROWS_LIMIT ROWS ONLY")) {
            sql = sql.replace("FETCH FIRST :ROWS_LIMIT ROWS ONLY", "limit :ROWS_LIMIT");
            sql = sql.replace("COUNT(1) OVER() OWN_COUNT", "cast(1 as NUMERIC) OWN_COUNT");
        } else if (sql.contains("regexp_like(GF_CUSTOMER_CONSENT_ID, '^[[:digit:]]+$')")) {
            sql = sql.replace("regexp_like(GF_CUSTOMER_CONSENT_ID, '^[[:digit:]]+$')", "1=1");
        }
        return sql;
    }

    private String parseQuery(String code, Object[] args) {
        LOGGER.info("Getting query: " + code);
        String sql = this.parseQuery(code);
        sql = paginationOverride(sql);
        QueryExecutorLogger.traceQuery(code, args);
        LOGGER.info("Getted query: " + code + " ,with SQL: " + sql);
        return sql;
    }

    private String parseQueryWithPagination(String code, Object[] args, boolean isNamedParam) {
        LOGGER.info("Getting query: " + code);
        String sql = this.insertPagination(this.parseQuery(code), isNamedParam);
        QueryExecutorLogger.traceQuery(code, args);
        LOGGER.info("Getted query: " + code + " ,with SQL: " + sql);
        return sql;
    }

    private String parseQuery(String code, Map<String, ?> args) {
        LOGGER.info("Getting query: " + code);
        String sql = this.parseQuery(code);
        sql = paginationOverride(sql);
        QueryExecutorLogger.traceQuery(code, args);
        LOGGER.info("Getted query: " + code + " ,with SQL: " + sql);
        return sql;
    }

    private String parseQueryWithPagination(String code, Map<String, ?> args, boolean isNamedParam) {
        LOGGER.info("Getting query: " + code);
        String sql = this.insertPagination(this.parseQuery(code), isNamedParam);
        sql = paginationOverride(sql);
        overrideParams(args);
        QueryExecutorLogger.traceQuery(code, args);
        LOGGER.info("Getted query: " + code + " ,with SQL: " + sql);
        return sql;
    }

    private void overrideParams(Map<String, ?> args) {
        Map<String, Object> mapTemp = (Map<String, Object>) args;
        int first = (Integer) args.get("firstRow");
        int pageSize = (Integer) args.get("pageSize");
        if (1 > first) {
            first = 1;
        }
        if (1 >= pageSize) {
            pageSize = 50;
        }
        if (pageSize < first) {
            pageSize = first + pageSize;
        }

        mapTemp.put("desde", (Object) first);
        mapTemp.put("hasta", (Object) pageSize);
        args = mapTemp;
    }

    private String insertPagination(String parseQuery, boolean isNamedParam) {
        StringBuilder builder = new StringBuilder();
        builder.append(parseQuery);
        builder.append(" OFFSET ").append(isNamedParam ? ":firstRow" : "?");
        builder.append(" ROWS FETCH NEXT ").append(isNamedParam ? ":pageSize" : "?").append(" ROWS ONLY");
        return builder.toString();
    }

    private Object[] addPaginationArray(Object[] obj, int firstRow, int pageSize) {
        ArrayList<Object> temp = new ArrayList(Arrays.asList(obj));
        temp.add(firstRow - 1);
        temp.add(pageSize);
        return temp.toArray();
    }

    private Map<String, Object> addPaginationMap(Map<String, ?> map, int firstRow, int pageSize) {
        Map<String, Object> mapTemp = null;
        if (map != null) {
            mapTemp = (Map<String, Object>) map;
            mapTemp.put("firstRow", (Integer) firstRow - 1);
            mapTemp.put("pageSize", (Object) pageSize);
        }

        return mapTemp;
    }

    public int updateLob(String queryCode, Map<String, ?> args) {
        LOGGER.info("Updating DB with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        Map<String, Object> argsFinal = new HashMap();
        Iterator var5 = args.entrySet().iterator();

        while (var5.hasNext()) {
            Map.Entry<String, ?> entry = (Map.Entry) var5.next();
            if (entry.getValue() instanceof File) {
                try {
                    if (isAsciiText((File) entry.getValue())) {
                        argsFinal.put(entry.getKey(), FileUtils.readFileToString((File) entry.getValue(), "UTF-8"));
                    } else {
                        argsFinal.put(entry.getKey(), FileUtils.readFileToByteArray((File) entry.getValue()));
                    }
                } catch (IOException var8) {
                    LOGGER.error("Error to convert file");
                }
            } else {
                argsFinal.put(entry.getKey(), entry.getValue());
            }
        }

        return this.getCommonJdbcTemplateFromQueryCode(queryCode).update(sql, argsFinal);
    }

    public int updateLob(String queryCode, Object... args) {
        LOGGER.info("Updating DB with query code: " + queryCode);
        String sql = this.parseQuery(queryCode, args);
        List<Object> argsFinal = new ArrayList();
        Object[] var5 = args;
        int var6 = args.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            Object object = var5[var7];

            try {
                if (object instanceof File) {
                    if (isAsciiText((File) object)) {
                        argsFinal.add(FileUtils.readFileToString((File) object, "UTF-8"));
                    } else {
                        argsFinal.add(FileUtils.readFileToByteArray((File) object));
                    }
                } else {
                    argsFinal.add(object);
                }
            } catch (IOException var10) {
                LOGGER.error("Error to convert file");
            }
        }

        return this.getCommonJdbcTemplateFromQueryCode(queryCode).update(sql, argsFinal.toArray());
    }

    private static boolean isAsciiText(File fileName) throws IOException {
        byte[] bytes = new byte[500];
        boolean result = true;
        InputStream inp = new FileInputStream(fileName);
        Throwable var4 = null;

        try {
            inp.read(bytes, 0, bytes.length);
            inp.close();
            short bin = 0;
            byte[] var6 = bytes;
            int var7 = bytes.length;

            for (int var8 = 0; var8 < var7; ++var8) {
                byte thisByte = var6[var8];
                char charValue = (char) thisByte;
                if (!Character.isWhitespace(charValue) && Character.isISOControl(charValue)) {
                    ++bin;
                }

                if (bin >= 5) {
                    result = false;
                }
            }
        } catch (Throwable var18) {
            var4 = var18;
            throw var18;
        } finally {
            if (inp != null) {
                if (var4 != null) {
                    try {
                        inp.close();
                    } catch (Throwable var17) {
                        var4.addSuppressed(var17);
                    }
                } else {
                    inp.close();
                }
            }

        }

        return result;
    }

    private String parseDB(String queryLine) {
        return queryLine.split(";")[0];
    }

    private CommonJdbcTemplate getCommonJdbcTemplateFromQueryCode(String queryCode) {
        String queryLine = this.getSqlLine(queryCode);
        String dbResource = this.parseDB(queryLine);
        return this.jdbcManager.getJdbcConnection(this.uuaa, dbResource);
    }

    private void getSqFromFile() throws IOException {
        Bundle bundle = this.bundleContext.getBundle();
        String bundleName = (String) bundle.getHeaders().get("Bundle-Name");
        LOGGER.debug("Finding SQL file for bundle name {}", bundleName);
        Enumeration<URL> urlEnumeration = bundle.findEntries("/", "sql-" + bundleName + ".properties", true);
        if (urlEnumeration == null) {
            LOGGER.info("The SQL file is missing for bundle name {}", bundleName);
            urlEnumeration = bundle.findEntries("/", "sql-" + bundleName + "*.properties", true);
            if (urlEnumeration == null) {
                LOGGER.error("The SQL file is missing for {}", bundleName);
            } else {
                this.fillSqls(urlEnumeration, bundleName);
            }
        } else {
            this.fillSqls(urlEnumeration, bundleName);
        }

    }

    private void fillSqls(Enumeration<URL> urlEnumeration, String bundleName) throws IOException {
        InputStream sqlProperty = null;

        try {
            Properties configFile = new Properties();

            while (urlEnumeration.hasMoreElements()) {
                URL sqlURL = (URL) urlEnumeration.nextElement();
                if (sqlURL != null) {
                    LOGGER.debug("reading sql File {}", sqlURL);
                    if (sqlProperty != null) {
                        sqlProperty.close();
                    }

                    sqlProperty = sqlURL.openStream();
                }
            }

            if (sqlProperty != null) {
                Reader reader = new InputStreamReader(sqlProperty);
                configFile.load(reader);
                Iterator var6 = configFile.entrySet().iterator();

                while (var6.hasNext()) {
                    Map.Entry<Object, Object> entry = (Map.Entry) var6.next();
                    this.sqls.put((String) entry.getKey(), (String) entry.getValue());
                }
            } else {
                LOGGER.error("The SQL file is missing for bundle {}", bundleName);
            }
        } finally {
            if (sqlProperty != null) {
                sqlProperty.close();
            }

        }

    }

    private String getSqlLine(String queryCode) {
        String sql = (String) ThreadContext.get().getDynamicSqls().get(queryCode);
        return sql == null ? (String) this.sqls.get(queryCode) : sql;
    }

    private ParameterTable assingDataTable(List<Map<String, Object>> list, String queryCode, int rowSize) {
        ParameterTable table = new ParameterTable();
        if (!list.isEmpty()) {
            if (this.checkIfMoreElements(list, queryCode)) {
                list = list.subList(0, rowSize);
            }

            table.setParameterTableList(list);
        }

        return table;
    }

    public String getQuery(String code) {
        return this.parseQuery(code);
    }

    public void addQuery(String code, String sqlLine) {
        LOGGER.info("Adding query: " + code + " ,with resource+SQL: " + sqlLine);
        String componentName = this.bundleContext.getBundle().getSymbolicName().toLowerCase();
        if (this.jdbcManager.isAllowedDynamicQuery(this.getUuaa(), componentName)) {
            ThreadContext.get().addDynamicSql(code, sqlLine);
            LOGGER.info("Added query: " + code + " ,with resource+SQL: " + sqlLine);
        } else {
            throw new RuntimeException(String.format("Dynamic queries not allowed for this component:%s in this uuaa:%s", componentName, this.getUuaa()));
        }
    }

    public String getUuaa() {
        return this.uuaa;
    }
}
