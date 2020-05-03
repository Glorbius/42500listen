package kz.marat.analizator.sqlBase;

import kz.marat.analizator.model.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface SqlBase extends CrudRepository<Accounts, Integer> {

}
