// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: program03/bank-service.proto

// Protobuf Java Version: 3.25.5
package com.partha.program03;

public interface AllAccountsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:program03.AllAccountsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .program03.AccountBalance accounts = 1;</code>
   */
  java.util.List<com.partha.program03.AccountBalance> 
      getAccountsList();
  /**
   * <code>repeated .program03.AccountBalance accounts = 1;</code>
   */
  com.partha.program03.AccountBalance getAccounts(int index);
  /**
   * <code>repeated .program03.AccountBalance accounts = 1;</code>
   */
  int getAccountsCount();
  /**
   * <code>repeated .program03.AccountBalance accounts = 1;</code>
   */
  java.util.List<? extends com.partha.program03.AccountBalanceOrBuilder> 
      getAccountsOrBuilderList();
  /**
   * <code>repeated .program03.AccountBalance accounts = 1;</code>
   */
  com.partha.program03.AccountBalanceOrBuilder getAccountsOrBuilder(
      int index);
}
