package com.bap.bpm.utils;

import com.bap.bpm.ssl.BlindTrustManager;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Startup
@ApplicationScoped
public class LocalEnvironmentHandler {

    Logger logger = LoggerFactory.getLogger(LocalEnvironmentHandler.class);

    @ConfigProperty(name = "bpm.useblindtrustmanager", defaultValue = "false")
    protected Boolean useBlineTrustManager;

    void onStart(@Observes StartupEvent ev) throws NoSuchAlgorithmException, KeyManagementException {
        if (useBlineTrustManager) {
            logger.info("Initializing blind trust manager");
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new BlindTrustManager()}, null);
            SSLContext.setDefault(sslContext);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // set the  allTrusting verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        }
    }


}
