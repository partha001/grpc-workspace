// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: program03/bank-service.proto

// Protobuf Java Version: 3.25.5
package com.partha.program03;

public final class BankServiceOuterClass {
  private BankServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program03_BalanceCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program03_BalanceCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program03_AccountBalance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program03_AccountBalance_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program03_AllAccountsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program03_AllAccountsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program03_WithdrawRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program03_WithdrawRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program03_Money_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program03_Money_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program03_ErrorMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program03_ErrorMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034program03/bank-service.proto\022\tprogram0" +
      "3\"-\n\023BalanceCheckRequest\022\026\n\016account_numb" +
      "er\030\001 \001(\005\"9\n\016AccountBalance\022\026\n\016account_nu" +
      "mber\030\001 \001(\005\022\017\n\007balance\030\002 \001(\005\"B\n\023AllAccoun" +
      "tsResponse\022+\n\010accounts\030\001 \003(\0132\031.program03" +
      ".AccountBalance\"9\n\017WithdrawRequest\022\026\n\016ac" +
      "count_number\030\001 \001(\005\022\016\n\006amount\030\002 \001(\005\"\027\n\005Mo" +
      "ney\022\016\n\006amount\030\001 \001(\005\"B\n\014ErrorMessage\0222\n\017v" +
      "alidation_code\030\001 \001(\0162\031.program03.Validat" +
      "ionCode*S\n\016ValidationCode\022\023\n\017INVALID_ACC" +
      "OUNT\020\000\022\022\n\016INVALID_AMOUNT\020\001\022\030\n\024INSUFFICIE" +
      "NT_BALANCE\020\0022\231\001\n\013BankService\022N\n\021GetAccou" +
      "ntBalance\022\036.program03.BalanceCheckReques" +
      "t\032\031.program03.AccountBalance\022:\n\010Withdraw" +
      "\022\032.program03.WithdrawRequest\032\020.program03" +
      ".Money0\001B\030\n\024com.partha.program03P\001b\006prot" +
      "o3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_program03_BalanceCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_program03_BalanceCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program03_BalanceCheckRequest_descriptor,
        new java.lang.String[] { "AccountNumber", });
    internal_static_program03_AccountBalance_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_program03_AccountBalance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program03_AccountBalance_descriptor,
        new java.lang.String[] { "AccountNumber", "Balance", });
    internal_static_program03_AllAccountsResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_program03_AllAccountsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program03_AllAccountsResponse_descriptor,
        new java.lang.String[] { "Accounts", });
    internal_static_program03_WithdrawRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_program03_WithdrawRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program03_WithdrawRequest_descriptor,
        new java.lang.String[] { "AccountNumber", "Amount", });
    internal_static_program03_Money_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_program03_Money_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program03_Money_descriptor,
        new java.lang.String[] { "Amount", });
    internal_static_program03_ErrorMessage_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_program03_ErrorMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program03_ErrorMessage_descriptor,
        new java.lang.String[] { "ValidationCode", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
