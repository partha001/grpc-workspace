// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: program02/bank-service.proto

// Protobuf Java Version: 3.25.5
package com.partha.program02;

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
    internal_static_program02_BalanceCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program02_BalanceCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program02_AccountBalance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program02_AccountBalance_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034program02/bank-service.proto\022\tprogram0" +
      "2\"-\n\023BalanceCheckRequest\022\026\n\016account_numb" +
      "er\030\001 \001(\005\"9\n\016AccountBalance\022\026\n\016account_nu" +
      "mber\030\001 \001(\005\022\017\n\007balance\030\002 \001(\0052]\n\013BankServi" +
      "ce\022N\n\021GetAccountBalance\022\036.program02.Bala" +
      "nceCheckRequest\032\031.program02.AccountBalan" +
      "ceB\030\n\024com.partha.program02P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_program02_BalanceCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_program02_BalanceCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program02_BalanceCheckRequest_descriptor,
        new java.lang.String[] { "AccountNumber", });
    internal_static_program02_AccountBalance_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_program02_AccountBalance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program02_AccountBalance_descriptor,
        new java.lang.String[] { "AccountNumber", "Balance", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
