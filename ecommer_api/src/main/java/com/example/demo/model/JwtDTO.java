package com.example.demo.model;


public class JwtDTO {
    private String accessToken;
    private String username;
    private String authorities;
    private Long accountId;
    private String avatarUrl;
    private Long customerId;
    private Long cartId;

    public JwtDTO(String accessToken, String username, String authorities, Long accountId, String avatarUrl, Long customerId, Long cartId) {
        this.accessToken = accessToken;
        this.username = username;
        this.authorities = authorities;
        this.accountId = accountId;
        this.avatarUrl = avatarUrl;
        this.customerId = customerId;
        this.cartId = cartId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
