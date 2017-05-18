package org.springframework.social.es.connect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author HyungTae Lim
 * @since 2017. 2. 6.
 */
public class ElevenStreetOAuth2Template extends OAuth2Template {
    private static final Logger log = LoggerFactory.getLogger(ElevenStreetOAuth2Template.class);

    public ElevenStreetOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        super.getRestTemplate().setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                log.warn("11st connect api response code: {}, body: {}" + response.getStatusCode(), StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
            }
        });
    }

    public ElevenStreetOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String authenticateUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, authenticateUrl, accessTokenUrl);
    }

    @Override
    public String buildAuthorizeUrl(OAuth2Parameters parameters) {
        log.info("parameters: {}", parameters);
        final String s = super.buildAuthorizeUrl(parameters);
        log.info("result: {}", s);
        return s;
    }

    @Override
    public String buildAuthorizeUrl(GrantType grantType, OAuth2Parameters parameters) {
        log.info("grantType: {}, parameters: {}", grantType, parameters);
        final String s = super.buildAuthorizeUrl(grantType, parameters);
        log.info("result: {}", s);
        return s;

    }

    @Override
    public String buildAuthenticateUrl(OAuth2Parameters parameters) {
        log.info("parameters: {}", parameters);
        final String s = super.buildAuthenticateUrl(parameters);
        log.info("result: {}", s);
        return s;
    }

    @Override
    public String buildAuthenticateUrl(GrantType grantType, OAuth2Parameters parameters) {
        log.info("grantType: {}, parameters: {}", grantType, parameters);
        final String s = super.buildAuthenticateUrl(grantType, parameters);
        log.info("result: {}", s);
        return s;
    }

    @Override
    public AccessGrant exchangeForAccess(String authorizationCode, String redirectUri, MultiValueMap<String, String> additionalParameters) {
        log.info("authorizationCode: {}, redirectUri: {}, additionalParameters: {}", authorizationCode, redirectUri, additionalParameters);
        final AccessGrant accessGrant = super.exchangeForAccess(authorizationCode, redirectUri, additionalParameters);
        log.info("result: {}", accessGrant);
        return accessGrant;
    }

    @Override
    public AccessGrant exchangeCredentialsForAccess(String username, String password, MultiValueMap<String, String> additionalParameters) {
        log.info("username: {}, password: {}, additionalParameters: {}", username, "No display", additionalParameters);
        final AccessGrant accessGrant = super.exchangeCredentialsForAccess(username, password, additionalParameters);
        log.info("result: {}", accessGrant);
        return accessGrant;
    }

    @Override
    public AccessGrant refreshAccess(String refreshToken, String scope, MultiValueMap<String, String> additionalParameters) {
        log.info("refreshToken: {}, scope: {}, additionalParameters: {}", refreshToken, scope, additionalParameters);
        final AccessGrant accessGrant = super.refreshAccess(refreshToken, scope, additionalParameters);
        log.info("result: {}", accessGrant);
        return accessGrant;
    }

    @Override
    public AccessGrant refreshAccess(String refreshToken, MultiValueMap<String, String> additionalParameters) {
        log.info("refreshToken: {},additionalParameters: {}", refreshToken, additionalParameters);
        final AccessGrant accessGrant = super.refreshAccess(refreshToken, additionalParameters);
        log.info("result: {}", accessGrant);
        return accessGrant;
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        log.info("accessTokenUrl: {},parameters: {}", accessTokenUrl, parameters);
        final AccessGrant accessGrant = super.postForAccessGrant(accessTokenUrl, parameters);
        log.info("result: {}", accessGrant);
        return accessGrant;
    }
}
