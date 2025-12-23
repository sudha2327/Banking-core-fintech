package com.fintech.fintech;
import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/api/accounts")
public class accuntcontroller {
    private final repo ledgerRepo;
    private final ExecutorService executor=Executors.newFixedThreadPool(10);


    public accuntcontroller(repo ledgerRepo) {
        this.ledgerRepo = ledgerRepo;
    }

    @GetMapping("/")
    public String home(){
        return "Fin Tech Banking API working!!!";
    }

    @GetMapping("/{accountNumber}/balance")
    public CompletableFuture<Double> getBalance(@PathVariable String accountNumber) {
        return CompletableFuture.supplyAsync(() -> {
            Double balance = ledgerRepo.calculateBalance(accountNumber);
            return balance != null ? balance : 0.0;
        }, executor);
    }

}
