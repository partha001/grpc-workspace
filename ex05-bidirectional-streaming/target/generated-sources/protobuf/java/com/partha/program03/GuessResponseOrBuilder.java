// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: program03/game.proto

// Protobuf Java Version: 3.25.5
package com.partha.program03;

public interface GuessResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:program03.GuessResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 attempt = 1;</code>
   * @return The attempt.
   */
  int getAttempt();

  /**
   * <code>.program03.Result result = 2;</code>
   * @return The enum numeric value on the wire for result.
   */
  int getResultValue();
  /**
   * <code>.program03.Result result = 2;</code>
   * @return The result.
   */
  com.partha.program03.Result getResult();
}
