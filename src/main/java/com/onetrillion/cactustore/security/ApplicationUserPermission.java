package com.onetrillion.cactustore.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write");

    private final String permission;
}
