// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section03/common/car.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section03.common;

public final class CarOuterClass {
  private CarOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_section03_common_Car_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_section03_common_Car_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032section03/common/car.proto\022\020section03." +
      "common\"a\n\003Car\022\014\n\004make\030\001 \001(\t\022\r\n\005model\030\002 \001" +
      "(\t\022\014\n\004year\030\003 \001(\005\022/\n\nbody_style\030\004 \001(\0162\033.s" +
      "ection03.common.BodyStyle*7\n\tBodyStyle\022\013" +
      "\n\007UNKNOWN\020\000\022\t\n\005SEDAN\020\001\022\t\n\005COUPE\020\002\022\007\n\003SUV" +
      "\020\003B&\n\"com.partha.models.section03.common" +
      "P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_section03_common_Car_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_section03_common_Car_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_section03_common_Car_descriptor,
        new java.lang.String[] { "Make", "Model", "Year", "BodyStyle", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
