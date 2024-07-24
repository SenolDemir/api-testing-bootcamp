package com.domain.pages;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {



    private static Map<Context, Object> scenarioContext = new HashMap<>();

    public static void setScenarioContext(Context key, Object value){
        scenarioContext.put(key, value);
    }

    public static Object getScenarioContext(Context key) {
        return scenarioContext.get(key);
    }


}
