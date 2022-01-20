package dao;

import model.Acao;

/**
 *
 * @author icaro
 */
public class AcaoDAO extends GenericDAO<Acao, String>{
    
    public AcaoDAO(){
        super(Acao.class);
    }
}
