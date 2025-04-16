package com.partha.program03;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: program03/game.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GuessNumberGrpc {

  private GuessNumberGrpc() {}

  public static final java.lang.String SERVICE_NAME = "program03.GuessNumber";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.partha.program03.GuessRequest,
      com.partha.program03.GuessResponse> getMakeGuessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeGuess",
      requestType = com.partha.program03.GuessRequest.class,
      responseType = com.partha.program03.GuessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.partha.program03.GuessRequest,
      com.partha.program03.GuessResponse> getMakeGuessMethod() {
    io.grpc.MethodDescriptor<com.partha.program03.GuessRequest, com.partha.program03.GuessResponse> getMakeGuessMethod;
    if ((getMakeGuessMethod = GuessNumberGrpc.getMakeGuessMethod) == null) {
      synchronized (GuessNumberGrpc.class) {
        if ((getMakeGuessMethod = GuessNumberGrpc.getMakeGuessMethod) == null) {
          GuessNumberGrpc.getMakeGuessMethod = getMakeGuessMethod =
              io.grpc.MethodDescriptor.<com.partha.program03.GuessRequest, com.partha.program03.GuessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeGuess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program03.GuessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program03.GuessResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GuessNumberMethodDescriptorSupplier("MakeGuess"))
              .build();
        }
      }
    }
    return getMakeGuessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GuessNumberStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GuessNumberStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GuessNumberStub>() {
        @java.lang.Override
        public GuessNumberStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GuessNumberStub(channel, callOptions);
        }
      };
    return GuessNumberStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GuessNumberBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GuessNumberBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GuessNumberBlockingStub>() {
        @java.lang.Override
        public GuessNumberBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GuessNumberBlockingStub(channel, callOptions);
        }
      };
    return GuessNumberBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GuessNumberFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GuessNumberFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GuessNumberFutureStub>() {
        @java.lang.Override
        public GuessNumberFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GuessNumberFutureStub(channel, callOptions);
        }
      };
    return GuessNumberFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.partha.program03.GuessRequest> makeGuess(
        io.grpc.stub.StreamObserver<com.partha.program03.GuessResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMakeGuessMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GuessNumber.
   */
  public static abstract class GuessNumberImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GuessNumberGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GuessNumber.
   */
  public static final class GuessNumberStub
      extends io.grpc.stub.AbstractAsyncStub<GuessNumberStub> {
    private GuessNumberStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GuessNumberStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GuessNumberStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.partha.program03.GuessRequest> makeGuess(
        io.grpc.stub.StreamObserver<com.partha.program03.GuessResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMakeGuessMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GuessNumber.
   */
  public static final class GuessNumberBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GuessNumberBlockingStub> {
    private GuessNumberBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GuessNumberBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GuessNumberBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GuessNumber.
   */
  public static final class GuessNumberFutureStub
      extends io.grpc.stub.AbstractFutureStub<GuessNumberFutureStub> {
    private GuessNumberFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GuessNumberFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GuessNumberFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MAKE_GUESS = 0;

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
        case METHODID_MAKE_GUESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.makeGuess(
              (io.grpc.stub.StreamObserver<com.partha.program03.GuessResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getMakeGuessMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.partha.program03.GuessRequest,
              com.partha.program03.GuessResponse>(
                service, METHODID_MAKE_GUESS)))
        .build();
  }

  private static abstract class GuessNumberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GuessNumberBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.partha.program03.Game.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GuessNumber");
    }
  }

  private static final class GuessNumberFileDescriptorSupplier
      extends GuessNumberBaseDescriptorSupplier {
    GuessNumberFileDescriptorSupplier() {}
  }

  private static final class GuessNumberMethodDescriptorSupplier
      extends GuessNumberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GuessNumberMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GuessNumberGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GuessNumberFileDescriptorSupplier())
              .addMethod(getMakeGuessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
