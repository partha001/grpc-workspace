package com.partha.program02;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: program02/bank-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BankServiceGrpc {

  private BankServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "program02.BankService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.partha.program02.BalanceCheckRequest,
      com.partha.program02.AccountBalance> getGetAccountBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountBalance",
      requestType = com.partha.program02.BalanceCheckRequest.class,
      responseType = com.partha.program02.AccountBalance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.partha.program02.BalanceCheckRequest,
      com.partha.program02.AccountBalance> getGetAccountBalanceMethod() {
    io.grpc.MethodDescriptor<com.partha.program02.BalanceCheckRequest, com.partha.program02.AccountBalance> getGetAccountBalanceMethod;
    if ((getGetAccountBalanceMethod = BankServiceGrpc.getGetAccountBalanceMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getGetAccountBalanceMethod = BankServiceGrpc.getGetAccountBalanceMethod) == null) {
          BankServiceGrpc.getGetAccountBalanceMethod = getGetAccountBalanceMethod =
              io.grpc.MethodDescriptor.<com.partha.program02.BalanceCheckRequest, com.partha.program02.AccountBalance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program02.BalanceCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program02.AccountBalance.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("GetAccountBalance"))
              .build();
        }
      }
    }
    return getGetAccountBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.partha.program02.WithdrawRequest,
      com.partha.program02.Money> getWithdrawMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Withdraw",
      requestType = com.partha.program02.WithdrawRequest.class,
      responseType = com.partha.program02.Money.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.partha.program02.WithdrawRequest,
      com.partha.program02.Money> getWithdrawMethod() {
    io.grpc.MethodDescriptor<com.partha.program02.WithdrawRequest, com.partha.program02.Money> getWithdrawMethod;
    if ((getWithdrawMethod = BankServiceGrpc.getWithdrawMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getWithdrawMethod = BankServiceGrpc.getWithdrawMethod) == null) {
          BankServiceGrpc.getWithdrawMethod = getWithdrawMethod =
              io.grpc.MethodDescriptor.<com.partha.program02.WithdrawRequest, com.partha.program02.Money>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Withdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program02.WithdrawRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program02.Money.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("Withdraw"))
              .build();
        }
      }
    }
    return getWithdrawMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceStub>() {
        @java.lang.Override
        public BankServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceStub(channel, callOptions);
        }
      };
    return BankServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceBlockingStub>() {
        @java.lang.Override
        public BankServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceBlockingStub(channel, callOptions);
        }
      };
    return BankServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceFutureStub>() {
        @java.lang.Override
        public BankServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceFutureStub(channel, callOptions);
        }
      };
    return BankServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *unary
     * </pre>
     */
    default void getAccountBalance(com.partha.program02.BalanceCheckRequest request,
        io.grpc.stub.StreamObserver<com.partha.program02.AccountBalance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountBalanceMethod(), responseObserver);
    }

    /**
     * <pre>
     *server-streaming
     * </pre>
     */
    default void withdraw(com.partha.program02.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.partha.program02.Money> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWithdrawMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BankService.
   */
  public static abstract class BankServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BankServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BankService.
   */
  public static final class BankServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BankServiceStub> {
    private BankServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void getAccountBalance(com.partha.program02.BalanceCheckRequest request,
        io.grpc.stub.StreamObserver<com.partha.program02.AccountBalance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server-streaming
     * </pre>
     */
    public void withdraw(com.partha.program02.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.partha.program02.Money> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BankService.
   */
  public static final class BankServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BankServiceBlockingStub> {
    private BankServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.partha.program02.AccountBalance getAccountBalance(com.partha.program02.BalanceCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountBalanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server-streaming
     * </pre>
     */
    public java.util.Iterator<com.partha.program02.Money> withdraw(
        com.partha.program02.WithdrawRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWithdrawMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BankService.
   */
  public static final class BankServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BankServiceFutureStub> {
    private BankServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.partha.program02.AccountBalance> getAccountBalance(
        com.partha.program02.BalanceCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_BALANCE = 0;
  private static final int METHODID_WITHDRAW = 1;

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
        case METHODID_GET_ACCOUNT_BALANCE:
          serviceImpl.getAccountBalance((com.partha.program02.BalanceCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.partha.program02.AccountBalance>) responseObserver);
          break;
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((com.partha.program02.WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<com.partha.program02.Money>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetAccountBalanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.partha.program02.BalanceCheckRequest,
              com.partha.program02.AccountBalance>(
                service, METHODID_GET_ACCOUNT_BALANCE)))
        .addMethod(
          getWithdrawMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.partha.program02.WithdrawRequest,
              com.partha.program02.Money>(
                service, METHODID_WITHDRAW)))
        .build();
  }

  private static abstract class BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.partha.program02.BankServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankService");
    }
  }

  private static final class BankServiceFileDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier {
    BankServiceFileDescriptorSupplier() {}
  }

  private static final class BankServiceMethodDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BankServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BankServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankServiceFileDescriptorSupplier())
              .addMethod(getGetAccountBalanceMethod())
              .addMethod(getWithdrawMethod())
              .build();
        }
      }
    }
    return result;
  }
}
