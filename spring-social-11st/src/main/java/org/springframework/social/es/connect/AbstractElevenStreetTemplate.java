package org.springframework.social.es.connect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.http.HttpMethod.PATCH;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class AbstractElevenStreetTemplate {

    protected final RestTemplate restTemplate;
    protected final boolean isAuthorized;
    private final static Log logger = LogFactory.getLog(AbstractElevenStreetTemplate.class);

    protected AbstractElevenStreetTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        this.restTemplate = restTemplate;
        this.isAuthorized = isAuthorized;

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (logger.isWarnEnabled()) {
                    String bodyText = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
                    logger.warn("11st Connect API REST response body:" + bodyText);
                }
            }
        });
    }

    protected void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException("11st");
        }
    }

    protected <T> T getEntity(String url, Class<T> type) {
        return restTemplate.getForObject(url, type);
    }

    @SuppressWarnings("unchecked")
    protected <T> T saveEntity(String url, T entity) {
        return (T) restTemplate.postForObject(url, entity, entity.getClass());
    }

    protected void deleteEntity(String baseUrl, String id) {
        restTemplate.delete(baseUrl + '/' + id);
    }

    protected <T> T patch(String url, Object request, Class<T> responseType) {
        ResponseEntity<T> response = restTemplate.exchange(url, PATCH, new HttpEntity<Object>(request), responseType);
        return response.getBody();
    }

}
