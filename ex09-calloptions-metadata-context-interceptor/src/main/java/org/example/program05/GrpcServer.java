package org.example.program05;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.function.Consumer;

public class GrpcServer {

    private static final Logger log = LoggerFactory.getLogger(GrpcServer.class);


    private final Server server;

    private GrpcServer(Server server) {
        this.server = server;
    }

    public static GrpcServer create(BindableService... services) {
        return create(6565, services);
    }
//
//    public static GrpcServer create(int port, BindableService... services){
//
//        var builder = ServerBuilder.forPort(port);
//
//        Arrays.asList(services).forEach(builder::addService);
//        return new GrpcServer(builder.build());
//    }


    public static GrpcServer create(int port, BindableService... services) {
        return create(port, builder -> {
            Arrays.asList(services).forEach(builder::addService);
        });
    }

    public static GrpcServer create(int port, Consumer<ServerBuilder<?>> consumer) {
        var builder = ServerBuilder.forPort(port);
        consumer.accept(builder);
        return new GrpcServer(builder.build());
    }

    public GrpcServer start() {
        //this is basically to print all the services that are registered to the server
        var services = server.getServices().stream().map(ServerServiceDefinition::getServiceDescriptor)
                .map(ServiceDescriptor::getName)
                .toList();
        try {
            server.start();
            log.info("server started. listening on port {}. services:{}", server.getPort(), services);
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void await() {
        try {
            server.awaitTermination();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void stop() {
        server.shutdownNow();
        log.info("server stopped");
    }


}
