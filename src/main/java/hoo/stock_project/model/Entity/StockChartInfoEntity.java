package hoo.stock_project.model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "stock_chart_info")
@Table(name = "stock_chart_info")
public class StockChartInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String ticker;
    @Column(nullable = false)
    private Long date;
    private Float open_price;
    private Float high_price;
    private Float low_price;
    private Float close_price;
    private Float ma20;
    private Float std;
    private Float upper;
    private Float lower;
}
