package norman.minicapstone.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private int totalOrders;
    private int successOrders;

}
