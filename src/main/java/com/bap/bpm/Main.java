package com.bap.bpm;

import com.bap.bpm.ssl.BlindTrustManager;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@QuarkusMain
public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {

        Quarkus.run(args);
    }
}
