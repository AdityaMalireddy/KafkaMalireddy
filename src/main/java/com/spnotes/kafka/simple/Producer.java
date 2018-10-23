package com.spnotes.kafka.simple;

import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

/**
 * Created by sunilpatil on 12/28/15.
 */
public class Producer {
    private static Scanner in;
    public static void main(String[] argv)throws Exception {
//        if (argv.length != 1) {
//            System.err.println("Please specify 1 parameters ");
//            System.exit(-1);
//        }
        String topicName = argv[0];
//        in = new Scanner(System.in);
//        System.out.println("Enter message(type exit to quit)");

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
//        String line = in.nextLine();
//        while(!line.equals("exit")) {
            //TODO: Make sure to use the ProducerRecord constructor that does not take parition Id
            
            String[] datasample = {"hi","i","am aditya"};
            List<String> datalist = new ArrayList();
            
            for(int i = 0; i < datasample.length;i++ ){
                datalist.add(datasample[i]);
            }
            int i = 1;
            
            for(String s : datalist){
            
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,s);
             System.out.println("Sending this data set " + i + " to client " + s);
             i++;
            producer.send(rec);            
            Thread.sleep(2000);
            }
            
            
//            line = in.nextLine();
//        }
//        in.close();
        producer.close();
    }
}
