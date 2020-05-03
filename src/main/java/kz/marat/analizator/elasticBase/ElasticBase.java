package kz.marat.analizator.elasticBase;

import kz.marat.analizator.model.AccountsForElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticBase extends ElasticsearchRepository<AccountsForElastic, Integer> {

}
