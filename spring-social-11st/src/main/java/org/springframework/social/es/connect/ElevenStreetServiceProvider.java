package org.springframework.social.es.connect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.es.api.ElevenStreet;
import org.springframework.social.es.api.ElevenStreetTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.Assert;

import java.io.InvalidObjectException;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetServiceProvider extends AbstractOAuth2ServiceProvider<ElevenStreet> {
    private static final Logger log = LoggerFactory.getLogger(ElevenStreetServiceProvider.class);

    private static String RESOURCE_OWNER_URL;

    public ElevenStreetServiceProvider(final String clientId, final String clientSecret, final String url, final String resourceUrl) {
        super(getOAuth2Template(clientId, clientSecret, url, resourceUrl));
        Assert.notNull(url, "url of resource owner cannot be null.");
        RESOURCE_OWNER_URL = resourceUrl; //real "https://pri-apis.skplanetx.com", stg "https://pri-stg-apis.skplanetx.com"
    }

    public static String getUrl() throws InvalidObjectException {
        if (RESOURCE_OWNER_URL == null || RESOURCE_OWNER_URL.isEmpty()) {
            throw new InvalidObjectException("not contained host information. check it.");
        }
        return RESOURCE_OWNER_URL;
    }

    private static OAuth2Template getOAuth2Template(String appId, String appSecret, String url, String resourceUrl) {
        final String authorizeUrl = url + "/11st/oauth/authorize";
        final String accessTokenUrl = url + "/11st/oauth/token";
        OAuth2Template oAuth2Template = new ElevenStreetOAuth2Template(appId, appSecret, authorizeUrl
                , accessTokenUrl);
        oAuth2Template.setUseParametersForClientAuthentication(true);
        log.info("configurations. authorizeUrl: {}, accessTokenUrl: {}", authorizeUrl, accessTokenUrl);
        return oAuth2Template;
    }

    @Override
    public ElevenStreet getApi(String accessToken) {
        return new ElevenStreetTemplate(accessToken);
    }

}
