package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "city_id")
public class City {
    private int city_id;
    private String city_name;

}
