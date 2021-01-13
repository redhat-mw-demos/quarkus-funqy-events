package org.acme;

import io.quarkus.infinispan.client.Remote;
import org.infinispan.client.hotrod.RemoteCache;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InputService {

    @Inject
    @Remote(InfinispanClientApp.CACHE_NAME)
    RemoteCache<String, Input> inputCache;

    public List<Input> getAll() {
        return new ArrayList<>(inputCache.values());
    }

    public void save(Input entry) {
        inputCache.put(entry.getKey(), entry);
    }

    public void delete(Input entry) {
        inputCache.remove(entry.getKey());
    }

    public Input getEntry(Input entry){
        return inputCache.get(entry.getKey());
    }

    public Input findById(String key) {
        return inputCache.get(key);
    }

}
