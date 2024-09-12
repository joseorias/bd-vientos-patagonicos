package tp.api;

import java.util.List;

import tp.model.Sale;

public interface SaleService {
    void create_sale(int id_client, List<Integer> products, int id_card);

    List<Sale> list_sales();

    double calc_total(List<Integer> products, int id_card);
}
