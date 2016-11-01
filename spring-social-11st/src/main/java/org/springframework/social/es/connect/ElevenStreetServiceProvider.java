package org.springframework.social.es.connect;

import org.springframework.social.es.api.ElevenStreet;
import org.springframework.social.es.api.ElevenStreetTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetServiceProvider extends AbstractOAuth2ServiceProvider<ElevenStreet> {

    public ElevenStreetServiceProvider(String clientId, String clientSecret) {
        super(getOAuth2Template(clientId, clientSecret));
    }

    private static OAuth2Template getOAuth2Template(String appId, String appSecret) {
        OAuth2Template oAuth2Template = new OAuth2Template(appId, appSecret, "https://apis.skplanetx.com/11st/oauth/authorize"
                , "https://apis.skplanetx.com/11st/oauth/token");
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    @Override
    public ElevenStreet getApi(String accessToken) {
        return new ElevenStreetTemplate(accessToken);
    }

}