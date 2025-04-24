package org.example.program06;

import io.grpc.Metadata;

public class Constants {

    public static final Metadata.Key<String> API_KEY = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);

    public static final Metadata.Key<String> USER_TOKEN_KEY = Metadata.Key.of("Authorization",Metadata.ASCII_STRING_MARSHALLER);
    public static final String BEARER = "Bearer";

    // Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
}

