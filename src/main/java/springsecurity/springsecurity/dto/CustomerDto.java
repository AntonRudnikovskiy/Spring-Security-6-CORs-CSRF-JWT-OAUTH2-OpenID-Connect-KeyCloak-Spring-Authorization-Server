package springsecurity.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerDto {
    private long id;
    private String email;
    private String pwd;
    private String role;
}
