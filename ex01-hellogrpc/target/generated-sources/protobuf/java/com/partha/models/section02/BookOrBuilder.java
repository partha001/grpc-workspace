// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: section02/collection.proto

// Protobuf Java Version: 3.25.5
package com.partha.models.section02;

public interface BookOrBuilder extends
    // @@protoc_insertion_point(interface_extends:section02.Book)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string title = 1;</code>
   * @return The title.
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 1;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string author = 2;</code>
   * @return The author.
   */
  java.lang.String getAuthor();
  /**
   * <code>string author = 2;</code>
   * @return The bytes for author.
   */
  com.google.protobuf.ByteString
      getAuthorBytes();

  /**
   * <code>int32 publication_year = 3;</code>
   * @return The publicationYear.
   */
  int getPublicationYear();
}
