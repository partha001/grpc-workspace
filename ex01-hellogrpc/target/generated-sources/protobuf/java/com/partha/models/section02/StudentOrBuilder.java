// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section02/composition.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section02;

public interface StudentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:section02.Student)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.section02.Address address = 2;</code>
   * @return Whether the address field is set.
   */
  boolean hasAddress();
  /**
   * <code>.section02.Address address = 2;</code>
   * @return The address.
   */
  com.partha.models.section02.Address getAddress();
  /**
   * <code>.section02.Address address = 2;</code>
   */
  com.partha.models.section02.AddressOrBuilder getAddressOrBuilder();
}
