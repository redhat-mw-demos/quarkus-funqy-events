# quarkus-funqy-events project

This project uses Quarkus and the Funqy extension to showcase a simple function chain. 
You will need stern, kubectl, kn, oc binaries installed on your local machine. 

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-funqy-events-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-funqy-events-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-funqy-events-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.


## Things you need to do before running the events on Openshift/kubernetes

Creating the default broker
```
kn broker create default --namespace knativetutorial

kn broker -n knativetutorial list
```

Dont forget to change the container image settings in application.properties and the src/main/k8s/funqy-service.yaml

Deploying the eventing app.
```
kubectl apply -n knativetutorial -f src/main/k8s/funqy-service.yaml

# And the function chain

kubectl apply -n knativetutorial -f src/main/k8s/defaultChain-trigger.yaml
kubectl apply -n knativetutorial -f src/main/k8s/configChain-trigger.yaml
kubectl apply -n knativetutorial -f src/main/k8s/annoatedChain-trigger.yaml
kubectl apply -n knativetutorial -f src/main/k8s/lastChainLink-trigger.yaml

```

running the curler to throw some POST requests to the broker.

```
kubectl apply -n knativetutorial -f src/main/k8s/curler.yaml
kubectl -n knativetutorial exec -it curler -- /bin/bash
```

running stern to watch your pods. 
```
stern funq -c user-container
```

running against the broker directly

```
curl -v "http://broker-ingress.knative-eventing.svc.cluster.local/knativetutorial/default" \
-X POST \
-H "Ce-Id: 1234" \
-H "Ce-Specversion: 1.0" \
-H "Ce-Type: defaultChain" \
-H "Ce-Source: curl" \
-H "Content-Type: application/json" \
-d '{"person":"Shaaf","address":"Denmark","secNumber":"00100","verifiedPerson":false,"verifiedDebts":false,"verifiedTaxes":false,"verifiedPartners":false}
@sshaaf
'
```