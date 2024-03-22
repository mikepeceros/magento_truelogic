package com.magento.utils;

import lombok.Data;

@Data
public class Order {

  private String orderNumber;
  private String mail;
  private String firstName;
  private String lastName;
  private String company;
  private String streetAddress;
  private String city;
  private String state;
  private String zip;
  private String country;
  private String phone;
}
