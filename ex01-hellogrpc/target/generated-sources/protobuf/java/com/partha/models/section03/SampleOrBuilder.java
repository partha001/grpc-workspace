// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section03/well-known-types.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section03;

public interface SampleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:section03.Sample)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Int32Value age = 1;</code>
   * @return Whether the age field is set.
   */
  boolean hasAge();
  /**
   * <code>.google.protobuf.Int32Value age = 1;</code>
   * @return The age.
   */
  com.google.protobuf.Int32Value getAge();
  /**
   * <code>.google.protobuf.Int32Value age = 1;</code>
   */
  com.google.protobuf.Int32ValueOrBuilder getAgeOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp login_time = 2;</code>
   * @return Whether the loginTime field is set.
   */
  boolean hasLoginTime();
  /**
   * <code>.google.protobuf.Timestamp login_time = 2;</code>
   * @return The loginTime.
   */
  com.google.protobuf.Timestamp getLoginTime();
  /**
   * <code>.google.protobuf.Timestamp login_time = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getLoginTimeOrBuilder();
}
