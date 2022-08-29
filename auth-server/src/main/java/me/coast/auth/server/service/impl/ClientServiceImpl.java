package me.coast.auth.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import cn.hutool.core.collection.CollUtil;
import me.coast.auth.server.domain.entity.Client;
import me.coast.auth.server.service.ClientService;
import me.coast.auth.server.service.principal.ClientPrincipal;

public class ClientServiceImpl implements ClientService {

    private List<Client> clientList;
    private final PasswordEncoder passwordEncoder;

    public ClientServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //@PostConstruct
    public void initData() {
        String clientSecret = passwordEncoder.encode("123456");
        clientList = new ArrayList<>();
        // 1、密码模式
        clientList.add(Client.builder()
                .clientId("client-app")
                .resourceIds("oauth2-resource")
                .secretRequire(false)
                .clientSecret(clientSecret)
                .scopeRequire(false)
                .scope("all")
                .authorizedGrantTypes("password,refresh_token")
                .authorities("ADMIN,USER")
                .accessTokenValidity(3600)
                .refreshTokenValidity(86400).build());
        // 2、授权码模式
        clientList.add(Client.builder()
                .clientId("client-app-2")
                .resourceIds("oauth2-resource2")
                .secretRequire(false)
                .clientSecret(clientSecret)
                .scopeRequire(false)
                .scope("all")
                .authorizedGrantTypes("authorization_code,refresh_token")
                .webServerRedirectUri("https://www.gathub.cn,https://www.baidu.com")
                .authorities("USER")
                .accessTokenValidity(3600)
                .refreshTokenValidity(86400).build());
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        List<Client> findClientList = clientList.stream().filter(item -> item.getClientId().equals(clientId)).collect(Collectors.toList());
        if (CollUtil.isEmpty(findClientList)) {
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, MessageConstant.NOT_FOUND_CLIENT);
        }
        return new ClientPrincipal(findClientList.get(0));
    }
}
