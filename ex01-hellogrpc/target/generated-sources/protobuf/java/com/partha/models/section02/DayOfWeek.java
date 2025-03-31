// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section02/workingwithenums.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section02;

/**
 * Protobuf enum {@code section02.DayOfWeek}
 */
public enum DayOfWeek
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   *it is to be noted that the first field-number has to start with 0
   * </pre>
   *
   * <code>SUNDAY = 0;</code>
   */
  SUNDAY(0),
  /**
   * <code>MONDAY = 1;</code>
   */
  MONDAY(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   *it is to be noted that the first field-number has to start with 0
   * </pre>
   *
   * <code>SUNDAY = 0;</code>
   */
  public static final int SUNDAY_VALUE = 0;
  /**
   * <code>MONDAY = 1;</code>
   */
  public static final int MONDAY_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static DayOfWeek valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static DayOfWeek forNumber(int value) {
    switch (value) {
      case 0: return SUNDAY;
      case 1: return MONDAY;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<DayOfWeek>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      DayOfWeek> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<DayOfWeek>() {
          public DayOfWeek findValueByNumber(int number) {
            return DayOfWeek.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.partha.models.section02.Workingwithenums.getDescriptor().getEnumTypes().get(0);
  }

  private static final DayOfWeek[] VALUES = values();

  public static DayOfWeek valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private DayOfWeek(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:section02.DayOfWeek)
}

