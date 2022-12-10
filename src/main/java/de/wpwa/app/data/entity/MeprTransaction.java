package de.wpwa.app.data.entity;

import de.wpwa.app.data.AbstractEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "_mepr_transactions", indexes = {
        @Index(name = "tax_amount", columnList = "tax_amount"),
        @Index(name = "tax_compound", columnList = "tax_compound"),
        @Index(name = "amount", columnList = "amount"),
        @Index(name = "tax_class", columnList = "tax_class"),
        @Index(name = "created_at", columnList = "created_at"),
        @Index(name = "corporate_account_id", columnList = "corporate_account_id"),
        @Index(name = "tax_rate", columnList = "tax_rate"),
        @Index(name = "subscription_id", columnList = "subscription_id"),
        @Index(name = "tax_desc", columnList = "tax_desc"),
        @Index(name = "tax_shipping", columnList = "tax_shipping"),
        @Index(name = "total", columnList = "total"),
        @Index(name = "expires_at", columnList = "expires_at"),
        @Index(name = "coupon_id", columnList = "coupon_id"),
        @Index(name = "trans_num", columnList = "trans_num"),
        @Index(name = "txn_type", columnList = "txn_type"),
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "product_id", columnList = "product_id"),
        @Index(name = "parent_transaction_id", columnList = "parent_transaction_id"),
        @Index(name = "gateway", columnList = "gateway"),
        @Index(name = "prorated", columnList = "prorated"),
        @Index(name = "status", columnList = "status")
})
public class MeprTransaction extends AbstractEntity {
    @Column(name = "amount", nullable = false, precision = 16, scale = 2)
    private BigDecimal amount;

    @Column(name = "total", precision = 16, scale = 2)
    private BigDecimal total;

    @Column(name = "tax_amount", precision = 16, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "tax_rate", precision = 6, scale = 3)
    private BigDecimal taxRate;

    @Column(name = "tax_desc")
    private String taxDesc;

    @Column(name = "tax_compound")
    private Integer taxCompound;

    @Column(name = "tax_shipping")
    private Integer taxShipping;

    @Column(name = "tax_class")
    private String taxClass;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "trans_num")
    private String transNum;

    @Column(name = "status")
    private String status;

    @Column(name = "txn_type")
    private String txnType;

    @Lob
    @Column(name = "response")
    private String response;

    @Column(name = "gateway")
    private String gateway;

    @Column(name = "subscription_id")
    private Long subscriptionId;

    @Column(name = "prorated")
    private Boolean prorated;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "expires_at")
    private Instant expiresAt;

    @Column(name = "corporate_account_id")
    private Long corporateAccountId;

    @Column(name = "parent_transaction_id")
    private Long parentTransactionId;

    public Long getParentTransactionId() {
        return parentTransactionId;
    }

    public void setParentTransactionId(Long parentTransactionId) {
        this.parentTransactionId = parentTransactionId;
    }

    public Long getCorporateAccountId() {
        return corporateAccountId;
    }

    public void setCorporateAccountId(Long corporateAccountId) {
        this.corporateAccountId = corporateAccountId;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getProrated() {
        return prorated;
    }

    public void setProrated(Boolean prorated) {
        this.prorated = prorated;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public Integer getTaxShipping() {
        return taxShipping;
    }

    public void setTaxShipping(Integer taxShipping) {
        this.taxShipping = taxShipping;
    }

    public Integer getTaxCompound() {
        return taxCompound;
    }

    public void setTaxCompound(Integer taxCompound) {
        this.taxCompound = taxCompound;
    }

    public String getTaxDesc() {
        return taxDesc;
    }

    public void setTaxDesc(String taxDesc) {
        this.taxDesc = taxDesc;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}