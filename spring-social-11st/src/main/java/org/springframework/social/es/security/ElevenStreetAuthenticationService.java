package org.springframework.social.es.security;

import org.springframework.social.es.api.ElevenStreet;
import org.springframework.social.es.connect.ElevenStreetConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetAuthenticationService extends OAuth2AuthenticationService<ElevenStreet> {


    public ElevenStreetAuthenticationService(String apiKey, String appSecret) {
        super(new ElevenStreetConnectionFactory(apiKey, appSecret));
    }
}
