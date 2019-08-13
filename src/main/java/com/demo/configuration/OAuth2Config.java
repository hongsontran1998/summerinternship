package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "tutorialspoint";
    private String clientSecret = "my-secret-key";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----" +
            "MIIEpQIBAAKCAQEAwkdHl8uuarRJlFuEvkoB3h6nl7+JNVh5f8Ej7BXW6IfYsf0S" +
            "xkRwfwJW2nFmERC7QT8sG2DKsKbjZl9GxdeSYqNrcKZpC81JuTeqPHbFAnfk/e/Y" +
            "IWicGDrb1l1gfoL44KLuyZkJOmHpSCnrbMdXqu9SUUlbSMIkwJhxsChNI4m3ik7g" +
            "FbeRkV3ptzQwInF4kwRubQAX93oLW1O7SKL1XFtB0FW12jfFkuSDqOf3QD37vkst" +
            "4UkjknA1mNNxxU9lYGuYz2SSEX/KS052kGuL9uHkN3F6TkSHEwncJ0o1aYdEduzz" +
            "q7vfJs7IGN4maMtMZ7SeGf3We2s0v2jBtROC4QIDAQABAoIBAQCTYy4uO8izjNjx" +
            "Y0jecBjgoRL17cozHU73m9gbyCnFOSItTdhLcCqEQIsRp8wOEEpvYnScxJ6gy8ti" +
            "o892Umfsyxu8V5MD8BcJG/DbdCNcDwc7mxS1q74YJ7cV9rs43zXefd14NdCpaRRo" +
            "udywJr8cn/ksT+Gf3iGxtzUwtjJnTUO+Q0WPZXKm59MU7t9hE9GMBkMUvQakJ2tL" +
            "30Meu9+lrxBI9SiJ/shetyENFJm4bLx6Ai/e9fdnv19BcivVpc6LjhuHv9KZTa0c" +
            "d+FoFhotO56hUEP+Qu0EaBQ19SkygPd2U5W1AxG/FNgvwt2iQwFVNqIeOr3vBOzK" +
            "SK9eCiodAoGBAPpEsIs6o1hDInn7PfwEyW9lI5WaCcFMPx1PEvci67/f+15J0dPq" +
            "Aq+bCI5Io0ovSerbiCgHWbhV36W45GLZ2Y8A8/1MXj259fkP+nJZ/pv0VuAYEtcM" +
            "4h62YpThwrag1gJSAtpJSu0+e7AFaPS3c/9f7chVCle61FwVEJx+YW+vAoGBAMa6" +
            "Uv+PaQGJH44WpSHH3nJU5I28s+5F80Zi/TZR42+ztjC1OVqzYEyIuNQY7nk7U6gP" +
            "VS5jXHdiZ8b6xzbgXxAKBbuu4FwCEIgu24WMhgBPS0x4ePpkr5leKAuEm2PTarPh" +
            "+Q6Ac0n5YpdJpRpaGWr8W0WkGLSlv6HOvAv9jMpvAoGBALjDA08WcEcV8Rr658zp" +
            "v8i0cyvb972zy5iYqxi2uDMEabA3cWgwh+Ea5JsedyaqeLihcAiVPKCBDUZslHeB" +
            "+0K+4mIrAhwx8Kz6JdxMIlMCdSyluSr4gOtJnMfrT/PCE5zM7Pw4Rc+WZHwT0mNw" +
            "GHv9Vy+h0Kvp6yM8DfJqvwZTAoGBAIb2Kz/cSVf9pCx/PI6AipXjCYUozpnXb6wx" +
            "tf2aB3fo+KaDrPvoLlJL2BpTBEHZBKtyHktut3Fsp0X/MiQWpPjjlZks3rodvNR/" +
            "3h4InUjAkUbR2ndSwd7Kjy+jU1SsVB7uLJKosaNfdpGANlx7LB/4WpQlKZIlrstY" +
            "92S9QUyJAoGAEDoMKm6izNC4zZhAQU/udcEo6ZgFqCSWv4fViO/EbQqB6Hfhj2ao" +
            "A0fcUN5wzOI023ASIjdbFf4OJF4vgpgWNclO8/wxUf8AQMsEY0fy9WhixrMqVEBs" +
            "ttAXVDEgdLoYspfjgEwnMqb2ixlqlx7au+778wnre/O18pCm7xSzrMA=" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwkdHl8uuarRJlFuEvkoB" +
            "3h6nl7+JNVh5f8Ej7BXW6IfYsf0SxkRwfwJW2nFmERC7QT8sG2DKsKbjZl9GxdeS" +
            "YqNrcKZpC81JuTeqPHbFAnfk/e/YIWicGDrb1l1gfoL44KLuyZkJOmHpSCnrbMdX" +
            "qu9SUUlbSMIkwJhxsChNI4m3ik7gFbeRkV3ptzQwInF4kwRubQAX93oLW1O7SKL1" +
            "XFtB0FW12jfFkuSDqOf3QD37vkst4UkjknA1mNNxxU9lYGuYz2SSEX/KS052kGuL" +
            "9uHkN3F6TkSHEwncJ0o1aYdEduzzq7vfJs7IGN4maMtMZ7SeGf3We2s0v2jBtROC" +
            "4QIDAQAB" +
            "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }
}