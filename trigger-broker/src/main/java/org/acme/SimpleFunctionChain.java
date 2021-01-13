package org.acme;


import io.quarkus.funqy.Context;
import io.quarkus.funqy.Funq;
import io.quarkus.funqy.knative.events.CloudEvent;
import io.quarkus.funqy.knative.events.CloudEventMapping;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;


public class SimpleFunctionChain {

    @Inject
    @RestClient
    InputService inputService;
    
    /**
     * Expects knative event of type "defaultChain".  Creates event of type "defaultChain.output".
     *
     * From the guide, this function is triggered by an external curl invocation.
     *
     * @param input
     * @return
     */
    @Funq
    public Input defaultChain(Input input) {
        System.out.println("*** defaultChain - Validate Person ***");
        input.setVerifiedPerson(true);
        inputService.postInput(input);
        System.out.println(input);
        return input;
    }

    /**
     * This is triggered by defaultChain and is example of using application.properties to
     * map the cloud event to this function and to map response.  Response will trigger
     * the annotatedChain function.
     *
     * application.properties will have:
     *
     * quarkus.funqy.knative-events.mapping.configChain.trigger=defaultChain.output
     * quarkus.funqy.knative-events.mapping.configChain.response-type=annotated
     * quarkus.funqy.knative-events.mapping.configChain.response-source=configMapping
     *
     *
     *
     * @param input
     * @return
     */
    @Funq
    public Input configChain(Input input) {
        System.out.println("*** configChain Verify Debts ***");
        input.setVerifiedDebts(true);
        inputService.postInput(input);
        System.out.println(input);
        return input;
    }

    /**
     * Triggered by configChain output.
     *
     * Example of mapping the cloud event via an annotation.
     *
     * @param input
     * @return
     */
    @Funq
    @CloudEventMapping(trigger = "annotated", responseSource = "annotated", responseType = "lastChainLink")
    public Input annotatedChain(Input input) {
        System.out.println("*** annotatedChain Verify Address and info ***");
        input.setVerifiedPartners(true);
        inputService.postInput(input);
        System.out.println(input);
        return input;
    }

    /**
     * Last event in chain.  Has no output.  Triggered by annotatedChain.
     *
     * @param input
     */
    @Funq
    public void lastChainLink(Input input, @Context CloudEvent event) {
        System.out.println("*** lastChainLink Verify Tax ***");
        input.setVerifiedTaxes(true);
        inputService.postInput(input);
        System.out.println(input + "::" + "lastChainLink");
    }

}

