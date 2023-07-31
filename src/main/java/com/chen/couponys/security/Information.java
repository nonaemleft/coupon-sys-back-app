package com.chen.couponys.security;

import com.chen.couponys.login.ClientsType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information {

    private int id;
    private LocalDateTime time;
    private ClientsType clientTyp;
}
