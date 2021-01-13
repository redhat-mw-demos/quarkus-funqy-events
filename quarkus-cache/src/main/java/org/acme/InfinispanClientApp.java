package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.commons.configuration.XMLStringConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class InfinispanClientApp {

    private static final Logger LOGGER = LoggerFactory.getLogger("InfinispanClientApp");

    @Inject
    RemoteCacheManager cacheManager;

    public static final String CACHE_NAME = "CreditCheck";

    private static final String CACHE_CONFIG = "<infinispan><cache-container>" +
            "<serialization marshaller=\"org.infinispan.commons.marshall.JavaSerializationMarshaller\">\n" +
            "    <white-list>\n" +
            "        <class>org.acme.Input</class>\n" +
            "        <regex>org.infinispan.example.*</regex>\n" +
            "    </white-list>\n" +
            "</serialization>"+
            "<distributed-cache name=\"%s\"></distributed-cache>" +
            "</cache-container></infinispan>";

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Creating Cache " + CACHE_NAME);
        RemoteCache<Object, Object> cache = cacheManager.administration().getOrCreateCache(CACHE_NAME,
                new XMLStringConfiguration(String.format(CACHE_CONFIG, CACHE_NAME)));
    }
}