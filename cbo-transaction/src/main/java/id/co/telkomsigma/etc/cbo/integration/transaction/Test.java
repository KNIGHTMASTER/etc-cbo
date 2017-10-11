package id.co.telkomsigma.etc.cbo.integration.transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 10/9/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class Test {

    public static void main(String args[]){
        Map<String, String> maps = new HashMap<>();
        maps.put("Key"+":"+"Key1"+",", "Value"+":"+"Value1");

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(maps));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
