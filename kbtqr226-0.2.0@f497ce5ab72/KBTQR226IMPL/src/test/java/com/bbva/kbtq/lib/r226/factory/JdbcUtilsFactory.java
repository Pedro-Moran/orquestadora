package com.bbva.kbtq.lib.r226.factory;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.support.jdbc.manager.JdbcManager;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.kbtq.mock.JdbcUtilsImpl;
import org.osgi.framework.BundleContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JdbcUtilsFactory implements com.bbva.elara.utility.jdbc.connector.factory.JdbcUtilsFactory, InitializingBean {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Autowired
    private JdbcManager jdbcManager;

    private String sqlLocation;

    private String uuaa;

    private String database;


    @Override
    public JdbcUtils getJdbcUtils(final BundleContext bundleContext) throws IOException {

        final Properties properties = new Properties();
        final InputStream is = this.getClass().getResourceAsStream(sqlLocation);
        try {
            properties.load(is);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final Map<String, String> sqls = new HashMap<String, String>();
        for (final Map.Entry<Object, Object> entry : properties.entrySet()) {
            sqls.put(entry.getKey().toString(), (String) entry.getValue());
        }

        final Context context = new Context();
        context.getDynamicSqls().putAll(sqls);
        ThreadContext.set(context);

        return new JdbcUtilsImpl(bundleContext, "warn:moreRows", 100, jdbcManager);
    }

    /**
     * Cambia el valor de la propiedad sqlLocation.
     *
     * @param _sqlLocation the queriesLocation to set
     */
    public void setSqlLocation(final String _sqlLocation) {
        this.sqlLocation = _sqlLocation;
    }


    public String getUuaa() {
        return uuaa;
    }

    public void setUuaa(String uuaa) {
        this.uuaa = uuaa;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        jdbcManager.createCommonJdbcTemplate(uuaa, database, dataSource, null);

    }
}
