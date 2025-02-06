package com.willystw.librarysystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "checkout.config")
public class CheckoutConfiguration {
  private Long deadline;

  private Long dailyPenalty;

  public CheckoutConfiguration() {
  }

  public Long getDeadline() {
    return deadline;
  }

  public void setDeadline(Long deadline) {
    this.deadline = deadline;
  }

  public Long getDailyPenalty() {
    return dailyPenalty;
  }

  public void setDailyPenalty(Long dailyPenalty) {
    this.dailyPenalty = dailyPenalty;
  }
}
