package org.springframework.social.es.connect;

import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.es.api.ElevenStreet;
import org.springframework.social.oauth2.AccessGrant;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetConnectionFactory extends OAuth2ConnectionFactory<ElevenStreet> {

    public ElevenStreetConnectionFactory(String clientId, String clientSecret, String url, String reousrceUrl) {
        super("11st", new ElevenStreetServiceProvider(clientId, clientSecret, url, reousrceUrl), new ElevenStreetAdapter());
    }

    @Override
    protected String extractProviderUserId(AccessGrant accessGrant) {
        ElevenStreet api = ((ElevenStreetServiceProvider) getServiceProvider()).getApi(accessGrant.getAccessToken());
        UserProfile userProfile = getApiAdapter().fetchUserProfile(api);
        return userProfile.getUsername();
    }

}
