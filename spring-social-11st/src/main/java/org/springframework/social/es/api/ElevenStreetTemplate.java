package org.springframework.social.es.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.es.api.impl.MemberOperationsTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetTemplate extends AbstractOAuth2ApiBinding implements ElevenStreet {
    private String accessToken;

    private MemberOperations memberOperations;


    public ElevenStreetTemplate() {
        initialize();
    }

    public ElevenStreetTemplate(String accessToken) {
        super(accessToken);
        this.accessToken = accessToken;
        initialize();

    }

    private void initialize() {
        this.memberOperations = new MemberOperationsTemplate(getRestTemplate(), isAuthorized());
    }


    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setSerializationInclusion(NON_NULL);
        jsonConverter.setObjectMapper(objectMapper);

        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        formHttpMessageConverter.addPartConverter(jsonConverter);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(jsonConverter);
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(formHttpMessageConverter);
        messageConverters.add(new ResourceHttpMessageConverter());
        return messageConverters;
    }

    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.BEARER;
    }

    public MemberOperations getMemberOperations() {
        return this.memberOperations;
    }

    public String getAccessToken() {
        return accessToken;
    }
}

