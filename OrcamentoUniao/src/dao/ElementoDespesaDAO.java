package dao;

import model.ElementoDespesa;
import model.ElementoDespesaPK;

/**
 *
 * @author icaro
 */
public class ElementoDespesaDAO extends GenericDAO<ElementoDespesa, ElementoDespesaPK> {

    public ElementoDespesaDAO() {
        super(ElementoDespesa.class);
    }
}
