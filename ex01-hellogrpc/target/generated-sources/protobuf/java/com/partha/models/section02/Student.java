// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section02/composition.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section02;

/**
 * Protobuf type {@code section02.Student}
 */
public final class Student extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:section02.Student)
    StudentOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Student.newBuilder() to construct.
  private Student(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Student() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Student();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.partha.models.section02.Composition.internal_static_section02_Student_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.partha.models.section02.Composition.internal_static_section02_Student_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.partha.models.section02.Student.class, com.partha.models.section02.Student.Builder.class);
  }

  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";
  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ADDRESS_FIELD_NUMBER = 2;
  private com.partha.models.section02.Address address_;
  /**
   * <code>.section02.Address address = 2;</code>
   * @return Whether the address field is set.
   */
  @java.lang.Override
  public boolean hasAddress() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.section02.Address address = 2;</code>
   * @return The address.
   */
  @java.lang.Override
  public com.partha.models.section02.Address getAddress() {
    return address_ == null ? com.partha.models.section02.Address.getDefaultInstance() : address_;
  }
  /**
   * <code>.section02.Address address = 2;</code>
   */
  @java.lang.Override
  public com.partha.models.section02.AddressOrBuilder getAddressOrBuilder() {
    return address_ == null ? com.partha.models.section02.Address.getDefaultInstance() : address_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getAddress());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getAddress());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.partha.models.section02.Student)) {
      return super.equals(obj);
    }
    com.partha.models.section02.Student other = (com.partha.models.section02.Student) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (hasAddress() != other.hasAddress()) return false;
    if (hasAddress()) {
      if (!getAddress()
          .equals(other.getAddress())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    if (hasAddress()) {
      hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getAddress().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.partha.models.section02.Student parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.partha.models.section02.Student parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.partha.models.section02.Student parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.partha.models.section02.Student parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.partha.models.section02.Student parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.partha.models.section02.Student parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.partha.models.section02.Student parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.partha.models.section02.Student parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.partha.models.section02.Student parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.partha.models.section02.Student parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.partha.models.section02.Student parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.partha.models.section02.Student parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.partha.models.section02.Student prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code section02.Student}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:section02.Student)
      com.partha.models.section02.StudentOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.partha.models.section02.Composition.internal_static_section02_Student_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.partha.models.section02.Composition.internal_static_section02_Student_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.partha.models.section02.Student.class, com.partha.models.section02.Student.Builder.class);
    }

    // Construct using com.partha.models.section02.Student.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getAddressFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      name_ = "";
      address_ = null;
      if (addressBuilder_ != null) {
        addressBuilder_.dispose();
        addressBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.partha.models.section02.Composition.internal_static_section02_Student_descriptor;
    }

    @java.lang.Override
    public com.partha.models.section02.Student getDefaultInstanceForType() {
      return com.partha.models.section02.Student.getDefaultInstance();
    }

    @java.lang.Override
    public com.partha.models.section02.Student build() {
      com.partha.models.section02.Student result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.partha.models.section02.Student buildPartial() {
      com.partha.models.section02.Student result = new com.partha.models.section02.Student(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.partha.models.section02.Student result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.name_ = name_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.address_ = addressBuilder_ == null
            ? address_
            : addressBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.partha.models.section02.Student) {
        return mergeFrom((com.partha.models.section02.Student)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.partha.models.section02.Student other) {
      if (other == com.partha.models.section02.Student.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasAddress()) {
        mergeAddress(other.getAddress());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              name_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getAddressFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 1;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.partha.models.section02.Address address_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.partha.models.section02.Address, com.partha.models.section02.Address.Builder, com.partha.models.section02.AddressOrBuilder> addressBuilder_;
    /**
     * <code>.section02.Address address = 2;</code>
     * @return Whether the address field is set.
     */
    public boolean hasAddress() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.section02.Address address = 2;</code>
     * @return The address.
     */
    public com.partha.models.section02.Address getAddress() {
      if (addressBuilder_ == null) {
        return address_ == null ? com.partha.models.section02.Address.getDefaultInstance() : address_;
      } else {
        return addressBuilder_.getMessage();
      }
    }
    /**
     * <code>.section02.Address address = 2;</code>
     */
    public Builder setAddress(com.partha.models.section02.Address value) {
      if (addressBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        address_ = value;
      } else {
        addressBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.section02.Address address = 2;</code>
     */
    public Builder setAddress(
        com.partha.models.section02.Address.Builder builderForValue) {
      if (addressBuilder_ == null) {
        address_ = builderForValue.build();
      } else {
        addressBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.section02.Address address = 2;</code>
     */
    public Builder mergeAddress(com.partha.models.section02.Address value) {
      if (addressBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          address_ != null &&
          address_ != com.partha.models.section02.Address.getDefaultInstance()) {
          getAddressBuilder().mergeFrom(value);
        } else {
          address_ = value;
        }
      } else {
        addressBuilder_.mergeFrom(value);
      }
      if (address_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.section02.Address address = 2;</code>
     */
    public Builder clearAddress() {
      bitField0_ = (bitField0_ & ~0x00000002);
      address_ = null;
      if (addressBuilder_ != null) {
        addressBuilder_.dispose();
        addressBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.section02.Address address = 2;</code>
     */
    public com.partha.models.section02.Address.Builder getAddressBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getAddressFieldBuilder().getBuilder();
    }
    /**
     * <code>.section02.Address address = 2;</code>
     */
    public com.partha.models.section02.AddressOrBuilder getAddressOrBuilder() {
      if (addressBuilder_ != null) {
        return addressBuilder_.getMessageOrBuilder();
      } else {
        return address_ == null ?
            com.partha.models.section02.Address.getDefaultInstance() : address_;
      }
    }
    /**
     * <code>.section02.Address address = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.partha.models.section02.Address, com.partha.models.section02.Address.Builder, com.partha.models.section02.AddressOrBuilder> 
        getAddressFieldBuilder() {
      if (addressBuilder_ == null) {
        addressBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.partha.models.section02.Address, com.partha.models.section02.Address.Builder, com.partha.models.section02.AddressOrBuilder>(
                getAddress(),
                getParentForChildren(),
                isClean());
        address_ = null;
      }
      return addressBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:section02.Student)
  }

  // @@protoc_insertion_point(class_scope:section02.Student)
  private static final com.partha.models.section02.Student DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.partha.models.section02.Student();
  }

  public static com.partha.models.section02.Student getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Student>
      PARSER = new com.google.protobuf.AbstractParser<Student>() {
    @java.lang.Override
    public Student parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Student> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Student> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.partha.models.section02.Student getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

