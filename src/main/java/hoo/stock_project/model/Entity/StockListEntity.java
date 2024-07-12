package hoo.stock_project.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "stock_list")
@Table(name = "stock_list")
public class StockListEntity {
    
    @Id
    private String ticker;
    private String name;
    private String industry;
}
