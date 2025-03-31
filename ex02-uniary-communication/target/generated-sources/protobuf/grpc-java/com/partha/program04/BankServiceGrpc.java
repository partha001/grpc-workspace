package com.partha.program04;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: program04/bank-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BankServiceGrpc {

  private BankServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "program04.BankService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.partha.program04.BalanceCheckRequest,
      com.partha.program04.AccountBalance> getGetAccountBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountBalance",
      requestType = com.partha.program04.BalanceCheckRequest.class,
      responseType = com.partha.program04.AccountBalance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.partha.program04.BalanceCheckRequest,
      com.partha.program04.AccountBalance> getGetAccountBalanceMethod() {
    io.grpc.MethodDescriptor<com.partha.program04.BalanceCheckRequest, com.partha.program04.AccountBalance> getGetAccountBalanceMethod;
    if ((getGetAccountBalanceMethod = BankServiceGrpc.getGetAccountBalanceMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getGetAccountBalanceMethod = BankServiceGrpc.getGetAccountBalanceMethod) == null) {
          BankServiceGrpc.getGetAccountBalanceMethod = getGetAccountBalanceMethod =
              io.grpc.MethodDescriptor.<com.partha.program04.BalanceCheckRequest, com.partha.program04.AccountBalance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program04.BalanceCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program04.AccountBalance.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("GetAccountBalance"))
              .build();
        }
      }
    }
    return getGetAccountBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.partha.program04.AllAccountsResponse> getGetAllAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllAccounts",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.partha.program04.AllAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.partha.program04.AllAccountsResponse> getGetAllAccountsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.partha.program04.AllAccountsResponse> getGetAllAccountsMethod;
    if ((getGetAllAccountsMethod = BankServiceGrpc.getGetAllAccountsMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getGetAllAccountsMethod = BankServiceGrpc.getGetAllAccountsMethod) == null) {
          BankServiceGrpc.getGetAllAccountsMethod = getGetAllAccountsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.partha.program04.AllAccountsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.partha.program04.AllAccountsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("GetAllAccounts"))
              .build();
        }
      }
    }
    return getGetAllAccountsMethod;
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
    default void getAccountBalance(com.partha.program04.BalanceCheckRequest request,
        io.grpc.stub.StreamObserver<com.partha.program04.AccountBalance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountBalanceMethod(), responseObserver);
    }

    /**
     * <pre>
     *note how we are letting it know that this service doesnt take any request parameter
     * </pre>
     */
    default void getAllAccounts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.partha.program04.AllAccountsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllAccountsMethod(), responseObserver);
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
    public void getAccountBalance(com.partha.program04.BalanceCheckRequest request,
        io.grpc.stub.StreamObserver<com.partha.program04.AccountBalance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *note how we are letting it know that this service doesnt take any request parameter
     * </pre>
     */
    public void getAllAccounts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.partha.program04.AllAccountsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllAccountsMethod(), getCallOptions()), request, responseObserver);
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
    public com.partha.program04.AccountBalance getAccountBalance(com.partha.program04.BalanceCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountBalanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *note how we are letting it know that this service doesnt take any request parameter
     * </pre>
     */
    public com.partha.program04.AllAccountsResponse getAllAccounts(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllAccountsMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.partha.program04.AccountBalance> getAccountBalance(
        com.partha.program04.BalanceCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *note how we are letting it know that this service doesnt take any request parameter
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.partha.program04.AllAccountsResponse> getAllAccounts(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllAccountsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_BALANCE = 0;
  private static final int METHODID_GET_ALL_ACCOUNTS = 1;

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
          serviceImpl.getAccountBalance((com.partha.program04.BalanceCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.partha.program04.AccountBalance>) responseObserver);
          break;
        case METHODID_GET_ALL_ACCOUNTS:
          serviceImpl.getAllAccounts((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.partha.program04.AllAccountsResponse>) responseObserver);
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
              com.partha.program04.BalanceCheckRequest,
              com.partha.program04.AccountBalance>(
                service, METHODID_GET_ACCOUNT_BALANCE)))
        .addMethod(
          getGetAllAccountsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.partha.program04.AllAccountsResponse>(
                service, METHODID_GET_ALL_ACCOUNTS)))
        .build();
  }

  private static abstract class BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.partha.program04.BankServiceOuterClass.getDescriptor();
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
              .addMethod(getGetAllAccountsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
