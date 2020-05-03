package kz.marat.analizator.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import kz.marat.analizator.elasticBase.ElasticBase;
import kz.marat.analizator.model.Accounts;
import kz.marat.analizator.model.AccountsForElastic;
import kz.marat.analizator.sqlBase.SqlBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;

@EnableKafka
@RestController
public class Controller {


    @Autowired
    private SqlBase sqlBase;

    @Autowired
    private ElasticBase elasticBase;


    @KafkaListener(topics = "addPeoples")
    public void realAdd(String json) throws IOException {
        addPeoplesToElastic(json);
        addPeoplesToSql(json);
    }


    public void addPeoplesToElastic(String accs) throws IOException {

        StringReader reader = new StringReader(accs);
        ObjectMapper mapper = new ObjectMapper();
        AccountsForElastic addMen = mapper.readValue(reader, AccountsForElastic.class);
        elasticBase.save(addMen);

    }


    public void addPeoplesToSql(String accs) throws IOException {

        StringReader reader = new StringReader(accs);
        ObjectMapper mapper = new ObjectMapper();
        Accounts addMen = mapper.readValue(reader, Accounts.class);
        sqlBase.save(addMen);

    }


}
