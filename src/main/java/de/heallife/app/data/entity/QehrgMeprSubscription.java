package de.heallife.app.data.entity;

import de.heallife.app.data.AbstractEntity;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "QEhRG_mepr_subscriptions")
public class QehrgMeprSubscription extends AbstractEntity {
  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "product_id", nullable = false)
  private Long productId;

  @Column(name = "coupon_id")
  private Long couponId;

  @Column(name = "subscr_id")
  private String subscrId;

  @Column(name = "price", nullable = false, precision = 16, scale = 2)
  private BigDecimal price;

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

  @Column(name = "gateway")
  private String gateway;

  @Lob
  @Column(name = "response")
  private String response;

  @Column(name = "period")
  private Integer period;

  @Column(name = "period_type", length = 20)
  private String periodType;

  @Column(name = "limit_cycles")
  private Boolean limitCycles;

  @Column(name = "limit_cycles_num")
  private Integer limitCyclesNum;

  @Column(name = "limit_cycles_action")
  private String limitCyclesAction;

  @Column(name = "limit_cycles_expires_after")
  private Integer limitCyclesExpiresAfter;

  @Column(name = "limit_cycles_expires_type")
  private String limitCyclesExpiresType;

  @Column(name = "prorated_trial")
  private Boolean proratedTrial;

  @Column(name = "trial")
  private Boolean trial;

  @Column(name = "trial_days")
  private Integer trialDays;

  @Column(name = "trial_amount", precision = 16, scale = 2)
  private BigDecimal trialAmount;

  @Column(name = "trial_tax_amount", precision = 16, scale = 2)
  private BigDecimal trialTaxAmount;

  @Column(name = "trial_total", precision = 16, scale = 2)
  private BigDecimal trialTotal;

  @Column(name = "status", length = 20)
  private String status;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;

  @Column(name = "cc_last4", length = 10)
  private String ccLast4;

  @Column(name = "cc_exp_month", length = 10)
  private String ccExpMonth;

  @Column(name = "cc_exp_year", length = 10)
  private String ccExpYear;

  @Column(name = "token", length = 64)
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getCcExpYear() {
    return ccExpYear;
  }

  public void setCcExpYear(String ccExpYear) {
    this.ccExpYear = ccExpYear;
  }

  public String getCcExpMonth() {
    return ccExpMonth;
  }

  public void setCcExpMonth(String ccExpMonth) {
    this.ccExpMonth = ccExpMonth;
  }

  public String getCcLast4() {
    return ccLast4;
  }

  public void setCcLast4(String ccLast4) {
    this.ccLast4 = ccLast4;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigDecimal getTrialTotal() {
    return trialTotal;
  }

  public void setTrialTotal(BigDecimal trialTotal) {
    this.trialTotal = trialTotal;
  }

  public BigDecimal getTrialTaxAmount() {
    return trialTaxAmount;
  }

  public void setTrialTaxAmount(BigDecimal trialTaxAmount) {
    this.trialTaxAmount = trialTaxAmount;
  }

  public BigDecimal getTrialAmount() {
    return trialAmount;
  }

  public void setTrialAmount(BigDecimal trialAmount) {
    this.trialAmount = trialAmount;
  }

  public Integer getTrialDays() {
    return trialDays;
  }

  public void setTrialDays(Integer trialDays) {
    this.trialDays = trialDays;
  }

  public Boolean getTrial() {
    return trial;
  }

  public void setTrial(Boolean trial) {
    this.trial = trial;
  }

  public Boolean getProratedTrial() {
    return proratedTrial;
  }

  public void setProratedTrial(Boolean proratedTrial) {
    this.proratedTrial = proratedTrial;
  }

  public String getLimitCyclesExpiresType() {
    return limitCyclesExpiresType;
  }

  public void setLimitCyclesExpiresType(String limitCyclesExpiresType) {
    this.limitCyclesExpiresType = limitCyclesExpiresType;
  }

  public Integer getLimitCyclesExpiresAfter() {
    return limitCyclesExpiresAfter;
  }

  public void setLimitCyclesExpiresAfter(Integer limitCyclesExpiresAfter) {
    this.limitCyclesExpiresAfter = limitCyclesExpiresAfter;
  }

  public String getLimitCyclesAction() {
    return limitCyclesAction;
  }

  public void setLimitCyclesAction(String limitCyclesAction) {
    this.limitCyclesAction = limitCyclesAction;
  }

  public Integer getLimitCyclesNum() {
    return limitCyclesNum;
  }

  public void setLimitCyclesNum(Integer limitCyclesNum) {
    this.limitCyclesNum = limitCyclesNum;
  }

  public Boolean getLimitCycles() {
    return limitCycles;
  }

  public void setLimitCycles(Boolean limitCycles) {
    this.limitCycles = limitCycles;
  }

  public String getPeriodType() {
    return periodType;
  }

  public void setPeriodType(String periodType) {
    this.periodType = periodType;
  }

  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getGateway() {
    return gateway;
  }

  public void setGateway(String gateway) {
    this.gateway = gateway;
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

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getSubscrId() {
    return subscrId;
  }

  public void setSubscrId(String subscrId) {
    this.subscrId = subscrId;
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
}
