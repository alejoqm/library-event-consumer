package com.alejoqm.factory;

import com.alejoqm.service.DatabaseService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BookDatabaseFactory {

  private static Environment env;
  private static Map<String, DatabaseService> databaseServiceMap;

  private DatabaseService mongoDataBaseService;
  private DatabaseService mySqlDataBaseService;


  public BookDatabaseFactory(Environment env,
      @Qualifier("mongoDataBaseService") DatabaseService mongoDataBaseService,
      @Qualifier("mySqlDataBaseService") DatabaseService mySqlDataBaseService ) {
    BookDatabaseFactory.env = env;
    this.mongoDataBaseService = mongoDataBaseService;
    this.mySqlDataBaseService = mySqlDataBaseService;

    databaseServiceMap = new HashMap<String, DatabaseService>() {{
      put("mysql", mySqlDataBaseService);
      put("mongodb", mongoDataBaseService);
    }};
  }

  public static DatabaseService getDatabaseService() {
    DatabaseService databaseService = databaseServiceMap
        .getOrDefault(env.getActiveProfiles()[0], null);

    if(databaseService == null) {
      throw new RuntimeException("Not database set for this profiles");
    }
    return databaseService;
  }


}
