package com.my.research.and.dev.activemq;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.Arrays;

public class Receiver {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;

    public Receiver() {

    }

    public void receiveMessageAsync() {
        try {
            factory = new ActiveMQConnectionFactory("failover:(tcp://localhost:61616)?randomize=false");
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("SAMPLEQUEUE");
            consumer = session.createConsumer(destination);
            final MessageListener listener = message -> {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        System.out.println("Message is : " + textMessage.getText() + "'");
                    }
                } catch (JMSException e) {
                    System.out.println("Caught:" + e);
                    e.printStackTrace();
                }
            };
            consumer.setMessageListener(listener);
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessageSync() {
        try {
            factory = new ActiveMQConnectionFactory("failover:(tcp://localhost:61616)?randomize=false");
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("SAMPLEQUEUE");
            consumer = session.createConsumer(destination);
            connection.start();
            while (true) {
                final Message message = consumer.receive(100);
                parseMessageAsBytes(message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void parseMessage(final Message message) throws JMSException {
        if (message != null && message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Message is : " + textMessage.getText() + "'");
        }
    }

    private void parseMessageAsBytes(final Message message) throws JMSException {
        if (message != null) {
            final BytesMessage bytesMessage = (BytesMessage) message;
            final int length = (int) bytesMessage.getBodyLength();
            final byte[] bytes = new byte[length];
            bytesMessage.readBytes(bytes, length);
            System.out.println("Length: " + length);
            System.out.println("Bytes: " + Arrays.toString(bytes));
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Message is : " + textMessage.getText() + "'");
            }
        }
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.receiveMessageSync();
    }
}
