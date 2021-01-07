package com.example.demo.controller;

import com.example.demo.configuration.TokenAuthenticator;
import com.example.demo.model.*;
import com.example.demo.service.AccountRoleService;
import com.example.demo.service.AccountService;
import com.example.demo.service.CartService;
import com.example.demo.service.CustomerService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
public class LoginController {
    public static String GOOGLE_CLIENT_ID = "103585693874-0bjkl21cmmjf8d9n09io95ciuveiievl.apps.googleusercontent.com";
//    public static String GOOGLE_CLIENT_ID = "352140522561-vpmetjr6bjce1vod9b0cppihhbcgdesh.apps.googleusercontent.com";
    public static String PASSWORD = "123";
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRoleService accountRoleService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CartService cartService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public JwtDTO getJwt (@RequestBody AccountDTO accountDTO){
        Account account;
        try {
            account = accountService.getAccount(accountDTO.getUsername());
            if (new BCryptPasswordEncoder().matches( accountDTO.getPassword(), account.getPassword()) && account != null){
                AccountRole accountRole = accountRoleService.getList().stream().filter(e -> e.getAccount().getId()== account.getId()).findFirst().get();
                System.out.println(accountRole.getRole().getName());
                String roleName = accountRole.getRole().getName();
                String token = TokenAuthenticator.addAuthentication(accountDTO.getUsername(), roleName);
                Long accountId = account.getId();
                Customer customer = customerService.getListCustomer().stream().filter(e -> e.getAccount().getId() == account.getId()).findFirst().get();
                String avatarUrl = customer.getAvatarUrl();
                Cart cart = cartService.getListCart().stream().filter(e -> e.getCustomer().getId() == customer.getId()).findFirst().get();
                Long customerId = cart.getCustomer().getId();
                Long cartId = cart.getId();
                return new JwtDTO(token, account.getUsername(), roleName, accountId, avatarUrl, customerId, cartId);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @GetMapping("/getAccount")
    public List<AccountRole> get(){
        return accountRoleService.getList();
    }

    @PostMapping("/login-facebook")
    public JwtDTO getAccFb(@RequestBody AccountFb accountFb){
        String randomNumber = "123456789";
        String result = "KH-";
        for(int i=0; i<5; i++){
            result += randomNumber.charAt((int) Math.floor(Math.random()*randomNumber.length()));
        }
        return null;
    }

    @PostMapping("/login-google")
    public JwtDTO authenticateByGoogleAccount (@RequestBody TokenDTO tokenDTO) throws IOException, java.io.IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = new JacksonFactory();
        GoogleIdTokenVerifier.Builder verifier = new GoogleIdTokenVerifier.Builder(transport, jacksonFactory).setAudience(Collections.singletonList(GOOGLE_CLIENT_ID));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDTO.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        Account account;
        String username = (String) payload.get("name");
        if (accountService.existsAccountByUsername(username)){
            account = accountService.getAccount(username);
        }else {
            account = saveAccount(username);
        };


//        return new JwtDTO(token, account.getUsername(), roleName, accountId, avatarUrl, customerId, cartId);
        return null;
    }


    private Account saveAccount(String value){
        Account account = new Account();
        account.setUsername(value);
        account.setPassword(passwordEncoder.encode(PASSWORD));
        account.setDeleted((byte) 0);
        account.setDescription("description");
        accountService.saveAccount(account);
        return account;
    }




}
