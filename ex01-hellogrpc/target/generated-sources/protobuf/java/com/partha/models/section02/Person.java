// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section02/person.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section02;

/**
 * Protobuf type {@code section02.Person}
 */
public final class Person extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:section02.Person)
    PersonOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Person.newBuilder() to construct.
  private Person(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Person() {
    lastName_ = "";
    email_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Person();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.partha.models.section02.PersonOuterClass.internal_static_section02_Person_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.partha.models.section02.PersonOuterClass.internal_static_section02_Person_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.partha.models.section02.Person.class, com.partha.models.section02.Person.Builder.class);
  }

  public static final int LAST_NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object lastName_ = "";
  /**
   * <code>string last_name = 1;</code>
   * @return The lastName.
   */
  @java.lang.Override
  public java.lang.String getLastName() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      lastName_ = s;
      return s;
    }
  }
  /**
   * <code>string last_name = 1;</code>
   * @return The bytes for lastName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getLastNameBytes() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      lastName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AGE_FIELD_NUMBER = 2;
  private int age_ = 0;
  /**
   * <code>int32 age = 2;</code>
   * @return The age.
   */
  @java.lang.Override
  public int getAge() {
    return age_;
  }

  public static final int EMAIL_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object email_ = "";
  /**
   * <code>string email = 3;</code>
   * @return The email.
   */
  @java.lang.Override
  public java.lang.String getEmail() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      email_ = s;
      return s;
    }
  }
  /**
   * <code>string email = 3;</code>
   * @return The bytes for email.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getEmailBytes() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      email_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EMPLOYED_FIELD_NUMBER = 4;
  private boolean employed_ = false;
  /**
   * <code>bool employed = 4;</code>
   * @return The employed.
   */
  @java.lang.Override
  public boolean getEmployed() {
    return employed_;
  }

  public static final int SALARY_FIELD_NUMBER = 5;
  private double salary_ = 0D;
  /**
   * <code>double salary = 5;</code>
   * @return The salary.
   */
  @java.lang.Override
  public double getSalary() {
    return salary_;
  }

  public static final int BANK_ACCOUNT_NUMBER_FIELD_NUMBER = 6;
  private long bankAccountNumber_ = 0L;
  /**
   * <code>int64 bank_account_number = 6;</code>
   * @return The bankAccountNumber.
   */
  @java.lang.Override
  public long getBankAccountNumber() {
    return bankAccountNumber_;
  }

  public static final int BALANCE_FIELD_NUMBER = 7;
  private int balance_ = 0;
  /**
   * <code>sint32 balance = 7;</code>
   * @return The balance.
   */
  @java.lang.Override
  public int getBalance() {
    return balance_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, lastName_);
    }
    if (age_ != 0) {
      output.writeInt32(2, age_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(email_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, email_);
    }
    if (employed_ != false) {
      output.writeBool(4, employed_);
    }
    if (java.lang.Double.doubleToRawLongBits(salary_) != 0) {
      output.writeDouble(5, salary_);
    }
    if (bankAccountNumber_ != 0L) {
      output.writeInt64(6, bankAccountNumber_);
    }
    if (balance_ != 0) {
      output.writeSInt32(7, balance_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, lastName_);
    }
    if (age_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, age_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(email_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, email_);
    }
    if (employed_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, employed_);
    }
    if (java.lang.Double.doubleToRawLongBits(salary_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, salary_);
    }
    if (bankAccountNumber_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, bankAccountNumber_);
    }
    if (balance_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(7, balance_);
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
    if (!(obj instanceof com.partha.models.section02.Person)) {
      return super.equals(obj);
    }
    com.partha.models.section02.Person other = (com.partha.models.section02.Person) obj;

    if (!getLastName()
        .equals(other.getLastName())) return false;
    if (getAge()
        != other.getAge()) return false;
    if (!getEmail()
        .equals(other.getEmail())) return false;
    if (getEmployed()
        != other.getEmployed()) return false;
    if (java.lang.Double.doubleToLongBits(getSalary())
        != java.lang.Double.doubleToLongBits(
            other.getSalary())) return false;
    if (getBankAccountNumber()
        != other.getBankAccountNumber()) return false;
    if (getBalance()
        != other.getBalance()) return false;
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
    hash = (37 * hash) + LAST_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getLastName().hashCode();
    hash = (37 * hash) + AGE_FIELD_NUMBER;
    hash = (53 * hash) + getAge();
    hash = (37 * hash) + EMAIL_FIELD_NUMBER;
    hash = (53 * hash) + getEmail().hashCode();
    hash = (37 * hash) + EMPLOYED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getEmployed());
    hash = (37 * hash) + SALARY_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getSalary()));
    hash = (37 * hash) + BANK_ACCOUNT_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getBankAccountNumber());
    hash = (37 * hash) + BALANCE_FIELD_NUMBER;
    hash = (53 * hash) + getBalance();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.partha.models.section02.Person parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.partha.models.section02.Person parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.partha.models.section02.Person parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.partha.models.section02.Person parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.partha.models.section02.Person parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.partha.models.section02.Person parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.partha.models.section02.Person parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.partha.models.section02.Person parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.partha.models.section02.Person parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.partha.models.section02.Person parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.partha.models.section02.Person parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.partha.models.section02.Person parseFrom(
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
  public static Builder newBuilder(com.partha.models.section02.Person prototype) {
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
   * Protobuf type {@code section02.Person}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:section02.Person)
      com.partha.models.section02.PersonOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.partha.models.section02.PersonOuterClass.internal_static_section02_Person_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.partha.models.section02.PersonOuterClass.internal_static_section02_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.partha.models.section02.Person.class, com.partha.models.section02.Person.Builder.class);
    }

    // Construct using com.partha.models.section02.Person.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      lastName_ = "";
      age_ = 0;
      email_ = "";
      employed_ = false;
      salary_ = 0D;
      bankAccountNumber_ = 0L;
      balance_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.partha.models.section02.PersonOuterClass.internal_static_section02_Person_descriptor;
    }

    @java.lang.Override
    public com.partha.models.section02.Person getDefaultInstanceForType() {
      return com.partha.models.section02.Person.getDefaultInstance();
    }

    @java.lang.Override
    public com.partha.models.section02.Person build() {
      com.partha.models.section02.Person result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.partha.models.section02.Person buildPartial() {
      com.partha.models.section02.Person result = new com.partha.models.section02.Person(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.partha.models.section02.Person result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.lastName_ = lastName_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.age_ = age_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.email_ = email_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.employed_ = employed_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.salary_ = salary_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.bankAccountNumber_ = bankAccountNumber_;
      }
      if (((from_bitField0_ & 0x00000040) != 0)) {
        result.balance_ = balance_;
      }
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
      if (other instanceof com.partha.models.section02.Person) {
        return mergeFrom((com.partha.models.section02.Person)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.partha.models.section02.Person other) {
      if (other == com.partha.models.section02.Person.getDefaultInstance()) return this;
      if (!other.getLastName().isEmpty()) {
        lastName_ = other.lastName_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getAge() != 0) {
        setAge(other.getAge());
      }
      if (!other.getEmail().isEmpty()) {
        email_ = other.email_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.getEmployed() != false) {
        setEmployed(other.getEmployed());
      }
      if (other.getSalary() != 0D) {
        setSalary(other.getSalary());
      }
      if (other.getBankAccountNumber() != 0L) {
        setBankAccountNumber(other.getBankAccountNumber());
      }
      if (other.getBalance() != 0) {
        setBalance(other.getBalance());
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
              lastName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              age_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              email_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              employed_ = input.readBool();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            case 41: {
              salary_ = input.readDouble();
              bitField0_ |= 0x00000010;
              break;
            } // case 41
            case 48: {
              bankAccountNumber_ = input.readInt64();
              bitField0_ |= 0x00000020;
              break;
            } // case 48
            case 56: {
              balance_ = input.readSInt32();
              bitField0_ |= 0x00000040;
              break;
            } // case 56
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

    private java.lang.Object lastName_ = "";
    /**
     * <code>string last_name = 1;</code>
     * @return The lastName.
     */
    public java.lang.String getLastName() {
      java.lang.Object ref = lastName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string last_name = 1;</code>
     * @return The bytes for lastName.
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      java.lang.Object ref = lastName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string last_name = 1;</code>
     * @param value The lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      lastName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string last_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastName() {
      lastName_ = getDefaultInstance().getLastName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string last_name = 1;</code>
     * @param value The bytes for lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      lastName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int age_ ;
    /**
     * <code>int32 age = 2;</code>
     * @return The age.
     */
    @java.lang.Override
    public int getAge() {
      return age_;
    }
    /**
     * <code>int32 age = 2;</code>
     * @param value The age to set.
     * @return This builder for chaining.
     */
    public Builder setAge(int value) {

      age_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 age = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAge() {
      bitField0_ = (bitField0_ & ~0x00000002);
      age_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object email_ = "";
    /**
     * <code>string email = 3;</code>
     * @return The email.
     */
    public java.lang.String getEmail() {
      java.lang.Object ref = email_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        email_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string email = 3;</code>
     * @return The bytes for email.
     */
    public com.google.protobuf.ByteString
        getEmailBytes() {
      java.lang.Object ref = email_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string email = 3;</code>
     * @param value The email to set.
     * @return This builder for chaining.
     */
    public Builder setEmail(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      email_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string email = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearEmail() {
      email_ = getDefaultInstance().getEmail();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string email = 3;</code>
     * @param value The bytes for email to set.
     * @return This builder for chaining.
     */
    public Builder setEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      email_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private boolean employed_ ;
    /**
     * <code>bool employed = 4;</code>
     * @return The employed.
     */
    @java.lang.Override
    public boolean getEmployed() {
      return employed_;
    }
    /**
     * <code>bool employed = 4;</code>
     * @param value The employed to set.
     * @return This builder for chaining.
     */
    public Builder setEmployed(boolean value) {

      employed_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>bool employed = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearEmployed() {
      bitField0_ = (bitField0_ & ~0x00000008);
      employed_ = false;
      onChanged();
      return this;
    }

    private double salary_ ;
    /**
     * <code>double salary = 5;</code>
     * @return The salary.
     */
    @java.lang.Override
    public double getSalary() {
      return salary_;
    }
    /**
     * <code>double salary = 5;</code>
     * @param value The salary to set.
     * @return This builder for chaining.
     */
    public Builder setSalary(double value) {

      salary_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>double salary = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearSalary() {
      bitField0_ = (bitField0_ & ~0x00000010);
      salary_ = 0D;
      onChanged();
      return this;
    }

    private long bankAccountNumber_ ;
    /**
     * <code>int64 bank_account_number = 6;</code>
     * @return The bankAccountNumber.
     */
    @java.lang.Override
    public long getBankAccountNumber() {
      return bankAccountNumber_;
    }
    /**
     * <code>int64 bank_account_number = 6;</code>
     * @param value The bankAccountNumber to set.
     * @return This builder for chaining.
     */
    public Builder setBankAccountNumber(long value) {

      bankAccountNumber_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>int64 bank_account_number = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearBankAccountNumber() {
      bitField0_ = (bitField0_ & ~0x00000020);
      bankAccountNumber_ = 0L;
      onChanged();
      return this;
    }

    private int balance_ ;
    /**
     * <code>sint32 balance = 7;</code>
     * @return The balance.
     */
    @java.lang.Override
    public int getBalance() {
      return balance_;
    }
    /**
     * <code>sint32 balance = 7;</code>
     * @param value The balance to set.
     * @return This builder for chaining.
     */
    public Builder setBalance(int value) {

      balance_ = value;
      bitField0_ |= 0x00000040;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 balance = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearBalance() {
      bitField0_ = (bitField0_ & ~0x00000040);
      balance_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:section02.Person)
  }

  // @@protoc_insertion_point(class_scope:section02.Person)
  private static final com.partha.models.section02.Person DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.partha.models.section02.Person();
  }

  public static com.partha.models.section02.Person getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Person>
      PARSER = new com.google.protobuf.AbstractParser<Person>() {
    @java.lang.Override
    public Person parsePartialFrom(
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

  public static com.google.protobuf.Parser<Person> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Person> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.partha.models.section02.Person getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

