package io.dolphin.common.serializer.springfox;

import io.swagger.models.Operation;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.Parameter;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;

import java.util.List;

/**
 * @Description: 自定义Swagger 的序列化，去除分页参数中的records值
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:15
 */
public class SpringfoxJsonSerializer extends JsonSerializer {

    public SpringfoxJsonSerializer(List<JacksonModuleRegistrar> modules) {
        super(modules);
    }

    @Override
    public Json toJson(Object toSerialize) {
        if (!(toSerialize instanceof Swagger)) {
            return super.toJson(toSerialize);
        }
        Swagger swagger = (Swagger)toSerialize;

        swagger.getPaths().forEach((key, path) ->{
            Operation get = path.getGet();
            if (get != null) {

                List<Parameter> parameters = get.getParameters();
                if (parameters != null) {
                    parameters.removeIf(parameter -> parameter.getName().startsWith("records[0]."));
                }
            }
        });

        return super.toJson(swagger);
//        return super.toJson(toSerialize);
    }
}