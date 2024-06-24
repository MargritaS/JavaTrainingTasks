package org.task2;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import  org.mockito.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class LoginServiceTest {
        @Test
    public void LoginSuccesfullTest() {
        //given
        IAccount account = mock(IAccount.class);
        given(account.passwordMatches(anyString())).willReturn(true);

        IAccountRepository accountRepository = mock(IAccountRepository.class);
        given(accountRepository.find(anyString())).willReturn(account);

        var loginService = new LoginService(accountRepository);

        //when
        loginService.login("123", "Password");

        //then
        verify(account).setLoggedIn(true);
    }
    @Test
    public void LoginNotSuccesfullTest() {
        //given
        IAccount account = mock(IAccount.class);
        given(account.passwordMatches(anyString())).willReturn(false);

        IAccountRepository accountRepository = mock(IAccountRepository.class);
        given(accountRepository.find(anyString())).willReturn(account);

        var loginService = new LoginService(accountRepository);

        //when
        loginService.login("123", "Password");

        //then
        verify(account, never()).setLoggedIn(true);
    }

    @Test
    public void AccountRevokedTest() {
        //given
        IAccount account = mock(IAccount.class);
        given(account.passwordMatches(anyString())).willReturn(false);

        IAccountRepository accountRepository = mock(IAccountRepository.class);
        given(accountRepository.find(anyString())).willReturn(account);

        var loginService = new LoginService(accountRepository);

        //when
        loginService.login("123", "Password");
        //when
        loginService.login("123", "Password");
        //when
        loginService.login("123", "Password");

        //then
        verify(account).setRevoked(true);
    }
}
