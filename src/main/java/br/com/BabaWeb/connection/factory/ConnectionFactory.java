/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.BabaWeb.connection.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author rodrigo.valentim
 */
public class ConnectionFactory {
//variavel que armazena os mapeamentos e configuracoes do Hibernate

    private static SessionFactory sessionFactory;
    private static final ThreadLocal threadlocal = new ThreadLocal();
    
    

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = new Configuration().configure().buildSessionFactory();
            /*recebemos a configuracao do arquivo hibernate.cfg.xml que possui
             *dados da conexao
             * chamamos o metodo buildSessionFactory que retorna um objeto
             * session, que estabelece uma sessao de comunicacao com o BD
             * atraves de uma conexao JDBC */
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public Session getInstance() {
        Session session = (Session) threadlocal.get();
        session = sessionFactory.openSession();
        threadlocal.set(session);
        return session;
    }
}
