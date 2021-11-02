package com.bap.bpm.ssl;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class BlindTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain,
                                   String authType) throws java.security.cert.CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain,
                                   String authType) throws java.security.cert.CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
