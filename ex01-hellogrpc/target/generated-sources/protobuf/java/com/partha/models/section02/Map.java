// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section02/map.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section02;

public final class Map {
  private Map() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_section02_Car_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_section02_Car_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_section02_Dealer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_section02_Dealer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_section02_Dealer_InventoryEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_section02_Dealer_InventoryEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023section02/map.proto\022\tsection02\"0\n\003Car\022" +
      "\014\n\004make\030\001 \001(\t\022\r\n\005model\030\002 \001(\t\022\014\n\004year\030\003 \001" +
      "(\005\"\177\n\006Dealer\0223\n\tinventory\030\001 \003(\0132 .sectio" +
      "n02.Dealer.InventoryEntry\032@\n\016InventoryEn" +
      "try\022\013\n\003key\030\001 \001(\005\022\035\n\005value\030\002 \001(\0132\016.sectio" +
      "n02.Car:\0028\001B\037\n\033com.partha.models.section" +
      "02P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_section02_Car_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_section02_Car_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_section02_Car_descriptor,
        new java.lang.String[] { "Make", "Model", "Year", });
    internal_static_section02_Dealer_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_section02_Dealer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_section02_Dealer_descriptor,
        new java.lang.String[] { "Inventory", });
    internal_static_section02_Dealer_InventoryEntry_descriptor =
      internal_static_section02_Dealer_descriptor.getNestedTypes().get(0);
    internal_static_section02_Dealer_InventoryEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_section02_Dealer_InventoryEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
