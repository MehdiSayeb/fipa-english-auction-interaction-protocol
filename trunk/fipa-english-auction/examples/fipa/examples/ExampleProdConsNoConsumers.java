package fipa.examples;

import jade.Boot;

import java.io.File;

import fipa.mock.agents.ProducerMockAgent;

/**
 * Class which shows example of bidding between one producer and three
 * consumers. The first consumer (<code>consumer1</code>) bids only the first
 * time. The second consumer (<code>consumer2</code>) bids only the first two
 * times. The third consumer (<code>consumer3</code>) bids only the first three
 * times, but in that way he wins the auction. Afterwards he does not refuse to
 * pay and the payment finishes successfully.
 * 
 * <p>
 * There is a <code>Sniffer</code> agent which is used for visualization of the
 * communication between the producer and consumers.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class ExampleProdConsNoConsumers {

    // --- Methods -------------------------------------------------------------

    public static void main(String[] args) {
	File projectDir = new File(".");
	String[] argzz = {
		"-classpath",
		projectDir.getAbsolutePath() + "\\classes", // "-gui",
		"producer:" + ProducerMockAgent.class.getName(),
		"Sniffer:jade.tools.sniffer.Sniffer(consumer*; producer*)" };
	Boot bootInstance = null;
	try {
	    bootInstance = new Boot(argzz);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	} finally {
	    if (bootInstance != null) {
		bootInstance = null;
	    }
	}
    }
}
