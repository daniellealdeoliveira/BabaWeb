/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.BabaWeb.connection.factory;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rodrigo.valentim
 */
public abstract class DAOGenerico {

    public Session session;
    private Transaction transacao;
//    private Mensagem mensagem;
    private static ConnectionFactory connection;

    public DAOGenerico() {
        this.geraConexao();
    }

    public void geraConexao() {
        try {

            if (connection == null) {
                connection = new ConnectionFactory();
            }
            session = connection.getInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the connection
     */
    public static ConnectionFactory getConnection() {
        return connection;
    }

    /**
     * @param aConnection the connection to set
     */
    public static void setConnection(ConnectionFactory aConnection) {
        connection = aConnection;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        if (!session.isOpen()) {
            this.geraConexao();
        }
//        if (session == null || (!session.isOpen() && !session.isConnected())) {
//            this.geraConexao();
//        }

        return session;
    }

    public void closeSession() {
        if (session != null && session.isOpen()) {
            //    session.flush();
            session.close();
        }
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * @return the transacao
     */
    public Transaction getTransacao() {
        return transacao;
    }

    /**
     * @param transacao the transacao to set
     */
    public void setTransacao(Transaction transacao) {
        this.transacao = transacao;
    }
}
