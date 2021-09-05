package com.github.airatgaliev.learngraphqljava.resolver;

import com.github.airatgaliev.learngraphqljava.domain.bank.BankAccount;
import com.github.airatgaliev.learngraphqljava.domain.bank.Client;
import com.github.airatgaliev.learngraphqljava.domain.bank.CurrencyEnum;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

  public BankAccount bankAccount(UUID id) {
    log.info("Retrieving bank account id: {}", id);
    var clientA = Client.builder().id(UUID.randomUUID()).firstName("Airat1").lastName("Galiev1")
        .build();
    var clientB = Client.builder().id(UUID.randomUUID()).firstName("Airat2").lastName("Galiev2")
        .build();
    clientA.setClient(clientB);
    clientB.setClient(clientA);
    return BankAccount.builder().id(id).currencyEnum(CurrencyEnum.USD).client(clientA).build();
  }
}
