package com.example.account.domain;

import java.time.LocalDateTime;

import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction extends BaseEntity{
	@Enumerated(EnumType.STRING)
    private TransactionType transactionType;
	@Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;
	
	@ManyToOne
	private Account account;
	private Long amount;
	private Long balanceSnapshot;
	
	private String transactionId;
	private LocalDateTime transactedAt;
}
