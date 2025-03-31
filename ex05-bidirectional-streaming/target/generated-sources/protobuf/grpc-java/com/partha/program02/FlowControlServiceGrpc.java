package com.partha.program02;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: program02/flow-control.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FlowControlServiceGrpc {

  private FlowControlServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "program02.FlowControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.partha.program02.RequestSize,
      com.partha.program02.Output> getGetMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessage",
      requestType = com.partha.program02.RequestSize.class,
      responseType = com.partha.program02.Output.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.partha.program02.RequestSize,
      com.partha.program02.Output> getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.partha.program02.RequestSize, com.partha.program02.Output> getGetMessageMethod;
    if ((getGetMessageMethod = FlowControlServiceGrpc.getGetMessageMethod) == null) {
      synchronized (FlowControlServiceGrpc.class) {
        if ((getGetMessageMethod = FlowControlServiceGrpc.getGetMessageMethod) == null) {
          FlowControlServiceGrpc.getGetMessageMethod = getGetMessageMethod =
              io.grpc.MethodDescriptor.<com.partha.program02.RequestSize, com.partha.program02.Output>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program02.RequestSize.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program02.Output.getDefaultInstance()))
              .setSchemaDescriptor(new FlowControlServiceMethodDescriptorSupplier("GetMessage"))
              .build();
        }
      }
    }
    return getGetMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FlowControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlowControlServiceStub>() {
        @java.lang.Override
        public FlowControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlowControlServiceStub(channel, callOptions);
        }
      };
    return FlowControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlowControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlowControlServiceBlockingStub>() {
        @java.lang.Override
        public FlowControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlowControlServiceBlockingStub(channel, callOptions);
        }
      };
    return FlowControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FlowControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlowControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlowControlServiceFutureStub>() {
        @java.lang.Override
        public FlowControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlowControlServiceFutureStub(channel, callOptions);
        }
      };
    return FlowControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.partha.program02.RequestSize> getMessage(
        io.grpc.stub.StreamObserver<com.partha.program02.Output> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FlowControlService.
   */
  public static abstract class FlowControlServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FlowControlServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FlowControlService.
   */
  public static final class FlowControlServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FlowControlServiceStub> {
    private FlowControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowControlServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.partha.program02.RequestSize> getMessage(
        io.grpc.stub.StreamObserver<com.partha.program02.Output> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FlowControlService.
   */
  public static final class FlowControlServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FlowControlServiceBlockingStub> {
    private FlowControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowControlServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FlowControlService.
   */
  public static final class FlowControlServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FlowControlServiceFutureStub> {
    private FlowControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlowControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlowControlServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getMessage(
              (io.grpc.stub.StreamObserver<com.partha.program02.Output>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetMessageMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.partha.program02.RequestSize,
              com.partha.program02.Output>(
                service, METHODID_GET_MESSAGE)))
        .build();
  }

  private static abstract class FlowControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlowControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.partha.program02.FlowControl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FlowControlService");
    }
  }

  private static final class FlowControlServiceFileDescriptorSupplier
      extends FlowControlServiceBaseDescriptorSupplier {
    FlowControlServiceFileDescriptorSupplier() {}
  }

  private static final class FlowControlServiceMethodDescriptorSupplier
      extends FlowControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FlowControlServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FlowControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FlowControlServiceFileDescriptorSupplier())
              .addMethod(getGetMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
