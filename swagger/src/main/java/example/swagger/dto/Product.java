package example.swagger.dto;

/**
 * Created by Rimantas Jacikevičius on 18.6.23.
 */
public class Product {

    private String id;
    private String name;
    private Integer cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
