// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: program01/bank-service.proto

// Protobuf Java Version: 3.25.5
package com.partha.program01;

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
    internal_static_program01_BalanceCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_BalanceCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program01_AccountBalance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_AccountBalance_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program01_AllAccountsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_AllAccountsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program01_WithdrawRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_WithdrawRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program01_Money_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_Money_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program01_DepositRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_DepositRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program01_TransferRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_TransferRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_program01_TransferResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_program01_TransferResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034program01/bank-service.proto\022\tprogram0" +
      "1\032\033google/protobuf/empty.proto\"-\n\023Balanc" +
      "eCheckRequest\022\026\n\016account_number\030\001 \001(\005\"9\n" +
      "\016AccountBalance\022\026\n\016account_number\030\001 \001(\005\022" +
      "\017\n\007balance\030\002 \001(\005\"B\n\023AllAccountsResponse\022" +
      "+\n\010accounts\030\001 \003(\0132\031.program01.AccountBal" +
      "ance\"9\n\017WithdrawRequest\022\026\n\016account_numbe" +
      "r\030\001 \001(\005\022\016\n\006amount\030\002 \001(\005\"\027\n\005Money\022\016\n\006amou" +
      "nt\030\001 \001(\005\"X\n\016DepositRequest\022\030\n\016account_nu" +
      "mber\030\001 \001(\005H\000\022!\n\005money\030\002 \001(\0132\020.program01." +
      "MoneyH\000B\t\n\007request\"K\n\017TransferRequest\022\024\n" +
      "\014from_account\030\001 \001(\005\022\022\n\nto_account\030\002 \001(\005\022" +
      "\016\n\006amount\030\003 \001(\005\"\235\001\n\020TransferResponse\022)\n\006" +
      "status\030\001 \001(\0162\031.program01.TransferStatus\022" +
      "/\n\014from_account\030\002 \001(\0132\031.program01.Accoun" +
      "tBalance\022-\n\nto_account\030\003 \001(\0132\031.program01" +
      ".AccountBalance*-\n\016TransferStatus\022\014\n\010REJ" +
      "ECTED\020\000\022\r\n\tCOMPLETED\020\0012\246\002\n\013BankService\022N" +
      "\n\021GetAccountBalance\022\036.program01.BalanceC" +
      "heckRequest\032\031.program01.AccountBalance\022H" +
      "\n\016GetAllAccounts\022\026.google.protobuf.Empty" +
      "\032\036.program01.AllAccountsResponse\022:\n\010With" +
      "draw\022\032.program01.WithdrawRequest\032\020.progr" +
      "am01.Money0\001\022A\n\007Deposit\022\031.program01.Depo" +
      "sitRequest\032\031.program01.AccountBalance(\0012" +
      "Z\n\017TransferService\022G\n\010Transfer\022\032.program" +
      "01.TransferRequest\032\033.program01.TransferR" +
      "esponse(\0010\001B\030\n\024com.partha.program01P\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_program01_BalanceCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_program01_BalanceCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_BalanceCheckRequest_descriptor,
        new java.lang.String[] { "AccountNumber", });
    internal_static_program01_AccountBalance_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_program01_AccountBalance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_AccountBalance_descriptor,
        new java.lang.String[] { "AccountNumber", "Balance", });
    internal_static_program01_AllAccountsResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_program01_AllAccountsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_AllAccountsResponse_descriptor,
        new java.lang.String[] { "Accounts", });
    internal_static_program01_WithdrawRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_program01_WithdrawRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_WithdrawRequest_descriptor,
        new java.lang.String[] { "AccountNumber", "Amount", });
    internal_static_program01_Money_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_program01_Money_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_Money_descriptor,
        new java.lang.String[] { "Amount", });
    internal_static_program01_DepositRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_program01_DepositRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_DepositRequest_descriptor,
        new java.lang.String[] { "AccountNumber", "Money", "Request", });
    internal_static_program01_TransferRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_program01_TransferRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_TransferRequest_descriptor,
        new java.lang.String[] { "FromAccount", "ToAccount", "Amount", });
    internal_static_program01_TransferResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_program01_TransferResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_program01_TransferResponse_descriptor,
        new java.lang.String[] { "Status", "FromAccount", "ToAccount", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
