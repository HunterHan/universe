package json.schema;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BaseJsonSchemaValidatorTest {

  private static Logger log = LoggerFactory.getLogger(BaseJsonSchemaValidatorTest.class);

  public static void main(String[] args) throws IOException, ProcessingException {

    final JsonNode fstabSchema = Utils.loadResource("/fstab.json");
    final JsonNode good = Utils.loadResource("/fstab-good.json");
    final JsonNode bad = Utils.loadResource("/fstab-bad.json");
    final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");

    final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

    final JsonSchema schema = factory.getJsonSchema(fstabSchema);

    ProcessingReport report;

    JSONObject json = new JSONObject();
    json.put("name", "han");
    json.put("age", "1");

    report = schema.validate(Utils.loadResource(json.toJSONString()));


    report = schema.validate(good);
    System.out.println(report);

    report = schema.validate(bad);
    System.out.println(report);

    report = schema.validate(bad2);
    System.out.println(report);

  }
}