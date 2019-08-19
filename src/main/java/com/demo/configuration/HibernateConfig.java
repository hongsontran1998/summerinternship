package com.demo.configuration;

//
//@Configuration
//@EnableTransactionManagement
public class HibernateConfig {
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//    @Bean
//    public SessionFactory getSessionFactory() {
//        return entityManagerFactory.unwrap(SessionFactory.class);
//    }
//    @Autowired
//    private Environment env;
//
//
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        // See: application.properties
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//        System.out.println("## getDataSource: " + dataSource);
//
//        return dataSource;
//    }

    //    @Bean(name = "entityManagerFactory")
//    public EntityManagerFactory entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(getDataSource());
////        emf.setJpaVendorAdapter(jpaVendorAdapter);
//        emf.setPackagesToScan("com.demo.entity");
//        emf.setPersistenceUnitName("default");
////        emf.afterPropertiesSet();
//        return emf.getObject();
//    }
//
//    @Autowired
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//        Properties properties = new Properties();
//
//        // See: application.properties
//        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//        properties.put("current_session_context_class", //
//                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//
//
//        // Fix Postgres JPA Error:
//        // Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
//        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);
//
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//        // Package contain entity classes
//        factoryBean.setPackagesToScan(new String[]{""});
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setHibernateProperties(properties);
//        factoryBean.afterPropertiesSet();
//        //
//        SessionFactory sf = factoryBean.getObject();
//        System.out.println("## getSessionFactory: " + sf);
//        return sf;
//    }
//
//    @Autowired
//    @Bean(name = "transactionManager")
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//
//        return transactionManager;
//    }
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(getDataSource());
//        sessionFactory.setPackagesToScan(
//                new String[]{"com.demo.entity"});
//        sessionFactory.setHibernateProperties(hibernateProperties());
//
//        return sessionFactory;
//    }
//
//
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//                "hibernate.hbm2ddl.auto", "create-drop");
//        hibernateProperties.setProperty(
//                "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//        return hibernateProperties;
//    }
}
