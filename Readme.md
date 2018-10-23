# H08 - Java Kafka

Clone the h08 project. Explore the Maven pom file and the Java code for the Producer and Consumer.

We should dowload the maven and should set up environmental variables and path for Maven in the settings.

please install and configure zookeeper and kafka.
Run the zookeeper in one terminal window and kafka in another terminal window. 

To build and run the consumer and producer, we have to run the below commands.

"mvn compile assembly:single" -It builds the software. Run this command in the terminal window of the kafkaMalireddy folder

Run the below command in the same terminal window - "java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1"

Run the below code in a another terminal window - "java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Producer test"

Now we can see the output in the consumer terminal window.
